FROM openjdk:17
VOLUME /tmp
COPY target/employee-service-0.0.1-SNAPSHOT.jar employee-service.jar
ENTRYPOINT ["java", "-jar", "employee-service.jar"]
