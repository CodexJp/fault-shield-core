FROM maven:3.8.3-openjdk-17-slim AS build
COPY . /app
WORKDIR /app
RUN mvn clean install

FROM openjdk:17.0.1-jdk-slim-buster
COPY --from=build /app/target/fault-shield-core.jar /fault-shield-core.jar
ENTRYPOINT ["java", "-jar","/fault-shield-core.jar"]
EXPOSE 8080