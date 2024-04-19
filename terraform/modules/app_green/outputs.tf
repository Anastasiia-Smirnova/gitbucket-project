output "ec2_instance_ips_green" {
  value = aws_instance.gitbucket_instance_green.*.public_ip
}

output "ec2_instance_ids_green" {
  value = aws_instance.gitbucket_instance_green.*.id
}
