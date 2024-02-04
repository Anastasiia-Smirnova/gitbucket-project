pipeline {
    agent {
      label 'agent1'
    }

    stages {
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
                sh "sbt test"
            }
        }
        stage('Docker Build') {
            steps {
                echo 'Building with Docker...'
                sh """
                  cd /root/gitbucket-project
                  docker build .
                """
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
