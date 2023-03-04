# Use an official OpenJDK runtime as a parent image
FROM openjdk:8-jdk-alpine

# Set the working directory to /app
WORKDIR /app

# Copy the current directory contents into the container at /app
COPY . /app

# Install maven
RUN apk add --no-cache maven

# Build the application with maven
RUN mvn clean package

# Expose port 8080 for the Spring Boot application
EXPOSE 8080

# Define the command to run the application when the container starts
CMD ["java", "-jar", "target/my-application.jar"]
