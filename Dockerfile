# Etapa de compilación
FROM maven:3.9-amazoncorretto-17 AS build
COPY . .
RUN mvn clean install -DskipTests

# Etapa final
FROM amazoncorretto:17-alpine
COPY --from=build /target/*.jar demo.jar
ENTRYPOINT ["java", "-jar", "demo.jar"]