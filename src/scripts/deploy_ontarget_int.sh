#!/usr/bin/env bash

logit "running deploy_ontarget_int.sh"

# go to ontarget source directory
tagname=$1

if [ $# -ne 1 ]; then
    logit "$0: usage: deploy_ontarget_int.sh <tagname>"
    exit 1
fi

logit "tagname to be deployed: $tagname"

#go to deployment directory
cd /apps/ontarget/deployment/build

#pull the changes for a particular branch.
#
if [ -d "$tagname" ]; then
  cd $tagname
  git pull origin $tagname
else
    #for this ssh key has to be setup in bitbucket and the machine where cloning is done
    logit "Cloning the tag and building."
    git clone git@bitbucket.org:ontargetapi/ontargetrs.git

    if [[ $? -ne 0 ]] ; then
        logit "Error while cloning ontarget api"
        exit 1
    fi

    cd ontargetrs

    git checkout $tagname

    if [[ $? -ne 0 ]] ; then
        logit "Error while checking out  ontarget api tag $tagname"
        exit 1
    fi
fi