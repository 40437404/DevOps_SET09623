FROM openjdk:latest
COPY ./target/DevOps_SET09623.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "DevOps_SET09623.jar", "db:3306"]