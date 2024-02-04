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
                  sbt build 
                """
            }
        }
        stage('Test') {
            steps {
                echo 'Testing...'
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
