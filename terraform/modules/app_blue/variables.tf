variable "instance_profile_name" {
  type = string
}

variable "vpc_id" {
  type = string
}

variable "app_subnet_01_id" {
  type = string
}

variable "app_subnet_02_id" {
  type = string
}

variable "app_public_subnet_01_id" {
  type = string
}

variable "app_iam_role" {
  type        = string
}

variable "app_public_subnet_02_id" {
  type = string
}

variable "app_security_group_id" {
  type = string
}

variable "app_name" {
  type    = string
  default = "gitbucket"
}

variable "app_env" {
  type    = string
  default = "dev"
}

#variable "instance_min_count" {
#  type    = string
#  default = "1"
#}

#variable "instance_max_count" {
#  type    = string
#  default = "2"
#}

#variable "instance_type" {
#  type    = string
#  default = "t3.small"
#}

#variable "service_role_arn" {
#  type    = string
#  default = "arn:aws:iam::538547716265:role/service-role/aws-elasticbeanstalk-service-role"
#}

variable "elb_scheme_type" {
  type    = string
  default = "public"
}

variable "lb_type" {
  type    = string
  default = "application"
}

variable "db_name" {
  type    = string
  default = "gitbucket"
}

variable "db_endpoint" {
  type    = string
}

variable "db_user" {
  type    = string
  default = "admin"
}

variable "db_password" {
  type    = string
  default = "srEai35Fs6NeU7i"
}

#variable "gradle_home" {
#  type    = string
#  default = "/usr/local/gradle"
#}

#variable "m2_home" {
#  type    = string
#  default = "/usr/local/apache-maven"
#}

#variable "m2" {
#  type    = string
#  default = "/usr/local/apache-maven/bin"
#}

variable "app_port" {
  type    = string
  default = "8080"
}

variable "ec2_key_name" {
  type    = string
  default = "gitbucket-ssh"
}

variable "app_s3_bucket" {
  type    = string
  default = "elasticbeanstalk-eu-central-1-538547716265"
}

variable "ebs_notifications_topic" {
  type    = string
  default = "ebs-notifications-topic"
}

variable "ebs_email" {
  type    = string
  default = "anastasia.smirnova96@gmail.com"
}

variable "solution_name" {
  type    = string
  default = "64bit Amazon Linux 2023 v4.2.1 running Corretto 11"
}

#variable "tier_name" {
#  type    = string
#  default = "WebServer"
#}

#variable "gitbucket_version" {
#  type    = string
#  default = "1"
#}
