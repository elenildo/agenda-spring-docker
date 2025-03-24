FROM amazoncorretto:21-alpine-jdk
COPY ./target/agenda-docker-0.0.1-SNAPSHOT.jar /app/agenda.jar
EXPOSE 8080
CMD ["java", "-jar", "/app/agenda.jar"]