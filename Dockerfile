FROM openjdk:8-jdk-alpine

COPY target/platform-0.0.1-SNAPSHOT.jar platform-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/platform-0.0.1-SNAPSHOT.jar"]
