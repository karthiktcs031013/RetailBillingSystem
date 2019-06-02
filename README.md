
## Pre Requirement

Maven and Java 1.8 and Maven should be preinstalled to run this solution.

## Download Git Repository

git clone https://github.com/karthiktcs031013/billing.git

## Setup
# Change Directory

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

````
Once its Lanuched, You can execute below URL

## Swagger UI

http://localhost:8080/swagger-ui.html

From that Swagger UI, Click billing-controller and choose /billing/netpay endpoint,

The you can try it with valid example JSON from Swagger UI.

## To Launch H2 Console,

```
http://localhost:8080/h2-console/
UName:sa
PWD:password
```
To Run the Basic functionalities,  prepopulated Below Customer details in H2 Database,



|CUSTOMER_ID|    NAME     |     EMAIL     |    MOBILE_NO    |     CATEGORY    |EMPLOYEE_ID|AFFILIATE_ID|SUBSCRIBE_DATE|
|-----------|-------------|---------------|-----------------|-----------------|-----------|------------|--------------|
|     1	    |    Aliko	  |  abc@gmail.com|	+832423434      |	       E	      |        1	|      null	 | 2019-06-03   |
2	Bala	def@gmail.com	+832423434	A	null	1	2019-06-03
3	Rohit	erf@gmail.com	+832423434	NA	null	null	2019-06-03
4	Ram	ram@gmail.com	+832423434	NA	null	null	2015-12-15
(4 rows, 14 ms)


UML Diagrams are committed with UML Folder for your reference

## Sample Request For Obtaining Discount For Employees






