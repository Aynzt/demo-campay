FROM gradle:8-jdk17-alpine AS build

RUN mkdir /app

COPY . /app

WORKDIR /app

RUN gradle clean build

FROM amazoncorretto:17

ARG JAR_FILE=/app/build/libs/*-SNAPSHOT.jar

COPY --from=build ${JAR_FILE} demo-campay.jar

ENTRYPOINT ["java", "-jar", "/demo-campay.jar", "--spring.profiles.active=cloud"]

