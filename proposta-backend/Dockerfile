FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
#ADD ${JAR_FILE} target/proposta-backend-0.0.1-SNAPSHOT.jar
ADD target/proposta-backend-0.0.1-SNAPSHOT.jar proposta-backend-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","-server", "-Xms128m", "-Xmx128m", "-XX:MaxMetaspaceSize=128m", "/proposta-backend-0.0.1-SNAPSHOT.jar"]