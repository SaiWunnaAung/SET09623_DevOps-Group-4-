FROM openjdk:latest
COPY ./target/group4-1.0-jar-with-dependencies.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "group4-1.0-jar-with-dependencies.jar"]