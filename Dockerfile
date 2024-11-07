FROM openjdk:21-jdk

WORKDIR /app

COPY target/EspongeBot-1.0-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
