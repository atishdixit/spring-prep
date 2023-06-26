FROM openjdk:17
ADD target/spring-prep-0.0.1-SNAPSHOT.jar spring-prep.jar
EXPOSE 8083
ENTRYPOINT ["java", "-jar", "spring-prep.jar"]
