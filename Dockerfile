FROM adoptopenjdk:11-jre-hotspot

LABEL "com.datadoghq.ad.logs"='[{"type":"file", "source": "gitbucket", "service": "gitbucket", "path": "/opt/gitbucket/log/gitbucket.log"}]'

COPY ./target/executable/gitbucket.war /opt/gitbucket.war

RUN ln -s /gitbucket /root/.gitbucket

VOLUME /gitbucket

COPY ./gitbucket-data/k8s-database.conf /gitbucket/database.conf

COPY ./gitbucket-data/logback-settings.xml /gitbucket/logback-settings.xml

ENV GITBUCKET_HOME=/gitbucket

# Port for web page and Port for SSH access to git repository (Optional)
EXPOSE 8080 29418

CMD ["sh", "-c", "java -Dlogback.configurationFile=/gitbucket/logback-settings.xml -jar /opt/gitbucket.war"]