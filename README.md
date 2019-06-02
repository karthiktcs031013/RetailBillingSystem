
## Pre Requirement

Maven and Java 1.8 and Maven should be preinstalled to run this solution.

## Download Git Repository

git clone https://github.com/karthiktcs031013/billing.git

## Setup
#Change Directory

cd billing

Execute Below command in Git Shell / Any linux env

```
billing>$ bin/setup.sh
```
command all solution will be complied and ready for execution

## Launch Billing Service

You can run the full suite from `billing_service` by doing
```
billing>$ bin/billing_service.sh

Once its Lanuched, You can execute below URL

##Swagger UI

http://localhost:8080/swagger-ui.html

From that Swagger UI, Click billing-controller and choose /billing/netpay endpoint,

The you can try it with valid example JSON from Swagger UI.

##To Launch H2 Console,

http://localhost:8080/h2-console/
UName:sa
PWD:password

# UML Diagrams are committed with UML Folder for your reference





