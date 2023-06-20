FROM amazoncorretto:11-alpine3.17
COPY target/api-lucas-0.0.1-SNAPSHOT.jar api-lucas-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/api-lucas-0.0.1-SNAPSHOT.jar"]