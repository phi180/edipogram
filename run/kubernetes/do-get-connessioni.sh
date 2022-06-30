#!/bin/bash

# trova tutte le connessioni 

echo "# tutte le connessioni" 
echo $(curl -s kube-cluster:32082/connessioni/connessioni)
echo 

