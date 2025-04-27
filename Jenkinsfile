pipeline {
    agent any

    environment {
        JAVA_HOME = tool name: 'JDK21', type: 'jdk'    // 'jdk' must be lowercase
        PATH = "${JAVA_HOME}/bin:${env.PATH}"
    }

    stages {
        stage('Checkout') {
            steps {
                echo "Checking out the code..."
                checkout scm
            }
        }

        stage('Start Services') {
            steps {
                echo "Starting MySQL and Elasticsearch containers..."
                bat 'docker run -d --rm --name mysql-container -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=ddd_example -p 3306:3306 mysql:8'
                bat 'docker run -d --rm --name elasticsearch-container -e "discovery.type=single-node" -p 9200:9200 elasticsearch:7.17.0'
            }
        }

        stage('Build') {
            steps {
                echo "Running Gradle build..."
                bat './gradlew clean build'
            }
        }

        stage('Test') {
            steps {
                echo "Running Gradle tests..."
                bat './gradlew test'
            }
        }
    }

    post {
        always {
            echo "Stopping containers..."
            bat 'docker stop mysql-container || echo "MySQL container not running"'
            bat 'docker stop elasticsearch-container || echo "Elasticsearch container not running"'
        }
    }
}
