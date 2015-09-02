#!/usr/bin/env bash

#get the tag name to deploy
tagname=$1

if [ $# -ne 1 ]; then
    echo "$0: usage: deploy_ontarget_prod.sh <tag to be deployed>"
    echo "tag comes from git repository"
    exit 1
fi


