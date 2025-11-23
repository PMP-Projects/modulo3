FROM amazoncorretto:21-alpine3.18 AS build

WORKDIR /app

COPY . .

RUN apk add --no-cache bash

RUN ./mvnw --no-transfer-progress clean package -DskipTests

FROM amazoncorretto:21-alpine3.18

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

ENTRYPOINT ["java", "-jar", "/app/app.jar"]
