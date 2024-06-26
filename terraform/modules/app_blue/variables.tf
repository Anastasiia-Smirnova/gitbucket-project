variable "instance_profile_name" {
  type = string
}

variable "instance_tag" {
  type        = string
}

variable "instance_count_blue" {
  type        = number
  default     = 2
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
