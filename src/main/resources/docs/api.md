#Add user
`curl -X POST  -d '{     "name" : "Abhishek Patro",     "city" : "USA",     "age" : 25 }' "http://localhost:8080/v1/person/addperson"`
 
#Response
```json
[
  {
    "city": "USA",
    "name": "Abhishek Patro",
    "id": 2,
    "age": 25
  }
]
```



#Build Ad
`curl -X POST -d '{    "name" : "Harry Potter",    "country" : "USA",    "impressions" : 12343,    "personId" : 2}' "http://localhost:8080/v1/ad/buildad"`

#Response
```json
[
  {
    "ctr": 0,
    "country": "USA",
    "amountLeft": 0,
    "imageId": 2,
    "clickCount": 0,
    "boundaryId": 0,
    "name": "Harry Potter",
    "personId": 0,
    "id": 2,
    "impressions": 12343,
    "budget": 0
  }
]
```

#Get All Ads
`curl -X GET "http://localhost:8080/v1/ad/getads"`

#Response
```json
[
  {
    "ctr": 0,
    "country": "USA",
    "amountLeft": 0,
    "imageId": 1,
    "clickCount": 0,
    "boundaryId": 0,
    "name": "hello world",
    "personId": 0,
    "id": 1,
    "impressions": 123434,
    "budget": 0
  },
  {
    "ctr": 0,
    "country": "USA",
    "amountLeft": 0,
    "imageId": 2,
    "clickCount": 0,
    "boundaryId": 0,
    "name": "Harry Potter",
    "personId": 0,
    "id": 2,
    "impressions": 12343,
    "budget": 0
  },
  {
    "ctr": 0,
    "country": "USA",
    "amountLeft": 0,
    "imageId": 3,
    "clickCount": 0,
    "boundaryId": 0,
    "name": "Beyblade",
    "personId": 0,
    "id": 3,
    "impressions": 12343,
    "budget": 0
  },
  {
    "ctr": 0,
    "country": "USA",
    "amountLeft": 0,
    "imageId": 4,
    "clickCount": 0,
    "boundaryId": 0,
    "name": "Pokemon",
    "personId": 0,
    "id": 4,
    "impressions": 12343,
    "budget": 0
  }
]
```


#Increase Click Count
`curl -X POST  -d '{    "id" : 1    }' "http://localhost:8080/v1/ad/clickad"`

#Response
```
[
  {
    "ctr": 0.00405074776803798,
    "country": "USA",
    "amountLeft": 0,
    "imageId": 1,
    "clickCount": 5,
    "boundaryId": 0,
    "name": "hello world",
    "personId": 0,
    "id": 1,
    "impressions": 123434,
    "budget": 0
  }
]
```