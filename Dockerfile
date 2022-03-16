FROM openjdk:8-jdk-alpine as build
VOLUME /tmp
ARG API_NAME="api-clientes-canonico"
RUN mkdir /usr/local/api
WORKDIR /usr/local/api

RUN mkdir ./logs
RUN touch ./logs/${API_NAME}.logs
RUN chmod -R 777 .

# Run vulnerability scan on build image
FROM build AS vulnscan
COPY --from=aquasec/trivy:latest /usr/local/bin/trivy /usr/local/bin/trivy
RUN trivy rootfs --no-progress /

COPY ./src/main/resources/*.properties.prod ./${API_NAME}.properties
COPY ./target/*.war ./${API_NAME}.war
ENV CATALINA.BASE=./
ENV DB_CONFIGMAP=@(DESCRIPTION_LIST=(FAILOVER=on)(DESCRIPTION=(CONNECT_TIMEOUT=10)(TRANSPORT_CONNECT_TIMEOUT=3000)(RETRY_COUNT=3)(ADDRESS_LIST=(ADDRESS=(PROTOCOL=TCP)(HOST=rac20-scan.activeit.cl)(PORT=1521)))(CONNECT_DATA=(SERVICE_NAME=SIEBELTEST18))))
ENV DB_USERNAME=canonico
ENV DB_PASSWORD=canonico

EXPOSE 8080
ENTRYPOINT ["java","-jar","api-clientes-canonico.war","--spring.config.location", "file:api-clientes-canonico.properties"]
