#FROM maven:3.8.5-openjdk-17 AS build
#COPY . .
#RUN mvn clean package -Pprod  -DskipTests
#RUN wget -O /path/to/jar/postgresql.jar https://jdbc.postgresql.org/download/postgresql-42.2.24.jar
#ENV CLASSPATH=/path/to/jar/postgresql.jar:$CLASSPATH
#COPY your-app.jar /path/to/app/your-app.jar
#CMD java -cp $CLASSPATH:/path/to/app/your-app.jar YourMainClass
#
#
#FROM openjdk:17.0.1-jdk-slim
#
#COPY --from=build /target/BlogApplication-0.0.1-SNAPSHOT.jar BlogApplication.jar
#EXPOSE 8080
#ENTRYPOINT ["java","-jar","BlogApplication.jar"]



# Build stage
FROM maven:3.8.5-openjdk-17 AS build

# Copy project files
COPY . .

# Build the project and skip tests
RUN mvn clean package -Pprod -DskipTests
# FROM a base image with a compatible package manager
FROM ubuntu:20.04




# Download PostgreSQL JDBC driver
#RUN wget -O /postgresql.jar https://jdbc.postgresql.org/download/postgresql-42.2.24.jar



# Runtime stage
FROM openjdk:17.0.1-jdk-slim

RUN apt-get update && apt-get install -y wget && rm -rf /var/lib/apt/lists/*


# Copy the built JAR file from the build stage
COPY --from=build /target/BlogApplication-0.0.1-SNAPSHOT.jar /app/BlogApplication.jar
#COPY --from=build /target/BlogApplication-0.0.1-SNAPSHOT.jar BlogApplication.jar


RUN wget -O /app/postgresql.jar https://jdbc.postgresql.org/download/postgresql-42.2.24.jar


# Copy PostgreSQL JDBC driver from the build stage
#COPY --from=build /postgresql.jar /app/postgresql.jar

# Expose port 8080
EXPOSE 8080

# Run the application
#ENTRYPOINT ["java","-jar","BlogApplication.jar"]
ENTRYPOINT ["java", "-jar", "/app/postgresql.jar:/app/BlogApplication.jar"]
