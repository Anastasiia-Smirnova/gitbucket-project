#!/bin/bash

INSTANCES=("$@")

health_check() {
  url=$1
  url_port="${url}:8080"
  if curl -s --max-time 2 --fail $url; then
    echo "$url is up."
    return 0
  else
    echo "$url failed."
    return 1
  fi
}

for instance in "${INSTANCES[@]}"; do
  if ! health_check $instance; then
    echo "Health check failed for $instance."
    exit 1
  fi
done

echo "All instances are healthy."
exit 0
