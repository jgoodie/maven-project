pipeline {
    agent any
    tools{
        maven 'defaultMVN'  
    }
    stages{
        stage('Build'){
            steps {
                sh 'mvn clean package'
            }
            post {
                success {
                    echo 'Now Archiving...'
                    archiveArtifacts artifacts: '**/target/*.war'
                }
            }
        }
	stage('Deploy to Staging'){
		steps{
			build job: 'deploy-maven-to-stage'	
		}
	}
    }
}
