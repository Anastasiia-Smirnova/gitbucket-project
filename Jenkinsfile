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
                echo 'Running MySQL...'
                sh """
                  docker run -itd mysql:${BUILD_NUMBER}
                """

                echo 'Running GitBucket...'
                sh """
                  docker run -itd gitbucket:${BUILD_NUMBER}
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
