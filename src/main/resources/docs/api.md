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
`curl -X POST -d '{    "name" : "Harry Potter",    "country" : "USA",    "budget" : 10000.0,    "personId" : 2}' "http://localhost:8080/v1/ad/buildad"`

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
    "impressions": 0,
    "budget": 10000.0
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
`curl -X POST  -d '{    "id" : 10    }' "http://localhost:8080/v1/ad/clickad"`

#Response
```json
[
  {
    "ctr": 0,
    "country": "USA",
    "imageId": 10,
    "clickCount": 1,
    "impressions": 0,
    "type": "video",
    "url": "",
    "amountLeft": 9998,
    "boundaryId": 0,
    "name": "Made in India",
    "personId": 0,
    "id": 10,
    "budget": 10000
  }
]
```



#Increase Impression Count
`curl -X POST  -d '{    "id" : 10    }' "http://localhost:8080/v1/ad/impressionad"`

#Response
```json
[
  {
    "ctr": 0,
    "country": "USA",
    "imageId": 10,
    "clickCount": 1,
    "impressions": 0,
    "type": "video",
    "url": "",
    "amountLeft": 9997,
    "boundaryId": 0,
    "name": "Made in India",
    "personId": 0,
    "id": 10,
    "budget": 10000
  }
]
```
