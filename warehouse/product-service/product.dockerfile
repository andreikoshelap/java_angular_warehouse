FROM bellsoft/liberica-openjdk-alpine-musl:21.0.1
COPY /target/product-service.jar /app/app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
