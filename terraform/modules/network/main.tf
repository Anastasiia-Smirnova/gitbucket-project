resource "aws_vpc" "gitbucket_vpc" {
  cidr_block = "10.0.0.0/16" 
  tags = {
    Name = "${var.app_name}-${terraform.workspace}-vpc"
  }
}

resource "aws_internet_gateway" "gitbucket_igw" {
  vpc_id = aws_vpc.gitbucket_vpc.id

  tags = {
    Name = "${var.app_name}-${terraform.workspace}-igw"
  }
}

resource "aws_subnet" "gitbucket_publicsubnet_01" {
  vpc_id     = aws_vpc.gitbucket_vpc.id
  cidr_block = "10.0.1.0/24"
  availability_zone = "eu-central-1a"
  tags = {
    Name = "${var.app_name}-${terraform.workspace}-publicsubnet-01"
  }
}
resource "aws_subnet" "gitbucket_publicsubnet_02" {
  vpc_id     = aws_vpc.gitbucket_vpc.id
  cidr_block = "10.0.2.0/24"
  availability_zone = "eu-central-1b"
  tags = {
    Name = "${var.app_name}-${terraform.workspace}-publicsubnet-02"
  }
}
resource "aws_subnet" "gitbucket_appsubnet_01" {
  vpc_id     = aws_vpc.gitbucket_vpc.id
  cidr_block = "10.0.10.0/24"
  availability_zone = "eu-central-1a"
  tags = {
    Name = "${var.app_name}-${terraform.workspace}-appsubnet-01"
  }
}
resource "aws_subnet" "gitbucket_appsubnet_02" {
  vpc_id     = aws_vpc.gitbucket_vpc.id
  cidr_block = "10.0.11.0/24"
  availability_zone = "eu-central-1b"
  tags = {
    Name = "${var.app_name}-${terraform.workspace}-appsubnet-02"
  }
}
resource "aws_subnet" "gitbucket_datasubnet_01" {
  vpc_id     = aws_vpc.gitbucket_vpc.id
  cidr_block = "10.0.20.0/24"
  availability_zone = "eu-central-1a"
  tags = {
    Name = "${var.app_name}-${terraform.workspace}-datasubnet-01"
  }
}
resource "aws_subnet" "gitbucket_datasubnet_02" {
  vpc_id     = aws_vpc.gitbucket_vpc.id
  cidr_block = "10.0.21.0/24"
  availability_zone = "eu-central-1b"
  tags = {
    Name = "${var.app_name}-${terraform.workspace}-datasubnet-02"
  }
}

#resource "aws_network_interface" "gitbucket_network_interface_01" {
#  subnet_id       = aws_subnet.gitbucket_appsubnet_01.id
#  security_groups = [aws_security_group.gitbucket_appsrv_sg.id]
#  
#  tags = {
#    Name = "${var.app_name}-${terraform.workspace}-network-interface-01"
#  }
#}

#resource "aws_network_interface" "gitbucket_network_interface_02" {
#  subnet_id       = aws_subnet.gitbucket_appsubnet_02.id
#  security_groups = [aws_security_group.gitbucket_appsrv_sg.id]
#  
#  tags = {
#    Name = "${var.app_name}-${terraform.workspace}-network-interface-02"
#  }
#}

resource "aws_route_table" "gitbucket_publicRT" {
  vpc_id = aws_vpc.gitbucket_vpc.id

  route {
    cidr_block = "0.0.0.0/0"
    gateway_id = aws_internet_gateway.gitbucket_igw.id
  }

  tags = {
    Name = "${var.app_name}_${terraform.workspace}-publicRT"
  }
}

resource "aws_route_table_association" "gitbucket_publicRT_association1" {
  subnet_id      = aws_subnet.gitbucket_publicsubnet_01.id
  route_table_id = aws_route_table.gitbucket_publicRT.id
}

resource "aws_route_table_association" "gitbucket_publicRT_association2" {
  subnet_id      = aws_subnet.gitbucket_publicsubnet_02.id
  route_table_id = aws_route_table.gitbucket_publicRT.id
}

resource "aws_default_route_table" "default" {
  default_route_table_id = aws_vpc.gitbucket_vpc.default_route_table_id

  route {
    cidr_block     = "0.0.0.0/0"
#    nat_gateway_id = aws_nat_gateway.gitbucket_natgw.id
    gateway_id = aws_internet_gateway.gitbucket_igw.id
  }

  tags = {
    Name = "${var.app_name}-${terraform.workspace}-mainRT"
  }
}

resource "aws_eip" "gitbucket_nat_eip" {
  domain = "vpc"

  tags = {
    Name = "${var.app_name}-${terraform.workspace}-nat-eip"
  }
}

resource "aws_nat_gateway" "gitbucket_natgw" {
  allocation_id = aws_eip.gitbucket_nat_eip.id
  subnet_id     = aws_subnet.gitbucket_publicsubnet_01.id

  tags = {
    Name = "${var.app_name}-${terraform.workspace}-natgw"
  }

  depends_on = [aws_internet_gateway.gitbucket_igw]
}

resource "aws_lb" "gitbucket_lb" {
  name               = "gitbucket-load-balancer"
  internal           = false
  load_balancer_type = "application"
  security_groups    = [aws_security_group.gitbucket_appsrv_sg.id]
  subnets            = [aws_subnet.gitbucket_publicsubnet_01.id, aws_subnet.gitbucket_publicsubnet_02.id]

  enable_deletion_protection = false

  tags = {
    Name = "${var.app_name}-${terraform.workspace}-load-balancer"
  }
}

resource "aws_security_group" "gitbucket_appsrv_sg" {
  name        = "${var.app_security_group_name}-${terraform.workspace}"
  description = "Security group for GitBucket instances"
  vpc_id      = aws_vpc.gitbucket_vpc.id

  # Ingress rule allowing HTTP access
  ingress {
    from_port   = 80
    to_port     = 80
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }

  # Ingress rule allowing HTTPS access
  ingress {
    from_port   = 443
    to_port     = 443
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }

    # Ingress rule allowing HTTPS access
  ingress {
    from_port   = 0
    to_port     = 22
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }

  # Egress rule allowing all outgoing traffic
  egress {
    from_port   = 0
    to_port     = 0
    protocol    = "-1" # -1 means all protocols
    cidr_blocks = ["0.0.0.0/0"]
  }

  tags = {
    Name = "${var.app_security_group_name}-${terraform.workspace}"
  }
}

resource "aws_security_group" "gitbucket_database_sg" {
  name        = "${var.db_security_group_name}-${terraform.workspace}"
  description = "Security group for MySQL database"
  vpc_id      = aws_vpc.gitbucket_vpc.id

  # Ingress rule allowing MySQL access
  ingress {
    from_port   = 3306
    to_port     = 3306
    protocol    = "tcp"
    security_groups = [aws_security_group.gitbucket_appsrv_sg.id]
  }

  # Egress rule allowing all outgoing traffic
  egress {
    from_port   = 0
    to_port     = 0
    protocol    = "-1" # -1 represents all protocols
    cidr_blocks = ["0.0.0.0/0"]
  }

  tags = {
    Name = "${var.db_security_group_name}-${terraform.workspace}"
  }
}
