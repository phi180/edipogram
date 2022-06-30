############################################
# Dockerfile per l'applicazione enigmi
############################################

FROM openjdk:17-jdk

ADD build/libs/enigmi.jar enigmi.jar

EXPOSE 8080

ENTRYPOINT ["java", "-Xmx128m", "-Xms128m", "-jar", "enigmi.jar", "--spring.profiles.active=${SPRING_PROFILE}"]

HEALTHCHECK --start-period=30s --interval=10s CMD curl -f http://localhost:8080/actuator/health || exit 1