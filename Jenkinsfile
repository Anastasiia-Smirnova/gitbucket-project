pipeline {
    agent {
      label 'agent1'
    }

    stages {
        stage('Clean workspace') {
            steps {
                echo 'Cleaning workspace...'
                cleanWs()
                checkout scm
                sh """
                  docker rm -f \$(docker ps -aq) || echo "No containers found"
                  docker rmi -f \$(docker images -q)  || echo "No imagess found"
                """
            }
        }
        stage('Build') {
            steps {
                echo 'Building...'
                sh """
                  sbt package
                  sbt executable
                """
            }
        }
        stage('Test') {
            steps {
                echo 'Testing...'
                //sh "sbt test"
            }
        }
        stage('Docker Build MySQL') {
            steps {
                echo 'Building MySQL...'
                sh """
                  cd ./mysql
                  docker build -t mysql:${BUILD_NUMBER} .
                """
            }
        }
        stage('Docker Build GitBucket') {
            steps {
                echo 'Building GitBucket...'
                sh """
                  docker build -t gitbucket:${BUILD_NUMBER} .
                """
            }
        }
        stage('Test Run') {
            steps {
                //echo 'Creating Docker Network...'
                //sh "docker network create test-network"

                echo 'Running MySQL...'
                sh """
                  docker run -itd --name db --network test-network mysql:${BUILD_NUMBER}
                """

                echo 'Running GitBucket...'
                script {
                  def containerId = sh(script: "docker run -itd -v ./gitbucket-data:/gitbucket -v /var/lib/mysql/:/var/lib/mysql/ --name gitbucket -p 8080:8080 --network test-network gitbucket:${BUILD_NUMBER}", returnStdout: true).trim()
                  sh """
                    docker logs ${containerId}
                    sleep 60
                    curl localhost:8080
                  """
                }
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying...'
            }
        }
    }

    post { 
        always {
            echo 'This will always run'
        }
        success {
            echo 'This will run only if the pipeline succeeded'
        }
        failure {
            echo 'This will run only if the pipeline failed'
        }
    }
}
