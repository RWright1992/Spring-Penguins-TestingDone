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
			sh 'java -jar target/Spring-Penguins-0.0.1-SNAPSHOT.jar'
			}
                }

	}
}
