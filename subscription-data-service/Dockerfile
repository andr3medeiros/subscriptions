FROM openjdk:alpine
ARG version=0.0.1-SNAPSHOT
COPY target/subscription-data-service-${version}.jar /subscription-data-service.jar
ENV JAVA_OPTS ""
ENTRYPOINT java -Djava.security.egd=file:/dev/./urandom $JAVA_OPTS -jar /subscription-data-service.jar
