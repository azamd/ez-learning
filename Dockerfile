#Stage 1

FROM maven:3.8-openjdk-8 as stage1

WORKDIR /ez-learning

COPY . .

RUN mvn -Dmaven.test.skip=true clean package

USER  aziz

#Stage 2

FROM openjdk:8-jdk-alpine

WORKDIR /ez-learning

EXPOSE 8080

HEALTHCHECK CMD curl --fail http://localhost:3000 || exit 1

COPY --from=stage1 /ez-learning/target/*.jar ez-learning.jar

ENTRYPOINT ["java","-jar","ez-learning.jar"]