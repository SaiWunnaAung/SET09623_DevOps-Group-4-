FROM openjdk:latest
COPY ./target/group4.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "group4.jar", "db:3306", "30000"]