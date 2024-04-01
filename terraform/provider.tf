provider "aws" {
  region = "eu-central-1"
}

terraform {
  backend "s3" {
    bucket = "elasticbeanstalk-eu-central-1-538547716265"
    key    = "terraform/terraform.tfstate"
    region = "eu-central-1"
  }
}
