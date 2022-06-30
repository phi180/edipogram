############################################
# Dockerfile per l'applicazione enigmi-seguiti
############################################

FROM openjdk:17-jdk

ADD build/libs/enigmi-seguiti.jar enigmi-seguiti.jar

EXPOSE 8080

ENTRYPOINT ["java", "-Xmx128m", "-Xms128m", "-jar", "enigmi-seguiti.jar", "--spring.profiles.active=${SPRING_PROFILE}"]

HEALTHCHECK --start-period=30s --interval=10s CMD curl -f http://localhost:8080/actuator/health || exit 1