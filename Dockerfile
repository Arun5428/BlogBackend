FROM maven:3.8.5-jdk-17 AS build
COPY . .
RUN mvn clean package -Pprod  -DskipTests

FROM openjdk:17.0.1-jdk-slim

COPY --from=build /target/BlogApplication-0.0.1-SNAPSHOT.jar BlogApplication.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","BlogApplication.jar"]