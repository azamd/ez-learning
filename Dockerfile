#Stage 1

FROM maven:3.6.3-adoptopenjdk-11 as stage1

WORKDIR /ez-learning

COPY . .

RUN mvn dependency:go-offline

RUN --mount=type=cache,target=/root/.m2 mvn -f /app/pom.xml clean package -DskipTests

#Stage 2

FROM adoptopenjdk/openjdk11:jre-11.0.9_11-alpine

WORKDIR /ez-learning

EXPOSE 8083

COPY --from=stage1 ez-learning/target/platform-0.0.1-SNAPSHOT.jar /ez-learning