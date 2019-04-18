# Spring boot microservice example [![Build Status](https://travis-ci.com/subhashlamba/spring-microservices.svg?branch=master)](https://travis-ci.com/subhashlamba/spring-microservices)


This is example of spring boot microservice example with Eureka Server + Eureka Client + Zuul routing

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

## Eureka Server

Eureka server is running 8761 port, Now let's open it. Where we can check that 3 instance of account-server is running.

### Eureka server : [http://localhost:8761/](http://localhost:8761/)

## Account Service

Account service is one of our business service, we can create many other services as per our needs. Here we have started 3 instance 
of account service that we can increase as per our need. 

## Zuul Server

Zuul Server is routing server where we will fire the request:

Now let's call our service using through zuul:

http://localhost:8080/account/getAccountDetails

It will give output like:

This response from : 8182

