#!/usr/bin/env bash

####### set up git ssh using https://confluence.atlassian.com/bitbucket/set-up-ssh-for-git-and-mercurial-on-mac-osx-linux-270827678.html

now=$(date +%Y%m%d%H%M%S)
export logfile=deployment.$now

function logit
{
    now=$(date +%Y/%m/%dT%H:%M:%S)
    echo "$now: $*" >> $logfile
    echo "$now: $*:"
}

#get the environment first where it needs to be deployed.
environment=$1
tagname=$2

if [ $# -ne 2 ]; then
    logit "$0: usage: deploy_ontarget.sh local|int|production <tag name to be deployed>"
    exit 1
fi

export -f logit

logit "Deploying ontarget application to $environment"
./deploy_ontarget_$environment.sh $tagname

logit "DONE!!"