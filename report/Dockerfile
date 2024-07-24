FROM openjdk:17-jdk-alpine
ARG JAR_FILE=/target/microservice-report-0.0.1-SNAPSHOT.jar 
COPY ${JAR_FILE} microservice-report-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/microservice-report-0.0.1-SNAPSHOT.jar"]