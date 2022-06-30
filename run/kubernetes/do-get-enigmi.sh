#!/bin/bash

# trova tutti gli enigmi 

echo "# trova tutti gli enigmi" 
echo $(curl -s kube-cluster:32082/enigmi/enigmi)
echo 

