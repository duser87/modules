FROM openjdk:21
WORKDIR /app
COPY target/homework05-1.0-SNAPSHOT.jar app.jar
COPY test.txt /app/test.txt
CMD ["java", "-jar", "app.jar"]