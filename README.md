# pcp-service
Base service for new [Spring Boot](http://projects.spring.io/spring-boot/) 
based microservices.

## Getting Started

```bash
git clone git-url
cd pcp-service
mvn spring-boot:run
```

Following are api currently exposed

1. GET doctor by Id
`http://localhost:8080/pcp/doctors/0`

response
```json
{
"id": 0,
"firstName": "Ryan",
"lastName": "Adam",
"location": "Bangalore"
}
,,,

2. GET doctor by Location
`http://localhost:8080/pcp/doctors/location/Bangalore`

response
```json
[
{
"id": 0,
"firstName": "Ryan",
"lastName": "Adam",
"location": "Bangalore"
},
{
"id": 1,
"firstName": "Tom",
"lastName": "Jerry",
"location": "Bangalore"
}
]
,,,

3. POST - create new Doctor

curl -X POST -H "Content-Type: application/json" -H "Cache-Control: no-cache" -H "Postman-Token: 9e7cfef9-affa-08a5-0ab3-8010b45040cc" -d '{"firstName":"Donald","lastName":"Trumb","location":"Kochi"}' "http://localhost:8080/pcp/doctors"

Reponse status will 201 (Created)


## High Level Design 

## Developer Guide

### Build and Test
```bash
mvn clean install
```

