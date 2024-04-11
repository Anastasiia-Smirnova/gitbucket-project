output "ec2_instance_ips" {
  value = module.gitbucket_app.ec2_instance_ips
}

output "ec2_instance_ids" {
  value = module.gitbucket_app.ec2_instance_ids
}

output "db_endpoint" {
  value = module.gitbucket_db.db_endpoint
}
