output "ec2_instance_ips_blue" {
  value = aws_instance.gitbucket_instance_blue.*.public_ip
}

output "ec2_instance_ids_blue" {
  value = aws_instance.gitbucket_instance_blue.*.id
}
