# BackendTest Application


### Technological stack
* Spring Boot 2.7.10, Maven
* Java 11
* DDD and Hexagonal Arquitecture
* Testing: Junit5, Mockito
* Database: H2, Spring Data JPA
* Swagger (Api Firs with OpenApi Generator)


### Run the microservice:
1. **Build the app**
```
mvn clean install
```

2. **Run the app to start Spring Boot Application with H2**
```
mvn spring-boot:run
```

### Run tests
```
mvn test
```

### Test the application with swagger:
**Open Swagger and call the endpoints based on the documentation.**

http://localhost:8080/swagger-ui.html

### Test the database H2:
**Open H2 Console and do login with the next credentials.**

http://localhost:8080/h2-console

- JDBC URL:  jdbc:h2:mem:testdb
- User Name: sa
- Password: 




