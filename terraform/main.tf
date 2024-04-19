module "gitbucket_network" {
  source                 = "./modules/network"
  ec2_instance_ids_blue  = module.gitbucket_app_blue.ec2_instance_ids_blue
  ec2_instance_ids_green = module.gitbucket_app_green.ec2_instance_ids_green
  active_environment     = var.active_environment
}

module "gitbucket_iam" {
  source = "./modules/iam"
}

module "gitbucket_db" {
  source               = "./modules/db"
  db_security_group_id = module.gitbucket_network.db_security_group_id
  db_subnet_01_id      = module.gitbucket_network.db_subnet_01_id
  db_subnet_02_id      = module.gitbucket_network.db_subnet_02_id
}

module "gitbucket_app_blue" {
  source                  = "./modules/app_blue"
  instance_tag            = "blue"

  instance_profile_name   = module.gitbucket_iam.instance_profile_name
  app_iam_role            = module.gitbucket_iam.app_iam_role
  vpc_id                  = module.gitbucket_network.vpc_id
  app_subnet_01_id        = module.gitbucket_network.app_subnet_01_id
  app_subnet_02_id        = module.gitbucket_network.app_subnet_02_id
  app_public_subnet_01_id = module.gitbucket_network.app_public_subnet_01_id
  app_public_subnet_02_id = module.gitbucket_network.app_public_subnet_02_id
  app_security_group_id   = module.gitbucket_network.app_security_group_id
  db_endpoint             = module.gitbucket_db.db_endpoint
  instance_count_blue     = module.gitbucket_app_blue.instance_count_blue
#  gitbucket_version       = var.gitbucket_version
}

module "gitbucket_app_green" {
  source                  = "./modules/app_green"
  instance_tag            = "green"

  instance_profile_name   = module.gitbucket_iam.instance_profile_name
  app_iam_role            = module.gitbucket_iam.app_iam_role
  vpc_id                  = module.gitbucket_network.vpc_id
  app_subnet_01_id        = module.gitbucket_network.app_subnet_01_id
  app_subnet_02_id        = module.gitbucket_network.app_subnet_02_id
  app_public_subnet_01_id = module.gitbucket_network.app_public_subnet_01_id
  app_public_subnet_02_id = module.gitbucket_network.app_public_subnet_02_id
  app_security_group_id   = module.gitbucket_network.app_security_group_id
  db_endpoint             = module.gitbucket_db.db_endpoint
  instance_count_green    = module.gitbucket_app_green.instance_count_green
#  gitbucket_version       = var.gitbucket_version
}