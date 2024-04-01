variable "app_iam_role" {
  type    = string
  default = "gitbucket-eb-ec2-iam-role"
}

variable "eb_web_tier_policy_arn" {
  type    = string
  default = "arn:aws:iam::aws:policy/AWSElasticBeanstalkWebTier"
}

variable "eb_worker_tier_policy_arn" {
  type    = string
  default = "arn:aws:iam::aws:policy/AWSElasticBeanstalkWorkerTier"
}

variable "eb_multicontainer_docker_policy_arn" {
  type    = string
  default = "arn:aws:iam::aws:policy/AWSElasticBeanstalkMulticontainerDocker"
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
