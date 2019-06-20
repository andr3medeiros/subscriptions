FROM openjdk:alpine
ARG version=0.0.1-SNAPSHOT
COPY target/subscription-api-${version}.jar /subscription-api.jar
ENV JAVA_OPTS ""
ENTRYPOINT java -Djava.security.egd=file:/dev/./urandom $JAVA_OPTS -jar /subscription-api.jar
