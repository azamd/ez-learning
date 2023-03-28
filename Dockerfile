#Stage 1

FROM maven:3.6.3-adoptopenjdk-11 as stage1

ENV MAVEN_OPTS="-XX:+TieredCompilation -XX:TieredStopAtLevel=1"

ENV DB_HOST=mydb \
     DB_USERNAME=user1 \
     DB_PASSWORD=pass1

WORKDIR /ez-learning

COPY . .

RUN mvn dependency:go-offline

RUN mvn -Dmaven.test.skip=true clean package

#Stage 2

FROM adoptopenjdk/openjdk11:jre-11.0.9_11-alpine

WORKDIR /ez-learning

EXPOSE 8080

COPY --from=stage1 ez-learning/target/platform-0.0.1-SNAPSHOT.jar /ez-learning