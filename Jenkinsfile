pipeline {
	agent any
	stages{
		stage('Build Jar'){
			steps{
			sh 'mvn clean package'
			}
		}
		stage('Run Jar'){
			steps{
			bash ./deploy.sh
			}
                }

	}
}
