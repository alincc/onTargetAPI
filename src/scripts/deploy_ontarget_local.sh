#!/usr/bin/env bash


logit "running deploy_ontarget_local.sh"

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
if [ -d "ontargetrs" ]; then
  cd ontargetrs
  git pull origin $tagname
    if [[ $? -ne 0 ]] ; then
        logit "Error while pulling ontarget api for tag $tagname"
        exit 1
    fi
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

### do the maven build for local.

mvn clean install -DskipTests

if [ $? -ne 0 ]; then
    echo "$0: Maven build failed"
    exit 1
fi

logit "done building with maven"

#### stop tomcat
sudo /usr/local/tomcat8/bin/shutdown.sh

if [ $? -ne 0 ]; then
    echo "$0: Error while stopping tomcat."
    exit 1
fi

#undeploy current folder
sudo rm -rf /usr/local/tomcat8/webapps/ontargetrs

if [ $? -ne 0 ]; then
    echo "$0: Error while deleting ontargetrs from tomcat"
    exit 1
fi

sudo rm -rf /usr/local/tomcat8/webapps/ontargetrs.war
if [ $? -ne 0 ]; then
    echo "$0: Error while deleting ontargetrs.war from tomcat"
    exit 1
fi


#copy the new war generated from target directory to tomcat directory
sudo cp target/ontargetrs.war /usr/local/tomcat8/webapps/

if [ $? -ne 0 ]; then
    echo "$0: Error while copying ontargetrs.war to tomcat"
    exit 1
fi

# restart tomcat
sudo /usr/local/tomcat8/bin/startup.sh

if [ $? -ne 0 ]; then
    echo "$0: Error while starting tomcat instance"
    exit 1
fi

logit "Done starting tomcat. Please wait few minutes to fully start. you can check tomcat logs."

