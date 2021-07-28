# ecommerce-microservices
## System based on microservices architecture that simulates an ecommerce

This project uses a simple ecommerce simulation as the background to study the construction of systems based on microservices architecture.

### Project mockup

![project-mockup-image](https://i.imgur.com/RojglBm.png)

### Modules explanation

The `product-catalog` is a service for managing products available on the catalog of the ecommerce with Elasticsearch.

The `shopping-cart` is a service which manages shopping carts instanciations and its items.

The `config-server` fetches the configs from a git repository called ![config-server-resources](https://github.com/Yofiel/config-server-resources). Explaining better, is a 
microservice that uses Spring Cloud Config to make configurations available via http. 
The applications that make requests to the config-server can consult their necessary configurations at 
startup or during the life cycle, this way, changing a configuration in the `application.yml` file will not require the
application to be rebuilt.

The `service-discovery` provides a REST API for registering and querying service instances, allowing services to communicate with each 
other without hardcoding the communicating specifications in the microservices. This Service Discovery is the Netflix Eureka Discovery.

The `gateway` implements Spring Cloud Gateway, which provides a flexible way of routing requests based on a number of criteria.
Spring Cloud Gateway sit between a requester (client, like a frontend) and a resource that’s being requested, intercepting every request,
making possible route requests based on their context.

### Requirements

Java 11, Maven and Docker are necessary.

I recommend reading the `pom.xml` of each microservice for better understanding of the microservices dependencies.

A docker-compose file is available at the root folder of this project. 
You will need to run `docker-compose up` to make Elasticsearch and Redis available. `product-catalog` uses Elasticsearch and `shopping-cart` uses Redis.
