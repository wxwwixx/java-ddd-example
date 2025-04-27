pipeline {
    agent any
    stages {
        stage('Build with JDK 17') {
            environment {
                JAVA_HOME = tool name: 'JDK17', type: 'JDK'  // JDK 17 for this stage
                PATH = "${JAVA_HOME}/bin:${env.PATH}"
            }
            steps {
                echo "Building with JDK 17"
                bat 'java -version'  // Verify JDK version
                bat './gradlew clean build'  // Use your build command
            }
        }
        stage('Build with JDK 22') {
            environment {
                JAVA_HOME = tool name: 'JDK22', type: 'JDK'  // JDK 22 for this stage
                PATH = "${JAVA_HOME}/bin:${env.PATH}"
            }
            steps {
                echo "Building with JDK 22"
                bat 'java -version'  // Verify JDK version
                bat './gradlew clean build'  // Use your build command
            }
        }
    }
}
