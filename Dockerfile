FROM gradle:8.10.2-jdk17 AS build
WORKDIR /app
USER root
RUN mkdir -p /app/.gradle && chown -R gradle:gradle /app
USER gradle

COPY src /app/src
COPY build.gradle /app
COPY settings.gradle /app

RUN gradle clean build --no-daemon --refresh-dependencies --stacktrace -Dorg.gradle.jvmargs="-Xmx2g"

FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/build/libs/data-analyzer-service-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "app.jar"]