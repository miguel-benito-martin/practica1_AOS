ARG BUILD_IMAGE=maven:3.6.0-jdk-8
ARG RUNTIME_IMAGE=ubuntu:18.04

#Dependencias de Maven
FROM ${BUILD_IMAGE} as dependencies
COPY pom.xml ./
RUN mvn dependency:go-offline

#Compilar con Maven
FROM dependencies as build
COPY src ./src
RUN mvn clean package -Pjar

#OpenJDK
FROM ${RUNTIME_IMAGE}
RUN apt-get update && \
    apt-get install -y openjdk-8-jdk && \
    apt-get install -y ant && \
    apt-get clean;
RUN apt-get update && \
    apt-get install ca-certificates-java && \
    apt-get clean && \
    update-ca-certificates -f;
ENV JAVA_HOME /usr/lib/jvm/java-8-openjdk-amd64/
RUN export JAVA_HOME
#Copiar el artefacto a nueva carpeta
COPY  target/*.jar /home/app.jar
#Mongo
RUN apt-get install -y mongodb
RUN cd / && mkdir data && cd /data && mkdir db
#Supervisor
RUN apt-get install -y supervisor
COPY supervisord.conf /etc/supervisord.conf
EXPOSE 8080
CMD ["/usr/bin/supervisord", "-c", "/etc/supervisord.conf"]
