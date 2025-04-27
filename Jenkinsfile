pipeline {
    agent any
    environment {
        JAVA_HOME = tool name: 'JDK21', type: 'JDK'  // Updated to JDK21
        PATH = "${JAVA_HOME}/bin:${env.PATH}"  // Ensure the JDK is added to the PATH
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
                bat './gradlew clean build'
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
