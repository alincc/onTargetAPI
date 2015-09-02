#!/usr/bin/env bash

#get the project encrypted name passed by the api
projectFolderEncryptedName=$1


if [ $# -ne 1 ]; then
    echo "$0: usage: create_project_asset_folder.sh <encrypted folder name>"
    exit 1
fi

#change the directory to projects folder
cd /apps/ontarget/assets/projects

echo "`date -u` changed directory to folder: "
printf '%s\n' "${PWD}"
echo "\n##############################################"

#start making directory
mkdir -p "${projectFolderEncryptedName}"
if [[ $? -ne 0 ]] ; then
    echo "`date -u` Error while creating ${projectFolderEncryptedName} folder"
    exit 1
fi

cd "$projectFolderEncryptedName"


#Log file setup
logfile=/apps/ontarget/assets/projects/${projectFolderEncryptedName}/${projectFolderEncryptedName}.txt
mkfifo ${logfile}.pipe
tee < ${logfile}.pipe $logfile &
exec &> ${logfile}.pipe
rm ${logfile}.pipe
#Log file setup end

#start creating default folders

mkdir -p onsite
if [[ $? -ne 0 ]] ; then
    echo "`date -u` Error while creating onsite folder"
    exit 1
fi
echo "`date -u` Successfully create onsite folder"


mkdir -p task
if [[ $? -ne 0 ]] ; then
    echo "`date -u` Error while creating task folder"
    exit 1
fi
echo "`date -u` Successfully create task folder"

mkdir -p onfile
if [[ $? -ne 0 ]] ; then
    echo "`date -u` Error while creating onfile folder"
    exit 1
fi
echo "`date -u` Successfully create onfile folder"

echo "##############################################"

echo "`date -u` Successfully create all folders for project folder $projectFolderEncryptedName"