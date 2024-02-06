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
                  docker run -itd -p 3306:3306 --name db --network test-network mysql:${BUILD_NUMBER}
                """
                sleep 180
                echo 'Running GitBucket...'
                script {
                  def containerId = sh(script: "docker run -itd -v ./gitbucket-data:/gitbucket --name gitbucket -p 8080:8080 --network test-network gitbucket:${BUILD_NUMBER}", returnStdout: true).trim()
                  sh """
                    docker logs ${containerId}
                    sleep 60
                    curl localhost:8080
                  """
                }
                script {
                    withCredentials([string(credentialsId: 'mysql-password', variable: 'MYSQL_ROOT_PASSWORD')]) {
                        // Use the MYSQL_ROOT_PASSWORD environment variable in your command
                        sh """
                        mysql --host=127.0.0.1 -u root -p${MYSQL_ROOT_PASSWORD} -e \"
                        ALTER USER 'testuser'@'%' IDENTIFIED WITH mysql_native_password BY 'testpassword';
                        GRANT ALL PRIVILEGES ON gitbucket.* TO 'testuser'@'%';
                        FLUSH PRIVILEGES;
                        \"
                        """
                    }
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
