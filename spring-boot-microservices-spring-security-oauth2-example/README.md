# Spring boot microservice example

This is example of spring boot microservice example with Eureka Server + Eureka Client + Zuul routing

## Checkout repository
```sh
> git clone https://github.com/subhashlamba/spring-microservices.git
> cd spring-boot-microservices-spring-security-oauth2-example
```
## Step 1: Build and run all services

## For windows:

```sh
mvn clean install -f .\spring-boot-cloud-eureka-server\pom.xml && ^
mvn clean install -f .\spring-boot-cloud-eureka-account-service\pom.xml && ^
mvn clean install -f .\spring-boot-cloud-zuul-routing\pom.xml && ^
mvn clean install -f .\spring-boot-spring-security-auth2.0-authentication-service\pom.xml && ^


START "" java -jar spring-boot-cloud-eureka-server/target/eureka-server.jar 
START "" java -jar spring-boot-cloud-eureka-account-service/target/account-service.jar --server.port=8181
START "" java -jar spring-boot-cloud-eureka-account-service/target/account-service.jar --server.port=8182
START "" java -jar spring-boot-cloud-eureka-account-service/target/account-service.jar --server.port=8183
START "" java -jar spring-boot-cloud-zuul-routing/target/zuul-router.jar --server.port=8080 
START "" java -jar spring-boot-spring-security-auth2.0-authentication-service/target/authentication-service.jar 
```

## For Linux/Ubuntu

```sh
mvn clean install -f .\spring-boot-cloud-eureka-server\pom.xml 
mvn clean install -f .\spring-boot-cloud-eureka-account-service\pom.xml 
mvn clean install -f .\spring-boot-cloud-zuul-routing\pom.xml 
mvn clean install -f .\spring-boot-spring-security-auth2.0-authentication-service\pom.xml 


START "" java -jar spring-boot-cloud-eureka-server/target/eureka-server.jar 
START "" java -jar spring-boot-cloud-eureka-account-service/target/account-service.jar --server.port=8181
START "" java -jar spring-boot-cloud-eureka-account-service/target/account-service.jar --server.port=8182
START "" java -jar spring-boot-cloud-eureka-account-service/target/account-service.jar --server.port=8183
START "" java -jar spring-boot-cloud-zuul-routing/target/zuul-router.jar --server.port=8080 
START "" java -jar spring-boot-spring-security-auth2.0-authentication-service/target/authentication-service.jar
```

## Step 2: Eureka Server

Eureka server is running 8761 port, Now let's open it. Where we can check that:

* 3 instances of account-server is running.
* 1 instance of authentication server is running
* 1 instance of zuul server is running

### Eureka server : [http://localhost:8761/](http://localhost:8761/)

![eureka server](spring-boot-microservices-spring-security-oauth2-example-eureka-server.PNG)


## Step 3: Account Service

Account service is one of our business service, we can create many other services as per our needs. Here we have started 3 instance 
of account service that we can increase as per our need. 

## Step 4: Zuul Server

Zuul Server is routing server where we will fire the request:

Now let's generate token:
```sh
curl -X POST \
  http://localhost:8080/login/oauth/token \
  -H 'authorization: Basic amF2YWRldmVsb3BlcnpvbmU6c2VjcmV0' \
  -H 'cache-control: no-cache' \
  -H 'content-type: multipart/form-data; boundary=----WebKitFormBoundary7MA4YWxkTrZu0gW' \
  -H 'postman-token: 0ac9195c-9c09-1f63-43d4-3b40ec8b5909' \
  -F grant_type=password \
  -F username=zone1 \
  -F password=mypassword \
  -F client_id=javadeveloperzone
``` 
It will give output like:
``` 
{
    "access_token": "c1c0c1dd-4bd4-407a-ad83-6f697f498fe6",
    "token_type": "bearer",
    "refresh_token": "9feba848-cc70-487c-8960-2ca011a6034c",
    "expires_in": 1961,
    "scope": "read write"
}
```
Now let's access actualt resource/service
```sh
curl -X GET \
  http://localhost:8080/account/getAccountDetails \
  -H 'authorization: Bearer c1c0c1dd-4bd4-407a-ad83-6f697f498fe6' \
  -H 'cache-control: no-cache' \
  -H 'content-type: multipart/form-data; boundary=----WebKitFormBoundary7MA4YWxkTrZu0gW' \
  -H 'postman-token: d4313264-e6ac-38d6-240b-35a3208c0c42'
``` 
It will return data:


This secured response from : 8183
