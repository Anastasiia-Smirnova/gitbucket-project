resource "aws_elastic_beanstalk_application" "gitbucket" {
  name        = "gitbucket"
}

resource "aws_elastic_beanstalk_environment" "gitbucket-env" {
  name                = "gitbucket-env"
  application         = aws_elastic_beanstalk_application.gitbucket.name
  solution_stack_name = "64bit Amazon Linux 2023 v4.2.1 running Corretto 11"
  tier                = "WebServer"
  version_label       = aws_elastic_beanstalk_application_version.gitbucket_app_version.name

  setting {
    namespace = "aws:autoscaling:asg"
    name      = "MinSize"
    value     = "1"
  }

  setting {
    namespace = "aws:autoscaling:asg"
    name      = "MaxSize"
    value     = "2"
  }

  setting {
    namespace = "aws:autoscaling:launchconfiguration"
    name      = "InstanceType"
    value     = "t3.small" 
  }

  setting {
    namespace = "aws:elasticbeanstalk:environment"
    name      = "ServiceRole"
    value     = "arn:aws:iam::538547716265:role/service-role/aws-elasticbeanstalk-service-role"
  }

  setting {
    namespace = "aws:elasticbeanstalk:environment"
    name      = "LoadBalancerType"
    value     = "application"
  }

  setting {
    namespace = "aws:autoscaling:launchconfiguration"
    name      = "IamInstanceProfile"
    value     = aws_iam_instance_profile.gitbucket_eb_ec2_instance_profile.name
  }

  setting {
    namespace = "aws:ec2:vpc"
    name      = "VPCId"
    value     = aws_vpc.gitbucket_vpc.id
  }

  setting {
    namespace = "aws:ec2:vpc"
    name      = "Subnets"
    value     = join(",", [aws_subnet.gitbucket-appsubnet-01.id, aws_subnet.gitbucket-appsubnet-02.id])
  }

  setting {
    namespace = "aws:autoscaling:launchconfiguration"
    name      = "SecurityGroups"
    value     = aws_security_group.gitbucket-appsrv-sg.id
  }

  setting {
    namespace = "aws:ec2:vpc"
    name      = "ELBScheme"
    value     = "public"
  }

  setting {
    namespace = "aws:ec2:vpc"
    name      = "ELBSubnets"
    value     = join(",", [aws_subnet.gitbucket-publicsubnet-01.id, aws_subnet.gitbucket-publicsubnet-02.id])
  }

  setting {
    namespace = "aws:elasticbeanstalk:application:environment"
    name      = "DB_NAME"
    value     = "gitbucketdb"
  }

  setting {
    namespace = "aws:elasticbeanstalk:application:environment"
    name      = "DB_PASSWORD"
    value     = "srEai35Fs6NeU7i"
  }

  setting {
    namespace = "aws:elasticbeanstalk:application:environment"
    name      = "DB_URL"
    value     = "jdbc:mysql://${aws_db_instance.gitbucket_mysql.endpoint}/gitbucket?useUnicode=true&characterEncoding=utf8&allowPublicKeyRetrieval=true&serverRsaPublicKeyFile=/gitbucket/public_key.pem"
  }

  setting {
    namespace = "aws:elasticbeanstalk:application:environment"
    name      = "DB_USER"
    value     = "admin"
  }

  setting {
    namespace = "aws:elasticbeanstalk:application:environment"
    name      = "GRADLE_HOME"
    value     = "usr/local/gradle"
  }

  setting {
    namespace = "aws:elasticbeanstalk:application:environment"
    name      = "M2"
    value     = "usr/local/apache-maven/bin"
  }

  setting {
    namespace = "aws:elasticbeanstalk:application:environment"
    name      = "M2_HOME"
    value     = "usr/local/apache-maven"
  }

  setting {
    namespace = "aws:elasticbeanstalk:application:environment"
    name      = "PORT"
    value     = "8080"
  }

  setting {
    namespace = "aws:autoscaling:launchconfiguration"
    name      = "EC2KeyName"
    value     = "gitbucket-ssh"
  }
}

resource "aws_elastic_beanstalk_application_version" "gitbucket_app_version" {
  name        = var.gitbucket_version
  application = aws_elastic_beanstalk_application.gitbucket.name
  description = "Initial version"
  bucket = "elasticbeanstalk-eu-central-1-538547716265"
  key    = "gitbucket-2.war"
}

data "aws_secretsmanager_secret" "mysql_secret" {
  name = "gitbucket/mysql/cred"
}

data "aws_secretsmanager_secret_version" "mysql_secret_version" {
  secret_id = data.aws_secretsmanager_secret.mysql_secret.id
}

resource "aws_sns_topic" "ebs_notifications" {
  name = "ebs-notifications-topic"
}

resource "aws_sns_topic_subscription" "ebs_email_subscription" {
  topic_arn = aws_sns_topic.ebs_notifications.arn
  protocol  = "email"
  endpoint  = "anastasia.smirnova96@gmail.com" 
}

variable "gitbucket_version" {
  type = string
}
