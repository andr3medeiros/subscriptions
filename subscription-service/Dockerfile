FROM openjdk:alpine
ARG version=0.0.1-SNAPSHOT
COPY target/subscription-service-${version}.jar /subscription-service.jar
ENV JAVA_OPTS ""
ENTRYPOINT java -Djava.security.egd=file:/dev/./urandom $JAVA_OPTS -jar /subscription-service.jar
