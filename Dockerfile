#FROM openjdk:8-jdk-alpine
#VOLUME /tmp
#COPY target/*.jar /mytestapp.jar
##ADD ./target/*.jar mytestapp.jar
#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/mytestapp.jar"]
#EXPOSE 10087

FROM java:8
FROM openjdk:8-jdk-alpine
ARG JAR_FILE
COPY ${JAR_FILE} demotest1022.jar
ENTRYPOINT ["java","-jar","/demotest1022.jar"]
EXPOSE 10087
