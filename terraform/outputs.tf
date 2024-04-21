output "ec2_instance_ips_blue" {
  value = module.gitbucket_app_blue.ec2_instance_ips_blue
}

output "ec2_instance_ips_green" {
  value = module.gitbucket_app_green.ec2_instance_ips_green
}

output "ec2_instance_ids_blue" {
  value = module.gitbucket_app_blue.ec2_instance_ids_blue
}

output "ec2_instance_ids_green" {
  value = module.gitbucket_app_green.ec2_instance_ids_green
}

output "db_endpoint" {
  value = module.gitbucket_db.db_endpoint
}

output "active_environment" {
  value = var.active_environment
}
