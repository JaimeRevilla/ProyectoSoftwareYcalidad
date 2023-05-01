DEUSTOIKEA
============================

To run the following proyect you must run these commands:

SERVER
============================

To build everything and enhance the DB classes / To compile classes and run the unit tests:

      mvn clean compile / mvn test

To link the database correctly with the proyect:

      mysql –uroot -p < sql/DeustoIkeaBD.sql

To create database schema for this sample.

      mvn datanucleus:schema-create

To launch the server:

      mvn jetty:run

CLIENT
============================

You have to open another command prompt and execute the following command for running the client:

      mvn exec:java -Pclient
