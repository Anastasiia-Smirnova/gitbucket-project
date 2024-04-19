#!/bin/bash

TAG_KEY="Environment"
BLUE_VALUE="blue"
GREEN_VALUE="green"

BLUE_INSTANCES=$(aws ec2 describe-instances \
    --query "Reservations[*].Instances[*].[InstanceId, LaunchTime]" \
    --filters "Name=tag:$TAG_KEY,Values=$BLUE_VALUE" "Name=instance-state-name,Values=running" \
    --output text | sort -k2 | tail -n1 | cut -f1)

GREEN_INSTANCES=$(aws ec2 describe-instances \
    --query "Reservations[*].Instances[*].[InstanceId, LaunchTime]" \
    --filters "Name=tag:$TAG_KEY,Values=$GREEN_VALUE" "Name=instance-state-name,Values=running" \
    --output text | sort -k2 | tail -n1 | cut -f1)

if [[ -n "$BLUE_INSTANCES" && -n "$GREEN_INSTANCES" ]]; then
    echo "Both blue and green instances are running."
elif [[ -n "$BLUE_INSTANCES" ]]; then
    echo "blue"
elif [[ -n "$GREEN_INSTANCES" ]]; then
    echo "green"
else
    echo "unknown"
fi
