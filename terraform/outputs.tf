#output "ec2_instance_ips_blue" {
#  value = module.gitbucket_app_blue.ec2_instance_ips
#}

output "ec2_instance_ids_blue" {
  value = module.gitbucket_app_blue.ec2_instance_ids_blue
}

output "ec2_instance_ids_green" {
  value = module.gitbucket_app_green.ec2_instance_ids_green
}

output "db_endpoint" {
  value = module.gitbucket_db.db_endpoint
}

output "instance_count_blue" {
  module.gitbucket_app_blue.instance_count_blue
}

output "instance_count_green" {
  module.gitbucket_app_green.instance_count_green
}
