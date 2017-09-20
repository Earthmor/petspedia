#!/usr/bin/env bash

VERSION="tomcat$1"
LINK=$2
DIR_TO_INSTALL="/opt/$VERSION"
TMP_DIR="/tmp/$VERSION"

echo " "
echo "  Version - $VERSION"
echo "  Directory to install - $DIR_TO_INSTALL"
echo "  Temporary directory - $TMP_DIR"
echo " "

if [ ! -d "/tmp" ]; then
    sudo mkdir /tmp
fi

sudo wget -O /tmp/${VERSION}.tar.gz ${LINK}
sudo tar -xf /tmp/${VERSION}.tar.gz -C /tmp

if [ ! -d "/opt/$VERSION" ]; then
    sudo mkdir /opt/${VERSION}
    sudo mv /tmp/apache-tomcat-$1/* /opt/${VERSION}
else
    echo "TOMCAT OPERATION: Sorry, but you have already folder /opt/${VERSION}. Please check it and remove/rename if it necessary"
fi

sudo rm -r /tmp/apache-tomcat-$1
sudo rm /tmp/${VERSION}.tar.gz

if [ -n "$(ls -A /opt/${VERSION})" ]; then
    echo "commands to start:"
    echo "  start : /opt/${VERSION}/bin/startup.sh"
    echo "  stop  : /opt/${VERSION}/bin/shutdown.sh"
    echo "TOMCAT OPERATION: SUCCESSFUL"
else
    echo "TOMCAT OPERATION: dir /opt/${VERSION} is empty"
fi