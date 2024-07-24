FROM openjdk:17-jdk-alpine
ARG JAR_FILE=/target/patient-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} patient-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/patient-0.0.1-SNAPSHOT.jar"]