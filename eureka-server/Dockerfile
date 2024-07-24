FROM openjdk:17-jdk-alpine
ARG JAR_FILE=/target/microservice-discovery-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} microservice-discovery-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/microservice-discovery-0.0.1-SNAPSHOT.jar"]