#!/usr/bin/env bash

VERSION=$1
PKG_INSTALLED=$(dpkg-query -W --showformat='${Status}\n' postgresql-${VERSION}|grep "install ok installed")

if [ "" != "$PKG_INSTALLED" ]; then
    echo "DATA BASE OPERATION : Already installed"
    exit 0
fi

#
# Add repository for postgresql if necessary
#
sudo sh -c 'echo "deb http://apt.postgresql.org/pub/repos/apt/ jessie-pgdg main" >> /etc/apt/sources.list.d/pgdg.list'
wget -q https://www.postgresql.org/media/keys/ACCC4CF8.asc -O - | sudo apt-key add -

#
# Install clean postgresql's database
#
export LC_ALL=ru_RU.UTF-8
sudo apt-get update
sudo apt-get install postgresql-${VERSION} postgresql-contrib

#
# Some times you can have a problems with installation of pgadmins3
# ("apt-cache policy pgadmin3" to check your version, and i choose the lowest)
#
#sudo apt-get install pgadmin3=1.22.0-1 pgadmin3-data=1.22.0-1

#
# Recreate postgresql cluster
# NOTICE!!!Commands below will clean your current cluster with all data
#
sudo pg_dropcluster ${VERSION} main --stop
sudo pg_createcluster --locale=ru_RU.UTF-8 --encoding=UTF-8 --start ${VERSION} main