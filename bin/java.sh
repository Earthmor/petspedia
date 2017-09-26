#!/usr/bin/env bash

PKG_INSTALLED=$(dpkg-query -W --showformat='${Status}\n' oracle-java8-installer|grep "install ok installed")

if [ "" != "$PKG_INSTALLED" ]; then
    echo "JAVA OPERATION : Already installed"
    exit 0
fi

java_ppa="webupd8team/java"

if ! grep -q "^deb .*$java_ppa" /etc/apt/sources.list /etc/apt/sources.list.d/*; then
    sudo add-apt-repository ppa:webupd8team/java
fi

sudo apt-get update
sudo apt-get install oracle-java8-installer