#Stage 1

FROM maven:3.6.3-adoptopenjdk-11 as stage1

ENV MAVEN_OPTS="-XX:+TieredCompilation -XX:TieredStopAtLevel=1"

WORKDIR /Ez-learning/ez-learning

COPY pom.xml .

RUN mvn dependency:go-offline

COPY ./src ./src

RUN mvn clean install -Dmaven.test.skip=true

#Stage 2

FROM adoptopenjdk/openjdk11:jre-11.0.9_11-alpine

WORKDIR /Ez-learning/ez-learning

COPY --from=stage1 /Ez-learning/ez-learning/target/platform-0.0.1-SNAPSHOT.jar /Ez-learning/ez-learning