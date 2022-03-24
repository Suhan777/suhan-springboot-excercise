# Simple Spring Boot Application with In-Memory Mongo Db Service 
This repository is a simple demo app that exposes rest endpoints to interact with an 
in memory mongodb server.

# Pre-requistes
 - java 11
 - any mongodb client (optional)

# Build
```sh
mvn package
```
This will build the deployable jar.

# Run
```sh
mvn spring-boot:run 
```
This will run the application in your current terminal. To test the application,
navigate to http://localhost:8080/swagger-ui/ and perform any operation as required.
Add users via the /employeeInfo/addEmployee endpoint or via the /employeeInfo/addEmployees
which accepts a json array of users.