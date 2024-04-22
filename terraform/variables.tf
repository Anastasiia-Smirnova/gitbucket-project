variable "gitbucket_version" {
  type    = string
  default = "1"
}

variable "active_environment" {
  type    = string
  default = "blue"
}

variable "instance_count_blue" {
  type        = number
  default     = 2
}

variable "instance_count_green" {
  type        = number
  default     = 2
}