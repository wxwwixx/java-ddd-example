pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                echo "Checking out the code"
                checkout scm
            }
        }
        stage('Build') {
            steps {
                echo "Running Gradle build"
                bat './gradlew clean build'  // Use Gradle wrapper or installed Gradle
            }
        }
        stage('Test') {
            steps {
                echo "Running Gradle tests"
                bat './gradlew test'
            }
        }
    }
}
