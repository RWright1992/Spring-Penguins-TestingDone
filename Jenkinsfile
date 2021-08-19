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
			sh 'mv ./target/*.jar /home/jenkins/Jars/project_fatJar.jar'
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
ExecStart="${JAVA_HOME}/bin/java -jar project_fatJar.jar"


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
