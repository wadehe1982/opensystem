FROM dev.aliyun.com/tomcat:latest
MAINTAINER Wade He <ir_01@163.com>
RUN apt-get update && apt-get install -y nginx
COPY ../target/opensys.war ${CATALINA_HOME}/webapps/ROOT.war 
EXPOSE 10001
