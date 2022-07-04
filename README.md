# EDIPOGRAM

Progetto del corso di Architetture dei sistemi software per l'anno accademico 2021-2022. 

Team:
- Colonnello Matteo
- Falanga Martina
- Fippi Daniele
- Romualdi Gabriele

# Indicazioni per l'esecuzione

E' possibile eseguire i servizi in due modalità: Default e Kubernetes.

La modalità "default" è stata designata per l'esecuzione con Docker Compose, testabile su ambiente workstation.

La modalità "kubernetes" è pensata per l'esecuzione su cluster Kubernetes, testabile su ambiente kube-cluster.

Come da prassi, il progetto va compilato con Gradle
```
gradle clean build
```

## Esecuzione con Docker Compose

Posizionarsi con il Terminale nella directory del progetto ed eseguire i seguenti comandi

```
docker-compose build
docker-compose up -d
```
Se si desidera eseguire più istanze per i servizi principali
```
docker-compose up -d --scale enigmi=2 --scale connessioni=2 --scale enigmi-seguiti=2
```

Per eseguire alcuni test per verificare che lo scenario principale funzioni, digitare
```
./run/docker/do-init-enigmi.sh
./run/docker/do-init-connessioni.sh

./run/docker/run-curl-client.sh
```

Lo scenario principale prevede la creazione di alcuni enigmi e di alcune connessioni e, successivamente, la loro visualizzazione su Terminale.

Per arrestare l'esecuzione dei container
```
docker-compose down
```


## Esecuzione con Kubernetes

Posizionarsi con il Terminale nella directory del progetto ed eseguire i seguenti comandi

```
./deploy-edipogram.sh
```

L'esecuzione dello scenario principale è analoga al caso di Docker Compose
```
./run/kubernetes/do-init-enigmi.sh
./run/kubernetes/do-init-connessioni.sh

./run/kubernetes/run-curl-client.sh
```
Per arrestare l'esecuzione dell'applicazione
```
./undeploy-edipogram.sh
```

# Soluzioni e tecnologie

- Ogni servizio è un'applicazione Spring Boot autonoma, che si basa su un database PostgreSQL per la persistenza dei dati.
- Consul è il service discovery utilizzato, usato anche per il monitoraggio dello stato di salute dei servizi.
- Kafka è il message broker utilizzato nella soluzione con Docker
- Ogni servizio viene eseguito in un container Docker apposito
- E' possibile eseguire l'applicazione anche con Kubernetes su più nodi

Nella soluzione che utilizza solo Docker (Docker Compose) gli eventi di creazione Enigmi e Connessioni vengono pubblicati su apposito topic Kafka, i quali vengono poi consumati da enigmi-seguiti.
Nella soluzione di Kubernetes non è stato adottato l'utilizzo di un message broker, bensì vengono effettuate delle invocazioni remote asincrone da enigmi e connessioni verso enigmi-seguiti.

Nei file di configurazione (application.yml) delle diverse applicazioni è possibile modificare la modalità di comunicazione da enigmi e connessioni verso enigmi-seguiti, settando in modo opportuno la proprietà
```
asw.edipogram.mode=modalità
```
Ci sono tre possibili modalità:
- MESSAGE: pubblicazione degli eventi in una coda di messaggi
- REST: invocazione remota
- REST_ASYNC: invocazione remota asincrona
