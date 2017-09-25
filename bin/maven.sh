#!/usr/bin/env bash

PKG_INSTALLED=$(dpkg-query -W --showformat='${Status}\n' maven|grep "install ok installed")

if [ "" != "$PKG_INSTALLED" ]; then
    echo "MAVEN OPERATION : Already installed"
    exit 0
fi

sudo apt-get install maven