FROM openjdk:8-jdk-alpine

EXPOSE 8081

ADD target/NetologySpringBoot-0.0.1-SNAPSHOT.jar app1.jar

CMD ["java", "-jar", "app1.jar"]