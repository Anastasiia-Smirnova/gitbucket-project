resource "aws_elastic_beanstalk_application" "gitbucket" {
  name        = "${var.app_name}-${terraform.workspace}"
}

resource "aws_elastic_beanstalk_environment" "gitbucket_env" {
  name                = "${var.app_name}-${terraform.workspace}"
  application         = aws_elastic_beanstalk_application.gitbucket.name
  solution_stack_name = var.solution_name
  tier                = var.tier_name
  version_label       = aws_elastic_beanstalk_application_version.gitbucket_app_version.name

  setting {
    namespace = "aws:autoscaling:asg"
    name      = "MinSize"
    value     = var.instance_min_count
  }

  setting {
    namespace = "aws:autoscaling:asg"
    name      = "MaxSize"
    value     = var.instance_max_count
  }

  setting {
    namespace = "aws:autoscaling:launchconfiguration"
    name      = "InstanceType"
    value     = var.instance_type
  }

  setting {
    namespace = "aws:elasticbeanstalk:environment"
    name      = "ServiceRole"
    value     = var.service_role_arn
  }

  setting {
    namespace = "aws:elasticbeanstalk:environment"
    name      = "LoadBalancerType"
    value     = var.lb_type
  }

  setting {
    namespace = "aws:autoscaling:launchconfiguration"
    name      = "IamInstanceProfile"
#    value     = aws_iam_instance_profile.gitbucket_eb_ec2_instance_profile.name
    value     = var.instance_profile_name
  }

  setting {
    namespace = "aws:ec2:vpc"
    name      = "VPCId"
#    value     = aws_vpc.gitbucket_vpc.id
    value     = var.vpc_id 
  }

  setting {
    namespace = "aws:ec2:vpc"
    name      = "Subnets"
#    value     = join(",", [aws_subnet.gitbucket_appsubnet_01.id, aws_subnet.gitbucket_appsubnet_02.id])
    value     = local.app_subnets
  }

  setting {
    namespace = "aws:autoscaling:launchconfiguration"
    name      = "SecurityGroups"
#    value     = aws_security_group.gitbucket_appsrv_sg.id
    value     =  var.app_security_group_id
  }

  setting {
    namespace = "aws:ec2:vpc"
    name      = "ELBScheme"
    value     = var.elb_scheme_type
  }

  setting {
    namespace = "aws:ec2:vpc"
    name      = "ELBSubnets"
#    value     = join(",", [aws_subnet.gitbucket_publicsubnet_01.id, aws_subnet.gitbucket_publicsubnet_02.id])
    value     = local.elb_subnets
  }

  setting {
    namespace = "aws:elasticbeanstalk:application:environment"
    name      = "DB_NAME"
    value     = var.db_name
  }

  setting {
    namespace = "aws:elasticbeanstalk:application:environment"
    name      = "DB_PASSWORD"
    value     = jsondecode(data.aws_secretsmanager_secret_version.mysql_secret_version.secret_string)["password"]
  }

  setting {
    namespace = "aws:elasticbeanstalk:application:environment"
    name      = "DB_URL"
    value     = "jdbc:mysql://${var.db_endpoint}/${var.db_name}?useUnicode=true&characterEncoding=utf8&allowPublicKeyRetrieval=true&serverRsaPublicKeyFile=/gitbucket/public_key.pem"
  }

  setting {
    namespace = "aws:elasticbeanstalk:application:environment"
    name      = "DB_USER"
    value     = jsondecode(data.aws_secretsmanager_secret_version.mysql_secret_version.secret_string)["username"]
  }

  setting {
    namespace = "aws:elasticbeanstalk:application:environment"
    name      = "GRADLE_HOME"
    value     = "/usr/local/gradle"
  }

  setting {
    namespace = "aws:elasticbeanstalk:application:environment"
    name      = "M2"
    value     = var.m2
  }

  setting {
    namespace = "aws:elasticbeanstalk:application:environment"
    name      = "M2_HOME"
    value     = var.m2_home
  }

  setting {
    namespace = "aws:elasticbeanstalk:application:environment"
    name      = "PORT"
    value     = var.app_port
  }

  setting {
    namespace = "aws:autoscaling:launchconfiguration"
    name      = "EC2KeyName"
    value     = var.ec2_key_name
  }
}

resource "aws_elastic_beanstalk_application_version" "gitbucket_app_version" {
  name        = "${var.gitbucket_version}-${terraform.workspace}"
  application = aws_elastic_beanstalk_application.gitbucket.name
  description = "Application version"
  bucket      = var.app_s3_bucket
  key         = "${terraform.workspace}/gitbucket_${var.gitbucket_version}.war"
}

data "aws_secretsmanager_secret" "mysql_secret" {
  name = local.mysql_secret_name
}

data "aws_secretsmanager_secret_version" "mysql_secret_version" {
  secret_id = data.aws_secretsmanager_secret.mysql_secret.id
}

resource "aws_sns_topic" "ebs_notifications" {
  name = "${var.ebs_notifications_topic}-${terraform.workspace}"
}

resource "aws_sns_topic_subscription" "ebs_email_subscription" {
  topic_arn = aws_sns_topic.ebs_notifications.arn
  protocol  = "email"
  endpoint  = var.ebs_email
}
