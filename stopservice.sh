#!/bin/bash
service=myApp.service

if (( $(ps -ef | grep -v grep | grep $service | wc -l) > 0 ))
then
/etc/init.d/$service stop
fi
