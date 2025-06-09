# Etapa de construcción (build)
FROM maven:3.9-amazoncorretto-17 AS builder
WORKDIR /app
COPY pom.xml .
# Descarga dependencias primero (cachea para builds más rápidos)
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn clean package -DskipTests

# Etapa de ejecución
FROM amazoncorretto:17-alpine
WORKDIR /app
# Copia solo el JAR (no todo /target)
COPY --from=builder /app/target/*.jar app.jar
# Variables de conexión a MySQL (puedes sobreescribirlas con -e)
ENV SPRING_DATASOURCE_URL=jdbc:mysql://mysql.railway.internal:3306/railway
ENV SPRING_DATASOURCE_USERNAME=root
ENV SPRING_DATASOURCE_PASSWORD=AyAiRUqEZduDSPcmVCSWETpqWvSOBMLm

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]