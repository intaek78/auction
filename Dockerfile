FROM openjdk:11-jdk
RUN true
COPY target/*SNAPSHOT.jar app.jar
RUN true
ENTRYPOINT ["java","-Xmx400M","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar","--spring.profiles.active=docker"]
