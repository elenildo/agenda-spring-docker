FROM maven:3.9.9-amazoncorretto-21-alpine AS build
COPY . /app
WORKDIR /app
RUN mvn clean install -DskipTests
FROM amazoncorretto:21-alpine-jdk
COPY --from=build /app/target/agenda-docker-0.0.1-SNAPSHOT.jar /app/agenda.jar
WORKDIR /app
EXPOSE 8080
CMD ["java", "-jar", "agenda.jar"]