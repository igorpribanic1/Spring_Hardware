FROM eclipse-temurin:21-jdk
LABEL authors="Igor Pribanic"
COPY target/Hardware-0.0.1-SNAPSHOT.jar hardware.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "/hardware.jar"]