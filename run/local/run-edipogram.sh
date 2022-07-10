#!/bin/bash

# Script per avviare l'applicazione Edipogram 

echo Running EDIPOGRAM 

# Consul deve essere avviato separatamente 

java -Xms64m -Xmx128m -jar -Dspring.profiles.active=local-dev enigmi/build/libs/enigmi.jar &
java -Xms64m -Xmx128m -jar -Dspring.profiles.active=local-dev connessioni/build/libs/connessioni.jar &
java -Xms64m -Xmx128m -jar -Dspring.profiles.active=local-dev enigmi-seguiti/build/libs/enigmi-seguiti.jar &

java -Xms64m -Xmx128m -jar -Dspring.profiles.active=local-dev api-gateway/build/libs/api-gateway.jar &
