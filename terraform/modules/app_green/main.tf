resource "aws_instance" "gitbucket_instance_green" {
  count                       = length(local.app_subnets)
  ami                         = "ami-0f7204385566b32d0"
  instance_type               = "t2.micro"
  subnet_id                   = local.app_subnets[count.index]
  security_groups             = [var.app_security_group_id]
  iam_instance_profile        = var.instance_profile_name
  key_name                    = "gitbucket-ssh" 
  associate_public_ip_address = true

  credit_specification {
    cpu_credits = "unlimited"
  }

  tags = {
    Name = "${var.app_name}-${terraform.workspace}-instance"
    Environment = "green"
  }
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
