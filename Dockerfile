FROM adoptopenjdk/openjdk11:alpine-slim as build
WORKDIR /workspace/app

#COPY mvnw .
#COPY .mvn .mvn
COPY pom.xml .
COPY src src

#RUN ./mvnw install -DskipTests
#RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)

# Run vulnerability scan on build image
FROM build AS vulnscan
COPY --from=aquasec/trivy:latest /usr/local/bin/trivy /usr/local/bin/trivy
RUN trivy rootfs --no-progress /

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/workspace/app/app.jar"]
