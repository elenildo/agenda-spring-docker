FROM amazoncorretto:21-alpine-jdk
COPY target/agenda-docker-0.0.1-SNAPSHOT.jar /apps/agenda.jar
CMD ["java", "-jar", "/apps/agenda.jar"]