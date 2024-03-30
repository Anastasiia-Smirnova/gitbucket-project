resource "aws_vpc" "gitbucket_vpc" {
  cidr_block = "10.0.0.0/16" 
  tags = {
    Name = "gitbucket_vpc"
  }
}

resource "aws_internet_gateway" "gitbucket_igw" {
  vpc_id = aws_vpc.gitbucket_vpc.id

  tags = {
    Name = "gitbucket_igw"
  }
}

resource "aws_subnet" "gitbucket-publicsubnet-01" {
  vpc_id     = aws_vpc.gitbucket_vpc.id
  cidr_block = "10.0.1.0/24"
  availability_zone = "eu-central-1a"
  tags = {
    Name = "gitbucket-publicsubnet-01"
  }
}
resource "aws_subnet" "gitbucket-publicsubnet-02" {
  vpc_id     = aws_vpc.gitbucket_vpc.id
  cidr_block = "10.0.2.0/24"
  availability_zone = "eu-central-1b"
  tags = {
    Name = "gitbucket-publicsubnet-02"
  }
}
resource "aws_subnet" "gitbucket-appsubnet-01" {
  vpc_id     = aws_vpc.gitbucket_vpc.id
  cidr_block = "10.0.10.0/24"
  availability_zone = "eu-central-1a"
  tags = {
    Name = "gitbucket-appsubnet-01"
  }
}
resource "aws_subnet" "gitbucket-appsubnet-02" {
  vpc_id     = aws_vpc.gitbucket_vpc.id
  cidr_block = "10.0.11.0/24"
  availability_zone = "eu-central-1b"
  tags = {
    Name = "gitbucket-appsubnet-02"
  }
}
resource "aws_subnet" "gitbucket-datasubnet-01" {
  vpc_id     = aws_vpc.gitbucket_vpc.id
  cidr_block = "10.0.20.0/24"
  availability_zone = "eu-central-1a"
  tags = {
    Name = "gitbucket-datasubnet-01"
  }
}
resource "aws_subnet" "gitbucket-datasubnet-02" {
  vpc_id     = aws_vpc.gitbucket_vpc.id
  cidr_block = "10.0.21.0/24"
  availability_zone = "eu-central-1b"
  tags = {
    Name = "gitbucket-datasubnet-02"
  }
}

resource "aws_route_table" "gitbucket-publicRT" {
  vpc_id = aws_vpc.gitbucket_vpc.id

  route {
    cidr_block = "0.0.0.0/0"
    gateway_id = aws_internet_gateway.gitbucket_igw.id
  }

  tags = {
    Name = "gitbucket-publicRT"
  }
}

resource "aws_route_table_association" "gitbucket-publicRT-association1" {
  subnet_id      = aws_subnet.gitbucket-publicsubnet-01.id
  route_table_id = aws_route_table.gitbucket-publicRT.id
}
resource "aws_route_table_association" "gitbucket-publicRT-association2" {
  subnet_id      = aws_subnet.gitbucket-publicsubnet-02.id
  route_table_id = aws_route_table.gitbucket-publicRT.id
}

resource "aws_default_route_table" "default" {
  default_route_table_id = aws_vpc.gitbucket_vpc.default_route_table_id

  route {
    cidr_block = "0.0.0.0/0"
    nat_gateway_id = aws_nat_gateway.gitbucket-natgw.id
  }

  tags = {
    Name = "gitbucket-mainRT"
  }
}

resource "aws_eip" "gitbucket_nat_eip" {
  domain = "vpc"

  tags = {
    Name = "gitbucket_nat_eip"
  }
}

resource "aws_nat_gateway" "gitbucket-natgw" {
  allocation_id = aws_eip.gitbucket_nat_eip.id
  subnet_id     = aws_subnet.gitbucket-publicsubnet-01.id

  tags = {
    Name = "gitbucket-natgw"
  }

  depends_on = [aws_internet_gateway.gitbucket_igw]
}

resource "aws_security_group" "gitbucket-appsrv-sg" {
  name        = "gitbucket-appsrv-sg"
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

  # Egress rule allowing all outgoing traffic
  egress {
    from_port   = 0
    to_port     = 0
    protocol    = "-1" # -1 means all protocols
    cidr_blocks = ["0.0.0.0/0"]
  }

  tags = {
    Name = "gitbucket-appsrv-sg"
  }
}

resource "aws_security_group" "gitbucket-database-sg" {
  name        = "gitbucket-database-sg"
  description = "Security group for MySQL database"
  vpc_id      = aws_vpc.gitbucket_vpc.id

  # Ingress rule allowing MySQL access
  ingress {
    from_port   = 3306
    to_port     = 3306
    protocol    = "tcp"
    security_groups = [aws_security_group.gitbucket-appsrv-sg.id]
  }

  # Egress rule allowing all outgoing traffic
  egress {
    from_port   = 0
    to_port     = 0
    protocol    = "-1" # -1 represents all protocols
    cidr_blocks = ["0.0.0.0/0"]
  }

  tags = {
    Name = "gitbucket-database-sg"
  }
}
