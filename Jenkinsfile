pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/anmelody/java-ddd-example', branch: 'main'
            }
        }
        stage('Build') {
            steps {
                bat 'build.bat'
            }
        }
        stage('Test') {
            steps {
                sh './gradlew test'
            }
        }
    }
}
