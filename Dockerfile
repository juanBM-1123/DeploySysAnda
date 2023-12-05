# Usa una imagen base de OpenJDK 17
#FROM adoptopenjdk:17-jdk-hotspot

# Establece el directorio de trabajo en /app
#WORKDIR /app

# Copia el archivo JAR construido en la imagen (asegúrate de que el JAR se llama correctamente)
#COPY target/anda-igf-0.0.1-SNAPSHOT.jar anda-igf.jar

# Expone el puerto en el que se ejecuta la aplicación (ajusta según la configuración de tu aplicación)
#EXPOSE 9000

# Comando para ejecutar la aplicación cuando se inicia el contenedor
#CMD ["java", "-jar", "anda-igf.jar"]

FROM openjdk:17-slim
ADD ./docker-spring-boot.jar docker-spring-boot.jar
ENTRYPOINT ["java",".jar","docker-spring-boot"]