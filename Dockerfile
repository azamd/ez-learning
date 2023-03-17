FROM openjdk:8-jdk-alpine

COPY target/ez-learning.jar ez-learning.jar
ENTRYPOINT ["java","-jar","/ez-learning.jar"]
