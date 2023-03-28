#Stage 1

FROM maven:3.6.3-adoptopenjdk-11 as stage1

ENV MAVEN_OPTS="-XX:+TieredCompilation -XX:TieredStopAtLevel=1"

WORKDIR /ez-learning

COPY . .

RUN mvn dependency:go-offline

RUN mvn clean install -Dmaven.test.skip=true

#Stage 2

FROM adoptopenjdk/openjdk11:jre-11.0.9_11-alpine

WORKDIR /ez-learning

COPY --from=stage1 ez-learning/target/platform-0.0.1-SNAPSHOT.jar /ez-learning