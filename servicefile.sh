#!/bin/bash

echo '
[Unit]
Description=My SpringBoot App

[Service]
SuccessExitStatus=143

User=ubuntu
Group=admin

Type=simple

Environment="JAVA_HOME=/path/to/jvmdir" #FIND THIS YOURSELF
WorkingDirectory=/home/jenkins/${JOB_NAME}/Jars
ExecStart=${JAVA_HOME}/bin/java -jar ${JOB_NAME}_${BUILD_NUMBER}_fatJar.jar
ExecStop=/bin/kill -15 $MAINPID

[Install]
WantedBy=multi-user.target ' > /etc/systemd/system/myApp.service
