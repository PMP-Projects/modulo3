FROM amazoncorretto:21-alpine3.15

WORKDIR /app

ARG JAR_FILE=target/*.jar

COPY target/*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
