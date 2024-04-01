resource "aws_db_subnet_group" "gitbucket_dbsubnetgroup" {
  name        = "${var.db_subnet_group_name}-${terraform.workspace}"
  description = "DB subnet group for GitBucket RDS instances"
  subnet_ids  = [var.db_subnet_01_id, var.db_subnet_02_id]

  tags = {
    Name = var.db_subnet_group_name
  }
}

resource "aws_db_instance" "gitbucket_mysql" {
  identifier           = "${var.db_name}-${terraform.workspace}"
  allocated_storage    = var.db_allocated_storage
  engine               = var.db_engine
  engine_version       = var.db_engine_version
  instance_class       = var.db_instance_class
  db_name              = var.db_name
  username             = jsondecode(data.aws_secretsmanager_secret_version.mysql_secret_version.secret_string)["username"]
  password             = jsondecode(data.aws_secretsmanager_secret_version.mysql_secret_version.secret_string)["password"]
  skip_final_snapshot  = var.db_skip_final_snapshot
  publicly_accessible  = var.db_publicly_accessible

#  vpc_security_group_ids = [aws_security_group.gitbucket-database-sg.id]
#  db_subnet_group_name = aws_db_subnet_group.gitbucket_dbsubnetgroup.name

  vpc_security_group_ids = [var.db_security_group_id]
  db_subnet_group_name = aws_db_subnet_group.gitbucket_dbsubnetgroup.name

  tags = {
    Name = "${var.db_name}-${terraform.workspace}"
  }
}

data "aws_secretsmanager_secret" "mysql_secret" {
  name = var.mysql_secret_name
}

data "aws_secretsmanager_secret_version" "mysql_secret_version" {
  secret_id = data.aws_secretsmanager_secret.mysql_secret.id
}