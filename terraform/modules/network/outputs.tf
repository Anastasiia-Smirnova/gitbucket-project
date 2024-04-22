output "vpc_id" {
  value = aws_vpc.gitbucket_vpc.id
}

output "app_subnet_01_id" {
  value = aws_subnet.gitbucket_appsubnet_01.id
}

output "app_subnet_02_id" {
  value = aws_subnet.gitbucket_appsubnet_02.id
}

output "app_public_subnet_01_id" {
  value = aws_subnet.gitbucket_publicsubnet_01.id
}

output "app_public_subnet_02_id" {
  value = aws_subnet.gitbucket_publicsubnet_02.id
}

output "app_security_group_id" {
  value = aws_security_group.gitbucket_appsrv_sg.id
}

output "db_security_group_id" {
  value = aws_security_group.gitbucket_database_sg.id
}

output "db_subnet_01_id" {
  value = aws_subnet.gitbucket_datasubnet_01.id
}

output "db_subnet_02_id" {
  value = aws_subnet.gitbucket_datasubnet_02.id
}
