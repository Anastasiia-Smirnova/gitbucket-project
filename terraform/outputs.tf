output "ec2_instance_ips" {
  value = module.gitbucket_app.ec2_instance_ips
}

output "ec2_instance_ids_blue" {
  value = module.gitbucket_app.ec2_instance_ids_blue
}

output "ec2_instance_ids_green" {
  value = module.gitbucket_app.ec2_instance_ids_green
}

output "db_endpoint" {
  value = module.gitbucket_db.db_endpoint
}
