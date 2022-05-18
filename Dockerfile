FROM amd64/openjdk:11
COPY target/*SNAPSHOT.jar app.jar
ENV JAVA_OPTS=""
ENV JAVA_HOME /usr/lib/jvm/java-11-openjdk-amd64
ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar
