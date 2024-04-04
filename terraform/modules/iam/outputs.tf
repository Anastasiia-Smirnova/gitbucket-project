output "instance_profile_name" {
  value = aws_iam_instance_profile.gitbucket_ec2_instance_profile.name
}

output "app_iam_role" {
  value = aws_iam_role.gitbucket_ec2_iam_role.arn
}
