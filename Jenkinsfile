pipeline {
    agent any
    environment {
        // Set JAVA_HOME to the JDK 22 installation configured in Jenkins
        JAVA_HOME = tool name: 'JDK22', type: 'JDK'
        PATH = "${JAVA_HOME}/bin:${env.PATH}"  // Add JDK to PATH
    }
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
                bat './gradlew clean build'  // Ensure gradlew is executable or use 'gradle' if installed globally
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
