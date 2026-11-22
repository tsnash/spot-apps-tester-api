FROM maven:3.9.12-eclipse-temurin-25 AS build
WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline -B

COPY src ./src
RUN mvn package -DskipTests -B

FROM eclipse-temurin:25-jre-ubi10-minimal
WORKDIR /app

COPY --from=build --chown=1001:0 /app/target/tester-0.0.1-SNAPSHOT.jar tester.jar

ENV JAVA_TOOL_OPTIONS="-XX:MaxRAMPercentage=55.0 -XX:MaxMetaspaceSize=128m -Xss256k -XX:+UseSerialGC"

# Run as non-root UID 1001 without requiring /etc/passwd or shadow-utils.
# Note: Since UID 1001 is unregistered, user.home resolves to '/' and /app is read-only.
# Any runtime file writes (e.g., temp files, uploads) must target /tmp (or a writable volume).
USER 1001
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "tester.jar"]
