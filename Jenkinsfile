pipeline {
    agent any
    stages {
        stage ('Build Backend') {
            steps {
                sh 'mvn clean package -DskipTests=true'
            }
        }
        stage ('Testes Unitarios') {
            steps {
                sh 'mvn test'
            }
        }
    }
}