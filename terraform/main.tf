module "gitbucket_network" {
  source                  = "./modules/network"
}

module "gitbucket_iam" {
  source                  = "./modules/iam"
}

module "gitbucket_db" {
  source                  = "./modules/db"
  db_security_group_id    = module.gitbucket_network.db_security_group_id 
  db_subnet_01_id         = module.gitbucket_network.db_subnet_01_id
  db_subnet_02_id         = module.gitbucket_network.db_subnet_02_id
}

module "gitbucket_app" {
  source                  = "./modules/app"

  instance_profile_name   = module.gitbucket_iam.app_instance_profile
  vpc_id                  = module.gitbucket_network.vpc_id
  app_subnet_01_id        = module.gitbucket_network.app_subnet_01_id
  app_subnet_02_id        = module.gitbucket_network.app_subnet_02_id
  app_public_subnet_01_id = module.gitbucket_network.app_public_subnet_01_id
  app_public_subnet_02_id = module.gitbucket_network.app_public_subnet_02_id
  app_security_group_id   = module.gitbucket_network.app_security_group_id
  db_endpoint             = module.gitbucket_db.db_endpoint
  gitbucket_version       = var.gitbucket_version
}
