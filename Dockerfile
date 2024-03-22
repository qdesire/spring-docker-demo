FROM maven:3.9-eclipse-temurin-21-alpine

WORKDIR /demo
COPY . .
RUN mvn clean install -Dmaven.test.skip=true

CMD mvn spring-boot:run
