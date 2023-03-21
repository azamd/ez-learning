FROM adoptopenjdk/openjdk11:alpine

RUN addgroup -S spring && adduser -S spring -G spring

USER spring:spring

VOLUME /tmp

ARG JAR_FILE

ADD ${JAR_FILE} target/platform-0.0.1-SNAPSHOT.jar

EXPOSE 8080

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","target/platform-0.0.1-SNAPSHOT.jar"]
