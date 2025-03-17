        FROM eclipse-temurin:21-jdk-ubi9-minimal
        COPY target/agenda-docker-0.0.1-SNAPSHOT.jar /apps/agenda.jar
        CMD ["java", "-jar", "/apps/agenda.jar"]