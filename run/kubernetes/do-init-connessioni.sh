#!/bin/bash

# inizializza il db delle connessioni 

# connessioni  

curl -X POST "http://kube-cluster:32082/connessioni/connessioni" -H "accept: */*" -H "Content-Type: application/json" \
     -d "{ \"utente\": \"Alice\", \"tipo\": \"Cambio\"}"
echo 

curl -X POST "http://kube-cluster:32082/connessioni/connessioni" -H "accept: */*" -H "Content-Type: application/json" \
     -d "{ \"utente\": \"Alice\", \"tipo\": \"Anagramma\"}"
echo 

curl -X POST "http://kube-cluster:32082/connessioni/connessioni" -H "accept: */*" -H "Content-Type: application/json" \
     -d "{ \"utente\": \"Barbara\", \"tipo\": \"Indovinello\"}"
echo 

curl -X POST "http://kube-cluster:32082/connessioni/connessioni" -H "accept: */*" -H "Content-Type: application/json" \
     -d "{ \"utente\": \"Carlo\", \"tipo\": \"Anagramma\"}"
echo 

curl -X POST "http://kube-cluster:32082/connessioni/connessioni" -H "accept: */*" -H "Content-Type: application/json" \
     -d "{ \"utente\": \"Enrico\", \"tipo\": \"Anagramma\"}"
echo 


