FROM openjdk:22
LABEL authors="keenj"

# Копируем jar файл приложения
COPY target/fileservice-0.0.1-SNAPSHOT.jar app.jar

# Запускаем приложение
ENTRYPOINT ["java", "-jar", "app.jar"]