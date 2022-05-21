#FROM openjdk:11-jdk
#RUN echo "test..."
#COPY target/*SNAPSHOT.jar app.jar
#RUN true
#ENTRYPOINT ["java","-Xmx400M","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar","--spring.profiles.active=docker"]

FROM openjdk:11-jdk
COPY target/*SNAPSHOT.jar app.jar
ENV JAVA_OPTS=""
ENTRYPOINT exec java -jar -Dspring.profiles.active=docker /app.jar
