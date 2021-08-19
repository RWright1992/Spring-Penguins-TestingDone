pipeline {
	agent any
	stages{
		stage('Build Jar'){
			steps{
			sh 'mvn clean package'
			}
		}
		stage('Moving Jar'){
			steps{
			sh 'mkdir -p /home/jenkins/Jars'
			sh 'mkdir -p /home/jenkins/appservice'
			sh 'mv ./target/*.jar /home/jenkins/Jars/project_fatJar.jar'
			sh ''' echo '#!/bin/bash
sudo java -jar /home/jenkins/Jars/project_fatJar.jar' > /home/jenkins/appservice/start.sh'''
			}
                }
		stage('Stopping Service'){
			steps{
			sh 'bash stopservice.sh'
			}
		}
		stage('Create new service file'){
			steps{
			sh '''echo '[Unit]
Description=My SpringBoot App

[Service]

User=ubuntu

Type=simple

Environment="JAVA_HOME=/usr/bin/java"
WorkingDirectory=/home/jenkins/Jars
ExecStart=/home/jenkins/appservice/start.sh


[Install]
WantedBy=multi-user.target' > /home/jenkins/myApp.service '''
			sh' sudo mv /home/jenkins/myApp.service /etc/systemd/system/myApp.service'
			}
		}
		stage('Reload and start service'){
			steps{
			sh 'sudo systemctl daemon-reload'
			sh 'sudo systemctl start myApp.service'
			}
		}

	}
}
