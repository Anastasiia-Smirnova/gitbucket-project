resource "aws_db_subnet_group" "gitbucket_dbsubnetgroup" {
  name        = "gitbucket_dbsubnetgroup"
  description = "DB subnet group for GitBucket RDS instances"
  subnet_ids  = [aws_subnet.gitbucket-datasubnet-01.id, aws_subnet.gitbucket-datasubnet-02.id]

  tags = {
    Name = "gitbucket_dbsubnetgroup"
  }
}

resource "aws_db_instance" "gitbucket_mysql" {
  identifier = "gitbucket"
  allocated_storage    = 20
  engine               = "mysql"
  engine_version       = "8.0.32" 
  instance_class       = "db.t3.micro" 
  db_name              = "gitbucket"
  username             = jsondecode(data.aws_secretsmanager_secret_version.mysql_secret_version.secret_string)["username"]
  password             = jsondecode(data.aws_secretsmanager_secret_version.mysql_secret_version.secret_string)["password"]
  skip_final_snapshot  = true
  publicly_accessible  = false

  vpc_security_group_ids = [aws_security_group.gitbucket-database-sg.id]
  db_subnet_group_name = aws_db_subnet_group.gitbucket_dbsubnetgroup.name

  tags = {
    Name = "gitbucket_mysql"
  }
}
