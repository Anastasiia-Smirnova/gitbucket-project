output "ec2_instance_ips" {
  value = aws_instance.gitbucket_instance.*.public_ip
}
