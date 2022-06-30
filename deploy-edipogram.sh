#!/bin/bash

echo 'Starting edipogram' 

kubectl create namespace edipogram
#kubectl create -f 'https://strimzi.io/install/latest?namespace=edipogram' -n edipogram
kubectl create -f edipogram-application.yaml -n edipogram

# kubectl rollout status deployment/edipogram -n sentence

