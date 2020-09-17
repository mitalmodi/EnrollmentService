# external-product-map Service
Enrollment service is a service that provides enrollment facility to Customers. This is written in springboot with individual endpoints for adding/deleting enrollers and their dependents


## Building
Use Maven to build the service from the command line by running the following command at the root directory
of the project:

`mvn clean package`

Once the build is complete, the runtime application will be available in the target directory.

## Running
### As Spring boot jar
If you want to run the service locally, simply run the following at the command line from the root directory
of the project:

`mvn spring-boot:run`

Once the service is running, you may access the Swagger UI API [documentation](http://localhost:8080/swagger-ui.html)
page and interact with the service directly from that page.  Alternatively you may submit requests from Postman, 
or even command line using curl)

If you'd like to interact directly with the data the service is running over top of, the embedded H2 database contains
a web based [console](http://localhost:8080/h2-console) that you can use:
- JDBC URL: jdbc:h2:mem:test;DB_CLOSE_ON_EXIT=FALSE;DB_CLOSE_DELAY=-1
- User / Password: sa / sa

You can also view health and metrics through actuator sidecar functionality:
- [Health](http://localhost:8080/actuator/health)
- [Info](http://localhost:8080/actuator/info)