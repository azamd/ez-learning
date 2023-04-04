#Stage 1

FROM maven:3.8-openjdk-8 as stage1

WORKDIR /ez-learning

COPY . .

RUN mvn -Dmaven.test.skip=true clean package

#Stage 2

FROM openjdk:8-jdk-alpine

WORKDIR /ez-learning

EXPOSE 8080

COPY --from=stage1 ez-learning/target/platform-0.0.1-SNAPSHOT.jar /ez-learning