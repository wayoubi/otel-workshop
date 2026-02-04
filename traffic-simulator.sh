#!/bin/bash

function log() {
  echo $(date  +'%y-%m-%dT%H:%M:%S%Z') "$@"
}

readonly LOCATIONS=("New%20York" "Los%20Angeles" "Chicago" "Houston" "Phoenix")

request_counter=1

while true; do
  
  measurements=$((RANDOM % 10 + 1))
  location=${LOCATIONS[$RANDOM % ${#LOCATIONS[@]}]}
  response=$(curl -s "localhost:9090/simulateTemperature?measurements=$measurements&location=$location")
  
  log "Request# $request_counter: Temperature in ${location} for the next ${measurements}days will be: $response"
  ((request_counter++))
  
  sleep_duration=$((RANDOM % 5 + 1))
  #log "Sleeping for $sleep_duration seconds..."
  sleep $sleep_duration

done