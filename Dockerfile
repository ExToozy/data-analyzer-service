FROM gradle:jdk17-alpine as build
COPY /src /src
COPY build.gradle /
COPY settings.gradle /
RUN gradle clean jar

FROM openjdk:17-jdk-slim
COPY --from=build /target/*.jar app.jar
EXPOSE 8082
ENTRYPOINT ["java", "jar", "app.jar"]