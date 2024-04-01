variable "db_subnet_01_id" {
  type = string
}

variable "db_subnet_02_id" {
  type = string
}

variable "db_security_group_id" {
  type = string
}

variable "gitbucket_version" {
  type    = string
  default = "1"
}

variable "db_subnet_group_name" {
  type    = string
  default = "gitbucket_dbsubnetgroup"
}

variable "mysql_secret_name" {
  type    = string
  default = "gitbucket/mysql/cred"
}

variable "db_name" {
  type    = string
  default = "gitbucket"
}

variable "db_instance_class" {
  type    = string
  default = "db.t3.micro"
}

variable "db_engine_version" {
  type    = string
  default = "8.0.32"
}

variable "db_engine" {
  type    = string
  default = "mysql"
}

variable "db_allocated_storage" {
  type    = number
  default = 20
}

variable "db_skip_final_snapshot" {
  type    = bool
  default = true
}

variable "db_publicly_accessible" {
  type    = bool
  default = false
}
