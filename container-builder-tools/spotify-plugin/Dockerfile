# -----------------------------------------------------------------------------
# FASE 1: DEFINICIÓN DEL DOCKERFILE
# Archivo: /Dockerfile
# -----------------------------------------------------------------------------

# 1. IMAGEN BASE (Best Practice: Usar versiones específicas, no 'latest')
# Explicación: Definimos el JDK sobre el que correrá la app.
# Usamos eclipse-temurin:17-jdk-alpine por ser ligera y segura.
FROM eclipse-temurin:17-jdk-alpine

# 2. ARGUMENTO DE CONSTRUCCIÓN
# Explicación: Definimos una variable para localizar el archivo JAR.
# Maven genera el jar en la carpeta /target.
ARG JAR_FILE=target/*.jar

# 3. COPIA DEL ARTEFACTO (Principio de Inmutabilidad)
# Explicación: Copiamos el JAR desde nuestra máquina anfitriona
# hacia dentro del contenedor, renombrándolo a 'app.jar'.
COPY ${JAR_FILE} app.jar

# 4. PUNTO DE ENTRADA (Exec Form)
# Explicación: Usamos el formato de array ["cmd", "arg"] en lugar de string.
# Best Practice: Esto permite que el contenedor reciba señales del SO (como SIGTERM)
# para apagarse correctamente.
ENTRYPOINT ["java","-jar","/app.jar"]