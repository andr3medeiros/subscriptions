FROM openjdk:alpine
ARG version=0.0.1-SNAPSHOT
COPY target/public-service-${version}.jar /public-service.jar
ENV JAVA_OPTS ""
ENTRYPOINT java -Djava.security.egd=file:/dev/./urandom $JAVA_OPTS -jar /public-service.jar
