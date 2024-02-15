#!/bin/bash
java -Dlogback.configurationFile=/gitbucket/logback-settings.xml -jar /opt/gitbucket.war &
ln -s /opt/gitbucket/log/gitbucket.log /gitbucket/gitbucket.log
sleep 100000000000000000
