FROM adoptopenjdk/openjdk11:jre-11.0.9_11-alpine
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} database.jar
ENTRYPOINT ["java","-jar","/database.jar"]