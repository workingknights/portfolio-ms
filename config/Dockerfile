FROM java:8-jre
MAINTAINER Anthony Knights <anthony.knights@gmail.com>

ADD ./target/config.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/config.jar"]

EXPOSE 8888