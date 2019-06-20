FROM openjdk:alpine
ARG version=0.0.1-SNAPSHOT
COPY target/email-service-${version}.jar /email-service.jar
ENV JAVA_OPTS ""
ENTRYPOINT java -Djava.security.egd=file:/dev/./urandom $JAVA_OPTS -jar /email-service.jar
