FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/remitero-0.0.1.jar
COPY ${JAR_FILE} app_remitero.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app_remitero.jar"]