resource "aws_iam_role" "gitbucket_eb_ec2_iam_role" {
  name = "${var.app_iam_role}-${terraform.workspace}"

  assume_role_policy = jsonencode({
    Version = "2012-10-17"
    Statement = [
      {
        Action = "sts:AssumeRole"
        Effect = "Allow"
        Principal = {
          Service = "ec2.amazonaws.com"
        }
      },
    ]
  })
}

# Attach the AWS managed policies for Elastic Beanstalk WebTier, WorkerTier, and MulticontainerDocker
resource "aws_iam_role_policy_attachment" "eb_web_tier" {
  role       = aws_iam_role.gitbucket_eb_ec2_iam_role.name
  policy_arn = var.eb_web_tier_policy_arn
}

resource "aws_iam_role_policy_attachment" "eb_worker_tier" {
  role       = aws_iam_role.gitbucket_eb_ec2_iam_role.name
  policy_arn = var.eb_worker_tier_policy_arn
}

resource "aws_iam_role_policy_attachment" "eb_multicontainer_docker" {
  role       = aws_iam_role.gitbucket_eb_ec2_iam_role.name
  policy_arn = var.eb_multicontainer_docker_policy_arn
}

resource "aws_iam_policy" "gitbucket_s3_war_access" {
  name        = "${var.gitbucket_s3_war_access_policy}-${terraform.workspace}"
  description = "Allow Elastic Beanstalk instances to retrieve WAR file from S3"

  policy = jsonencode({
    Version = "2012-10-17",
    Statement = [
      {
        Effect = "Allow",
        Action = "s3:GetObject",
        Resource = "arn:aws:s3:::elasticbeanstalk-eu-central-1-538547716265/gitbucket.war"
      },
    ],
  })
}

resource "aws_iam_role_policy_attachment" "gitbucket_s3_war_access_attachment" {
  role       = aws_iam_role.gitbucket_eb_ec2_iam_role.name
  policy_arn = aws_iam_policy.gitbucket_s3_war_access.arn
}

resource "aws_iam_policy" "gitbucket_rds_access" {
  name        = "${var.gitbucket_rds_access_policy}-${terraform.workspace}"
  description = "Allow Elastic Beanstalk instances to access RDS instances"

  policy = jsonencode({
    Version = "2012-10-17",
    Statement = [
      {
        Effect = "Allow",
        Action = [
          "rds:DescribeDBInstances",
          "rds:DescribeDBClusters",
          "rds:Connect"
        ],
        Resource = "*"
      }
    ],
  })
}

resource "aws_iam_role_policy_attachment" "gitbucket_rds_access_attachment" {
  role       = aws_iam_role.gitbucket_eb_ec2_iam_role.name
  policy_arn = aws_iam_policy.gitbucket_rds_access.arn
}

resource "aws_iam_instance_profile" "gitbucket_eb_ec2_instance_profile" {
  name = "${var.gitbucket_instance_profile}-${terraform.workspace}"
  role = aws_iam_role.gitbucket_eb_ec2_iam_role.name
}

resource "aws_iam_role_policy" "gitbucket-eb-ec2-secrets-policy" {
  name = "${var.gitbucket_secrets_policy}-${terraform.workspace}"
  role = aws_iam_role.gitbucket_eb_ec2_iam_role.id

  policy = jsonencode({
    "Version": "2012-10-17",
	  "Statement": [
		  {
			  "Effect": "Allow",
			  "Action": "secretsmanager:GetSecretValue",
		  	"Resource": "arn:aws:secretsmanager:eu-central-1:538547716265:secret:gitbucket/mysql/creds-y7slpF"
		  }
	  ],
  })
}