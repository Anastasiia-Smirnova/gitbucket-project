variable "app_iam_role" {
  type    = string
  default = "gitbucket-eb-ec2-iam-role"
}

variable "gitbucket_s3_war_access_policy" {
  type    = string
  default = "gitbucket-s3-war-access"
}

variable "gitbucket_rds_access_policy" {
  type    = string
  default = "gitbucket-rds-access"
}

variable "gitbucket_instance_profile" {
  type    = string
  default = "gitbucket-eb-ec2-instance-profile"
}

variable "gitbucket_secrets_policy" {
  type    = string
  default = "gitbucket-eb-ec2-secrets-policy"
}
