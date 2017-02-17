FROM java:8-jre
MAINTAINER Anthony Knights <anthony.knights@gmail.com>

ADD ./target/ticker-service.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/ticker-service.jar"]

EXPOSE 6000