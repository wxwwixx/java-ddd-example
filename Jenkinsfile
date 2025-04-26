pipeline {
    agent any
    environment {
        JAVA_HOME = tool name: 'JDK22', type: 'JDK'  // Using the JDK name configured in Jenkins
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
                bat './gradlew clean build'  // Gradle build command
            }
        }
        stage('Test') {
            steps {
                echo "Running Gradle tests"
                bat './gradlew test'  // Gradle test command
            }
        }
    }
}
