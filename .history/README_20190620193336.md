# Adidas Coding Challenge

## Subscription Service

The scenario consists of a public service where people can subscribe for receiving newsletters, on a public API. It consists of 3 microservices, where only the public api is exposed.

## Tecnologies


* Netflix Zuul for service discovering
* Netflix Eureka for service registry, load balancing and failover
* Sprinfox and Swagger for api documentation
* Postgresql 
* Docker for database containerization
* Spring securty, using io.jsonwebtoken for JWT management
* Spring boot for über application spinning

## Running 
1. make install
2. make run-primary
3. make run-second
4. make run-last

## Acessing
The database will have the initial data if 50 cities and the user "adidas:adidas"  
To get the token: http://localhost:8080/gateway/authentication/v1/auth/signin

## Docs
http://localhost:8080/gateway/itinerary/swagger-ui.html
