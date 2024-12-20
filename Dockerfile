# Stage 1: Build the application
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app

# Copy pom.xml and download dependencies
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy the source code
COPY src ./src

# Package the application
RUN mvn clean package -DskipTests

# Stage 2: Run the application
FROM openjdk:17.0.1-jdk-slim
WORKDIR /app

# Copy the built JAR using wildcard
COPY --from=build /app/target/*.jar demo.jar

# Expose the application port
EXPOSE 8080

# Set the entry point to run the JAR
ENTRYPOINT ["java", "-jar", "demo.jar"]
