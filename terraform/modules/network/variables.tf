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
