FROM eclipse-temurin:21-jdk-alpine

WORKDIR /app
COPY . /app

RUN ./mvnw clean package

EXPOSE 8080

CMD ["java", "-jar", "target/Eclinic_Backend-0.0.1-SNAPSHOT.jar"]
