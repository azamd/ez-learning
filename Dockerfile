FROM adoptopenjdk/openjdk11:x86_64-ubuntu-jdk-11.0.3_7

RUN mkdir -p /user/share/platform/static/songs

RUN mkdir -p /user/share/platform/bin

ADD /target/platform*SNAPSHOT.jar /user/share/cisapify/bin/platform.jar

WORKDIR /user/share/platform

EXPOSE 8080

ENTRYPOINT ["/opt/java/openjdk/bin/java", "-jar", "bin/platform.jar"]