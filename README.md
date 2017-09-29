# PETSHOP - Medicine \\(o_0)/ #

# ENVIRONMENT #

* Java - 1.7.0
* Maven - 3.3.9
* Tomcat - 8.5.20
* PostgreSQL - 9.6

# INSTALL #

1. for Linux(Mint, Ubuntu)
    * STEP 1 : Install **environment**
            
            $cd bin
            $bash ./env.sh
            
    * STEP 2 : Install **dependencies**
    
            $mvn clean install
            
    * STEP 3 : Create temporary table
        
            $cd bin
            $bash ./tmp_database.sh
           

# ON END OF WORK #

* CLEAN TEMPORARY DATA
        
        $cd bin
        $bash ./clear_all.sh

# TODO #
* ~~shell - install environment~~
* ~~maven - setting pom.xml~~
* ~~make backend and CRUD~~
* ~~make frontend~~


