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
```

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
```

3. POST - create new Doctor

Download and install [postman](https://www.google.com/url?sa=t&rct=j&q=&esrc=s&source=web&cd=1&ved=0ahUKEwj6rLWxqufRAhXC4iYKHWeaDs4QFggcMAA&url=https%3A%2F%2Fchrome.google.com%2Fwebstore%2Fdetail%2Fpostman%2Ffhbjgbiflinjbdggehcddcbncdddomop%3Fhl%3Den&usg=AFQjCNE_Yq59TT1ZExzJ68FTldg4ho_lGw&sig2=6CibPoz_Mn_6UuCyM1xLqQ)
url - `http://localhost:8080/pcp/doctors`

Request body :
```json
{
  "firstName": "Donald",
  "lastName": "Trumb",
  "location": "Kochi"
}
```

alternate option is to use cURL -

``` curl
curl -X POST -H "Content-Type: application/json" -H "Cache-Control: no-cache" -H "Postman-Token: 9e7cfef9-affa-08a5-0ab3-8010b45040cc" -d '{"firstName":"Donald","lastName":"Trumb","location":"Kochi"}' "http://localhost:8080/pcp/doctors"
```

Response status will be created with 201 HTTP status code


## High Level Design 

## Developer Guide

### Build and Test
```bash
mvn clean install
```

## Travis integration for CI
[pcp build](https://travis-ci.org/nbenjamin/pcp)

