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
			sh 'mv ./target/*.jar /home/jenkins/${JOB_NAME}/Jars/${JOB_NAME}_${BUILD_NUMBER}_fatJar.jar'
			}
                }
		stage('Stopping Service'){
			steps{
			sh 'bash stopservice.sh'
			}
		}
		stage('Create new service file'){
			steps{
			sh 'echo '''
[Unit]
Description=My SpringBoot App

[Service]
SuccessExitStatus=143

User=ubuntu
Group=admin

Type=simple

Environment="JAVA_HOME=/usr/bin/java"
Environment="JOB_NAME=${env.JOB_NAME}"
Environment="BUILD_NAME=${env.BUILD_NAME}"
WorkingDirectory=/home/jenkins/${JOB_NAME}/Jars
ExecStart="${JAVA_HOME}/bin/java -jar ${JOB_NAME}_${BUILD_NUMBER}_fatJar.jar"
ExecStop=/bin/kill -15 $MAINPID

[Install]
WantedBy=multi-user.target ''' > /etc/systemd/system/myApp.service'
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
