FROM maven:3.9.9-eclipse-temurin-21-alpine AS build
COPY . .
RUN mvn clean package -DskipTests

FROM eclipse-temurin:21.0.6_7-jdk-ubi9-minimal
COPY --from=build /target/tester-0.0.1-SNAPSHOT.jar tester.jar
EXPOSE 8080
ENTRYPOINT [ "java", "-jar", "tester.jar" ]