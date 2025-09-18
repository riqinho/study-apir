# Etapa 1: build
FROM maven:3.9.11-eclipse-temurin-17 AS build
WORKDIR /opt/app
COPY . .
RUN mvn clean package 

# Etapa 2: Runtime
FROM eclipse-temurin:17-alpine-3.22
RUN mkdir /opt/app
COPY --from=build /opt/app/target/app.jar /opt/app/app.jar
WORKDIR /opt/app
CMD [ "java", "-jar", "app.jar"]