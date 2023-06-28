FROM amazoncorretto:11-alpine3.17
COPY target/api-lucas-0.0.2-SNAPSHOT.jar api-lucas-0.0.2-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-Dspring.profiles.active=test","-jar","/api-lucas-0.0.2-SNAPSHOT.jar"]