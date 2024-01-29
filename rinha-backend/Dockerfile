FROM openjdk:17-jdk-slim

COPY target/rinha_backend-0.0.1-SNAPSHOT.jar /rinha.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/rinha.jar"]