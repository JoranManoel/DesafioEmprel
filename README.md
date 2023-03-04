# DesafioEmprel

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
Este Dockerfile utiliza uma imagem oficial do OpenJDK como imagem base, 
copia o diretório atual para o container, instala o Maven, compila o projeto com o Maven 
e expõe a porta 8080 para o aplicativo Spring Boot. Quando o contêiner é iniciado, 
ele executa o comando java -jar target/my-application.jar para iniciar o aplicativo Spring Boot.
