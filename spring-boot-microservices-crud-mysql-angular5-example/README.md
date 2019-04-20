# Spring boot microservice example

This is example of spring boot microservice example with Eureka Server + Eureka Client + Zuul routing + MySQL database + Angular 2 
## Checkout repository
```sh
> git clone https://github.com/subhashlamba/spring-microservices.git
> cd spring-boot-microservices-crud-mysql-angular5-example
```

## Step 1:
Go to application.yml and change database configurations. 
`spring-boot-microservices-crud-mysql-angular5-example/spring-boot-cloud-eureka-account-service/src/main/resources/application.yml`

## Step 2:

## For windows:

```sh
mvn clean install -f .\spring-boot-cloud-eureka-server\pom.xml
mvn clean install -f .\spring-boot-cloud-eureka-account-service\pom.xml
mvn clean install -f .\spring-boot-cloud-zuul-routing\pom.xml

START "" java -jar spring-boot-cloud-eureka-server/target/eureka-server.jar 
START "" java -jar spring-boot-cloud-eureka-account-service/target/account-service.jar --server.port=8181
START "" java -jar spring-boot-cloud-eureka-account-service/target/account-service.jar --server.port=8182
START "" java -jar spring-boot-cloud-eureka-account-service/target/account-service.jar --server.port=8183
START "" java -jar spring-boot-cloud-zuul-routing/target/zuul-router.jar --server.port=8080 
```

## For Linux/Ubuntu

```sh
mvn clean install -f .\spring-boot-cloud-eureka-server\pom.xml
mvn clean install -f .\spring-boot-cloud-eureka-account-service\pom.xml
mvn clean install -f .\spring-boot-cloud-zuul-routing\pom.xml

java -jar spring-boot-cloud-eureka-server/target/eureka-server.jar &
java -jar spring-boot-cloud-eureka-account-service/target/account-service.jar --server.port=8181 &
java -jar spring-boot-cloud-eureka-account-service/target/account-service.jar --server.port=8182 &
java -jar spring-boot-cloud-eureka-account-service/target/account-service.jar --server.port=8183 &
java -jar spring-boot-cloud-zuul-routing/target/zuul-router.jar --server.port=8080 & 
```


## Step 3: Eureka Server

Eureka server is running 8761 port, Now let's open it. Where we can check that 3 instance of account-server is running.

### Eureka server : [http://localhost:8761/](http://localhost:8761/)

## Step 4: Account Service

Account service is one of our business service, we can create many other services as per our needs. Here we have started 3 instance 
of account service that we can increase as per our need. 

## Step 6: Start Anguler UI 

```sh
cd Angular-2-UI
npm install
ng serve
```
Once UI Server has been start, Visit and perform CRUD Operations:

http://localhost:4200/add-employee