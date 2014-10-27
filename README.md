Jersey REST web service
================================================
Java web application that provide REST web services.

Frameworks & Libraries
======================
* Gradle    : build
* Jersey    : REST web service
* Spring 4  : Dependencies injection
* Jackson 2 : JSON processing
* Jetty     : Servlet container

Testing frameworks : jersey-test, spring-test, junit, spock


Requirements
============
* Java 1.8
* Gradle



Run the build and tests + Package
===============================
Execute the following command:

./gradlew clean build

This will compile, run the tests and package.
The artifact should be available in the directory: build/


Refresh IDE - Intellij IDEA
============================
Execute the following command :

./gradlew idea





Run the application
==============
Compile and run the web application with Jetty plugin:

./gradlew jettyRunWar

With the web app running on Jetty, you can then access the application endpoint from base URL :

http://localhost:8080/jerseyexample/api/*



Accessing the REST API and versioning
======================================
You can use any REST client to access the REST api. If you're using Chrome browser, you can use extensions such as "Advanced Rest Client" to do so.

Example, api URL to access order :

http://localhost:8080/jerseyexample/api/order

The versioning of the API is by the  Accept/Content-Type headers. So for example if you would like to access version 2 of the api, set the following headers on the client:

Accept : "application/vnd.org.wai.jerseyexample-v2+json"


Web Application Description Language (WADL)
=============================================
With the web app running on Jetty, you can access the Jersey generated WADL from the URL below:

http://localhost:8080/jerseyexample/api/application.wadl



