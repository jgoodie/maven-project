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
			echo 'Deploying to stage.....'
		}
	}
        stage ('deploy-to-prod'){
            steps{
                timeout(time:5, unit:'DAYS'){
                    input message:'Approve PRODUCTION Deployment?'
                }

                build job: 'deploy-to-prod'
		echo 'Deploying to prod..... '
            }
            post {
                success {
                    echo 'Code deployed to Production.'
                }

                failure {
                    echo ' Deployment failed.'
                }
            }
        }
    }
}
