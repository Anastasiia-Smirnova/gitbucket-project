locals {
  app_subnets = join(",", [var.app_subnet_01_id, var.app_subnet_02_id])
  elb_subnets = join(",", [var.app_public_subnet_01_id, var.app_public_subnet_02_id])
}

locals {
  mysql_secret_name = "gitbucket/mysql/cred"
}
