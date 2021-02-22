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
        stage ('Analise do Sonar') {
            enviroment {
                scannerHome = tool 'SONAR_SCANNER'
            }
            steps {
                withSonarQubeEnv('SONAR_LOCAL'){
                    sh "${scannerHome}/bin/sonar-scanner -e -Dsonar.projectKey=deploy-backend -Dsonar.host.url=http://sonar:9000 -Dsonar.login=24f72abe6dfc8a769c27249bf33b9e157778558d -Dsonar.java.binaries=target"
                }
            }
        }
    }
}