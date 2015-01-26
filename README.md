BookingManager
==============

Requirements
============
 - Apache Maven 3.x
 - Derby database available at "jdbc:derby://localhost:1527/pa165;create=true"
    - user "pa165"  
    - password: "pa165"

Running application
===================
 - Clean and build whole project - mvn clean install -Dmaven.test.skip=true
 - Run tomcat - mvn tomcat7:run

User registration
=================
 - First registred user is administrator
 - Other users are clients

project wiki: https://github.com/sestakjakub/BookingManager/wiki
