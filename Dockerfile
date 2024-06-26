FROM openjdk:22-jdk-slim
VOLUME /tmp
COPY /target/rpd-0.0.1-SNAPSHOT.jar rpd.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/rpd.jar"]