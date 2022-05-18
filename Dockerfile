FROM openjdk:11-jdk
COPY target/*SNAPSHOT.jar app.jar
ENV JAVA_OPTS=""
ENTRYPOINT exec java -jar -Dspring.profiles.active=prod /app.jar 
