variable "db_security_group_name" {
  type    = string
  default = "gitbucket-database-sg"
}

variable "app_security_group_name" {
  type    = string
  default = "gitbucket-appsrv-sg"
}

variable "app_name" {
  type    = string
  default = "gitbucket"
}

variable "ec2_instance_ids_blue" {
  type    = list(string)
}

variable "ec2_instance_ids_green" {
  type    = list(string)
}

variable "active_environment" {
  type    = string
  default = "blue"
}
