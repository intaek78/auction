FROM openjdk:11-jdk
COPY target/*SNAPSHOT.jar app.jar
ENV JAVA_HOME /usr/lib/jvm/java-11-openjdk-amd64
ENTRYPOINT ["java","-Xmx400M","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar","--spring.profiles.active=docker"]
