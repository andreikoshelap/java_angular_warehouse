FROM bellsoft/liberica-openjdk-alpine-musl:21.0.1
COPY /target/client-service.jar /app/app.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
