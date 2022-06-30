#!/bin/bash

echo 'Halting edipogram' 

kubectl delete -f edipogram-application.yaml -n edipogram
#kubectl delete -f 'https://strimzi.io/install/latest?namespace=edipogram' -n edipogram
kubectl delete namespace edipogram

