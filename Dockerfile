FROM openjdk:latest
COPY ./target/DevOps_SET09623-0.1.0.1-jar-with-dependencies.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "DevOps_SET09623-0.1.0.1-jar-with-dependencies.jar"]