FROM eclipse-temurin:21-jdk-alpine

WORKDIR /app

ARG JAR_FILE=target/api-0.0.1.jar
COPY ${JAR_FILE} supermarket-api.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","supermarket-api.jar"]