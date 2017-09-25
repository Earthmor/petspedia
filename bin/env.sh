#!/usr/bin/env bash
#Thit script need to install all environment for current application
#Be careful!!!Some commands can break down your local settings, for example DB

TOMCAT_VER="8.5.20"
TOMCAT_LINK="http://apache-mirror.rbc.ru/pub/apache/tomcat/tomcat-8/v8.5.20/bin/apache-tomcat-8.5.20.tar.gz"
POSTGRESQL_VER="9.6"

echo "----------------------------------------------PETSHOP - INSTALLER------------------------------------------------"
#
# Install Java
#
echo "                                                                                                                 "
echo "----------------------------------------------PETSHOP - JAVA ----------------------------------------------------"
bash ./java.sh
#
# Install Maven
#
echo "                                                                                                                 "
echo "----------------------------------------------PETSHOP - MAVEN ---------------------------------------------------"
bash ./maven.sh
#
# Install Tomcat
#
echo "                                                                                                                 "
echo "----------------------------------------------PETSHOP - TOMCAT --------------------------------------------------"
bash ./tomcat.sh ${TOMCAT_VER} ${TOMCAT_LINK}
#
# Install database
#
echo "                                                                                                                 "
echo "----------------------------------------------PETSHOP - DATABASE ------------------------------------------------"
bash ./database.sh ${POSTGRESQL_VER}
