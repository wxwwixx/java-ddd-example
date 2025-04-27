pipeline {
    agent any
    environment {
        JAVA_HOME = tool name: 'JDK17', type: 'JDK'  // Use JDK 17 from the Jenkins global tool configuration
        PATH = "${JAVA_HOME}/bin:${env.PATH}"  // Add JDK to the PATH
    }
    stages {
        stage('Build') {
            steps {
                echo "Building with JDK 17"
                bat './gradlew clean build'  // Your build command
            }
        }
    }
}
