#!/bin/bash
locations=("New%20York" "Los%20Angeles" "Chicago" "Houston" "Phoenix")
request_counter=1
while true; do
  measurements=$((RANDOM % 10 + 1))
  location=${locations[$RANDOM % ${#locations[@]}]}
  response=$(curl -s "localhost:9090/simulateTemperature?measurements=$measurements&location=$location")
  echo "Request $request_counter: Response: $response"
  ((request_counter++))
  sleep_duration=$((RANDOM % 5 + 1))
  echo "Sleeping for $sleep_duration seconds..."
  sleep $sleep_duration
done
