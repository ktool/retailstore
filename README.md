# Project Title

Online Retails Store ( Discount module for a billing )

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy or run the project and unit tests.

To satisfy the requirement i used some predefined constansts (enums) which can be part of DB in with real software implementation.

User Types : "STORE_EMPLOYEE" ,  "AFFILIATE" , "CUSTOMER";

Product categories : "GROCERY" , "CLOTH" , "TOY";

## Assumptions and dependancies
There is a requirement of having only one percentage applicable as a discount, I considered from percentage based and amount based discounta and applied only maximum possible discount from both discount.

```
Scenerio : 

let say for CUSTOMER user who just joined before 3 years. In this case user is applicable to 5% discount. If the total bill amount is 540 $ then : <br/>
eligible discount by percentage = 540 * 0.05 = 27 $ <br/>
eligible discount by amount considering 5$ for each 100$ purchase = floor(540/100) * 5 = 25 $ <br/><br/>

In this case, i considered the maximum discount which is 27 $ calculated based on percentage.<br/>
```
### Prerequisites

This Project is build using Spring boot (2.1.5) and Maven.
Its starter project is created using spring provided starter interface. https://start.spring.io/.
Additionally H2 database is used, which is in memory database and respective dependancy added into pom.xml file.

```
* JDK 8 ( JAVA )
* [Maven](https://maven.apache.org/) - Dependency Management
* H2 Database - In Memory database ( no need to install as spring manage it internally ) 
```

### Use source code

Since maven is used as a dependancy management tool, you can import this as a maven project into eclipse. 

Billing Service:


## Running the tests

Tests can be run either on the Code editor (e.g. eclipse) and also one can use maven command line tool: 
```
mvn clean test
```

``Note: To run the project into eclipse, product needs to be imported into eclipse as a maven export`` and 
then from run configuration -> Maven Test

### Integration tests

Integration test include the 1 test of User Repository test to verify the DAO layer.
Service layer tests includes 3 tests for each user type. Store Employee, Affiliate users and customers. 

| File | Layer | Description |
------------------------------------------
| UserRepositoryIntegrationTest | DAO (Repository) | User table repository test  |
| BillingServiceStoreEmployeeIntegrationTest | DAO (Repository) | Billing service tests for Store Employee use case |
| BillingServiceAffiliateUserIntegrationTest | DAO (Repository) | Billing service tests for Affiliate use case |
| BillingServiceOldUserIntegrationTest | DAO (Repository) | Billing service tests for customer registered before 2 years use case |

## Deployment

Create a build file (WAR) and deploy on Jetty or Tomcat server webapp.
```
mvn clean install
```
Copy *retailstore-0.0.1.war* file from /target directory and paste it to respective webroot directory of tomcat or jetty container. Since we use h2 database no additional configurations required.

## Authors

* **Ketul Shah**
