def submitStatusCheck(String checkName, String state) {
  withCredentials([string(credentialsId: 'git-token', variable: 'GIT_TOKEN')]) {
    def commitSHA = env.GIT_COMMIT
    sh """
      curl -L \
      -X POST \
      -H \"Accept: application/vnd.github+json\" \
      -H \"Authorization: Bearer ${GIT_TOKEN}\" \
      -H \"X-GitHub-Api-Version: 2022-11-28\" \
      https://api.github.com/repos/Anastasiia-Smirnova/gitbucket-project/statuses/${commitSHA} \
      -d \'{"state":"${state}","target_url":"${BUILD_URL}/build/status","description":"${checkName} stage succeeded!","context":"${checkName}"}\'
    """
  }
}

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
                  docker rmi -f \$(docker images -q) || echo "No images found"
                """
            }
        }
        stage('Build') {
            steps {
              script {
                try {
                  echo 'Building...'
                  sh """
                    sbt package
                    sbt executable
                  """
                  submitStatusCheck('stage/build', 'success')
                } catch (e) {
                  submitStatusCheck('stage/build', 'failure')
                  throw e
                }
              }
            }
        }
        stage('Test') {
            steps {
              script {
                try {
                  echo 'Testing...'
                  //sh "sbt test"
                  submitStatusCheck('stage/test', 'success')
                } catch (e) {
                  submitStatusCheck('stage/test', 'failure')
                  throw e
                }
              }     
            }
        }
        stage('Docker Build MySQL') {
            steps {
                script {
                    // Fetch secrets directly from Vault within the stage
                    withCredentials([vaultString(credentialsId: 'vault-root-password', variable: 'MYSQL_ROOT_PASSWORD'), vaultString(credentialsId: 'vault-database', variable: 'MYSQL_DATABASE'), vaultString(credentialsId: 'vault-user', variable: 'MYSQL_USER'), vaultString(credentialsId: 'vault-password', variable: 'MYSQL_PASSWORD')]) {
                        // Use the secrets fetched from Vault
                        echo 'Building MySQL...'
                        sh """
                          cd ./mysql
                          docker build -t mysql:${BUILD_NUMBER} . \\
                          --build-arg MYSQL_ROOT_PASSWORD='${MYSQL_ROOT_PASSWORD}' \\
                          --build-arg MYSQL_DATABASE='${MYSQL_DATABASE}' \\
                          --build-arg MYSQL_USER='${MYSQL_USER}' \\
                          --build-arg MYSQL_PASSWORD='${MYSQL_PASSWORD}'
                        """
                    }
                }
            }
        }
        stage('Docker Build GitBucket') {
            steps {
              script {
                echo 'Building GitBucket...'
                git '…'
                def newApp = docker.build "smirnovaanastasiia/gitbucket:${BUILD_NUMBER}"
                newApp.push()
              }
            }
        }
        stage('Test Run') {
            steps {
              script {
                try {
                  echo 'Creating Docker Network...'
                  sh "docker network create test-network || echo 'Docker Network already exists'"

                  echo 'Running MySQL...'
                  sh """
                    docker run -itd -p 3306:3306 --name db --network test-network mysql:${BUILD_NUMBER}
                  """
                  sleep 59
                  echo 'Running GitBucket...'
                  withCredentials([vaultString(credentialsId: 'vault-root-password', variable: 'MYSQL_ROOT_PASSWORD'), vaultString(credentialsId: 'vault-new-password', variable: 'MYSQL_NEW_PASSWORD'), vaultString(credentialsId: 'vault-user', variable: 'MYSQL_USER')]) {
                    sh """
                      mysql --host=127.0.0.1 -u root -p${MYSQL_ROOT_PASSWORD} -e \"
                      ALTER USER '${MYSQL_USER}'@'%' IDENTIFIED WITH mysql_native_password BY '${MYSQL_NEW_PASSWORD}';
                      GRANT ALL PRIVILEGES ON gitbucket.* TO '${MYSQL_USER}'@'%';
                      FLUSH PRIVILEGES;
                      \"
                    """
                  }
                  def containerId = sh(script: "docker run -itd -v ./gitbucket-data:/gitbucket --name gitbucket -p 8080:8080 --network test-network smirnovaanastasiia/gitbucket:${BUILD_NUMBER}", returnStdout: true).trim()
                  sh """
                    docker logs ${containerId}
                    sleep 10
                    curl -f localhost:8080
                  """
                  submitStatusCheck('stage/test-run', 'success')
                } catch (e) {
                  submitStatusCheck('stage/test', 'failure')
                  throw e
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

//pr
