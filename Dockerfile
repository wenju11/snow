FROM java:8
#author
MAINTAINER yanchen wenjuyanchen@foxmail.com

VOLUME /tmp

ADD consumer/build/libs/Snowweb-1.0-SNAPSHOT.jar /Snow-1.0.jar

# RUN bash -c 'touch /Snow-1.0.jar'

EXPOSE 8080

ENTRYPOINT ["java","-jar","/Snow-1.0.jar"]