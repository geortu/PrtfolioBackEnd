FROM openjdk:8-jdk-alpine
MAINTAINER emaaristimuno
COPY target/portfolioweb-0.0.1-SNAPSHOT.jar portfolioweb-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/portfolioweb-0.0.1-SNAPSHOT.jar"]