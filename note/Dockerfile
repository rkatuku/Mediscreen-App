FROM openjdk:17-jdk-alpine
ARG JAR_FILE=/target/microservice-note-0.0.1-SNAPSHOT.jar 
COPY ${JAR_FILE} microservice-note.jar
ENTRYPOINT ["java", "-jar", "/microservice-note.jar"]