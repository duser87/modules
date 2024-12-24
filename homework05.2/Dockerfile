FROM openjdk:21
WORKDIR /app
COPY target/homework05.2-1.0-SNAPSHOT.jar app.jar
COPY input.txt /app/input.txt
COPY output.txt /app/output.txt
CMD ["java", "-jar", "app.jar"]