#FROM openjdk:8-jdk-alpine
#COPY target/portfolioweb-0.0.1-SNAPSHOT.jar portfolioweb-0.0.1-SNAPSHOT.jar
#ENTRYPOINT ["java","-jar","/portfolioweb-0.0.1-SNAPSHOT.jar"]
FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} portfolioweb-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/portfolioweb-0.0.1-SNAPSHOT.jar"]