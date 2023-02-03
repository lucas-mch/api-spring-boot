FROM amazoncorretto:11-alpine3.17
COPY target/attornatus-0.0.1-SNAPSHOT.jar attornatus-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/attornatus-0.0.1-SNAPSHOT.jar"]