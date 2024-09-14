FROM amazoncorretto:17

ARG JAR_FILE=build/libs/*-SNAPSHOT.jar

COPY ${JAR_FILE} demo-campay.jar

ENTRYPOINT ["java", "-jar", "/demo-campay.jar"]

