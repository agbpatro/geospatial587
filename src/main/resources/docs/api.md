# 1 Add user
`curl -X POST -H "Content-Type: application/json"  -d '{     "name" : "Abhishek Patro",     "city" : "USA",     "age" : 25 }' "ec2-35-165-161-51.us-west-2.compute.amazonaws.com:8080/v1/person/addperson"`
 
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



# 2 Build Ad
`curl -X POST -H "Content-Type: application/json" -d '{    "name" : "Club Havana",    "country" : "USA",    "budget" : 10000,    "personId" : 2,    "type" : "video",    "videourl" : "https://www.youtube.com/watch?v=w7IWLZcVU64",    "clickurl" : "https://en.wikipedia.org/wiki/Casablanca_(film)",    "fence": "((0,0),(0,10),(10, 10),(0, 0))"}' "ec2-35-165-161-51.us-west-2.compute.amazonaws.com:8080/v1/ad/buildad"`

#Response
```json
[
  {
    "clickurl": "https://en.wikipedia.org/wiki/Casablanca_(film)",
    "ctr": 0,
    "country": "USA",
    "imageId": 5,
    "clickCount": 0,
    "impressions": 0,
    "type": "video",
    "amountLeft": 10000,
    "videourl": "https://www.youtube.com/watch?v=w7IWLZcVU64",
    "name": "Club Havana",
    "personId": 0,
    "id": 5,
    "fence": "((0.0,0.0),(0.0,10.0),(10.0,10.0),(0.0,0.0))",
    "budget": 10000
  }
]
```

# 3 Get All Ads
`curl -X GET -H "Content-Type: application/json" "ec2-35-165-161-51.us-west-2.compute.amazonaws.com:8080/v1/ad/getads"`

#Response
```json
[
  {
    "ctr": 0,
    "country": "USA",
    "imageId": 1,
    "clickCount": 0,
    "impressions": 9,
    "type": "video",
    "amountLeft": 9991,
    "videourl": "",
    "name": "Made in India",
    "personId": 0,
    "id": 1,
    "fence": "((0.0,0.0),(0.0,10.0),(10.0,10.0),(0.0,0.0))",
    "budget": 10000
  },
  {
    "ctr": 0,
    "country": "USA",
    "imageId": 3,
    "clickCount": 0,
    "impressions": 6,
    "type": "video",
    "amountLeft": 9994,
    "videourl": "",
    "name": "Harry Potter",
    "personId": 0,
    "id": 3,
    "fence": "((0.0,0.0),(0.0,10.0),(10.0,10.0),(0.0,0.0))",
    "budget": 10000
  },
  {
    "ctr": 0,
    "country": "USA",
    "imageId": 2,
    "clickCount": 0,
    "impressions": 7,
    "type": "video",
    "amountLeft": 9993,
    "videourl": "",
    "name": "Swades",
    "personId": 0,
    "id": 2,
    "fence": "((0.0,0.0),(0.0,10.0),(10.0,10.0),(0.0,0.0))",
    "budget": 10000
  },
  {
    "ctr": 0,
    "country": "USA",
    "imageId": 4,
    "clickCount": 0,
    "impressions": 6,
    "type": "video",
    "amountLeft": 9994,
    "videourl": "",
    "name": "Secret Life of Pets",
    "personId": 0,
    "id": 4,
    "fence": "((0.0,0.0),(0.0,10.0),(10.0,10.0),(0.0,0.0))",
    "budget": 10000
  },
  {
    "clickurl": "https://en.wikipedia.org/wiki/Casablanca_(film)",
    "ctr": 0,
    "country": "USA",
    "imageId": 5,
    "clickCount": 0,
    "impressions": 0,
    "type": "video",
    "amountLeft": 10000,
    "videourl": "https://www.youtube.com/watch?v=w7IWLZcVU64",
    "name": "Club Havana",
    "personId": 0,
    "id": 5,
    "fence": "((0.0,0.0),(0.0,10.0),(10.0,10.0),(0.0,0.0))",
    "budget": 10000
  }
]
```


# 4 Increase Click Count
`curl -X POST -H "Content-Type: application/json"  -d '{    "id" : 5    }' "ec2-35-165-161-51.us-west-2.compute.amazonaws.com:8080/v1/ad/clickad"`

#Response
```json
[
  {
    "clickurl": "https://en.wikipedia.org/wiki/Casablanca_(film)",
    "ctr": 0,
    "country": "USA",
    "imageId": 5,
    "clickCount": 1,
    "impressions": 0,
    "type": "video",
    "amountLeft": 9998,
    "videourl": "https://www.youtube.com/watch?v=w7IWLZcVU64",
    "name": "Club Havana",
    "personId": 0,
    "id": 5,
    "fence": "((0.0,0.0),(0.0,10.0),(10.0,10.0),(0.0,0.0))",
    "budget": 10000
  }
]
```



# 5 Increase Impression Count
`curl -X POST -H "Content-Type: application/json"  -d '{    "id" : 5    }' "ec2-35-165-161-51.us-west-2.compute.amazonaws.com:8080/v1/ad/impressionad"`

#Response
```json
[
  {
    "clickurl": "https://en.wikipedia.org/wiki/Casablanca_(film)",
    "ctr": 50,
    "country": "USA",
    "imageId": 5,
    "clickCount": 1,
    "impressions": 1,
    "type": "video",
    "amountLeft": 9997,
    "videourl": "https://www.youtube.com/watch?v=w7IWLZcVU64",
    "name": "Club Havana",
    "personId": 0,
    "id": 5,
    "fence": "((0.0,0.0),(0.0,10.0),(10.0,10.0),(0.0,0.0))",
    "budget": 10000
  }
]
```

# 6 Get single Ad based on location (based on budget,fence,etc parameters)
`curl -X POST -H "Content-Type: application/json" -d '{    "location" : "(2, 8),"type" : "random"}' "ec2-35-165-161-51.us-west-2.compute.amazonaws.com:8080/v1/ad/getad"`
`curl -X POST -H "Content-Type: application/json" -d '{    "location" : "(2, 8),"type" : "nn"}' "ec2-35-165-161-51.us-west-2.compute.amazonaws.com:8080/v1/ad/getad"`
`curl -X POST -H "Content-Type: application/json" -d '{    "location" : "(2, 8),"type" : "skyline"}' "ec2-35-165-161-51.us-west-2.compute.amazonaws.com:8080/v1/ad/getad"`

#Response
```json
[
  {
    "clickurl": "https://en.wikipedia.org/wiki/Casablanca_(film)",
    "ctr": 25,
    "country": "USA",
    "imageId": 5,
    "clickCount": 1,
    "impressions": 3,
    "type": "video",
    "amountLeft": 9995,
    "videourl": "https://www.youtube.com/watch?v=w7IWLZcVU64",
    "name": "Club Havana",
    "personId": 0,
    "id": 5,
    "fence": "((0.0,0.0),(0.0,10.0),(10.0,10.0),(0.0,0.0))",
    "budget": 10000
  }
]
```



# 7 Get Ads for a particular users
`curl -X POST -H "Content-Type: application/json" -d '{ "name" : "Abhishek Patro" }' "ec2-35-165-161-51.us-west-2.compute.amazonaws.com:8080/v1/person/getpersonads"`
#Response
```json
[
  {
    "clickurl": "",
    "ctr": 0,
    "country": "USA",
    "imageId": 4,
    "clickCount": 0,
    "impressions": 9,
    "type": "video",
    "amountLeft": 9991,
    "videourl": "",
    "name": "Secret Life of Pets",
    "personId": 0,
    "id": 4,
    "fence": "((0.0,0.0),(0.0,10.0),(10.0,10.0),(0.0,0.0))",
    "budget": 10000
  },
  {
    "clickurl": "https://en.wikipedia.org/wiki/Casablanca_(film)",
    "ctr": 0,
    "country": "USA",
    "imageId": 4,
    "clickCount": 0,
    "impressions": 5,
    "type": "video",
    "amountLeft": 9995,
    "videourl": "https://www.youtube.com/watch?v=w7IWLZcVU64",
    "name": "Club Havana",
    "personId": 0,
    "id": 8,
    "fence": "((0.0,0.0),(0.0,10.0),(10.0,10.0),(0.0,0.0))",
    "budget": 10000
  },
  {
    "clickurl": "https://en.wikipedia.org/wiki/Casablanca_(film)",
    "ctr": 18.181818181818183,
    "country": "USA",
    "imageId": 1,
    "clickCount": 2,
    "impressions": 9,
    "type": "video",
    "amountLeft": 987,
    "videourl": "https://www.youtube.com/watch?v=w7IWLZcVU64",
    "name": "Club Havana Part duex",
    "personId": 0,
    "id": 5,
    "fence": "((0.0,0.0),(0.0,10.0),(10.0,10.0),(0.0,0.0))",
    "budget": 1000
  },
  {
    "clickurl": "",
    "ctr": 0,
    "country": "USA",
    "imageId": 2,
    "clickCount": 0,
    "impressions": 8,
    "type": "video",
    "amountLeft": 9992,
    "videourl": "",
    "name": "Swades",
    "personId": 0,
    "id": 3,
    "fence": "((0.0,0.0),(0.0,10.0),(10.0,10.0),(0.0,0.0))",
    "budget": 10000
  },
  {
    "clickurl": "https://en.wikipedia.org/wiki/Casablanca_(film)",
    "ctr": 0,
    "country": "USA",
    "imageId": 2,
    "clickCount": 0,
    "impressions": 5,
    "type": "video",
    "amountLeft": 95,
    "videourl": "https://www.youtube.com/watch?v=w7IWLZcVU64",
    "name": "Club Havana Part three",
    "personId": 0,
    "id": 6,
    "fence": "((0.0,0.0),(0.0,10.0),(10.0,10.0),(0.0,0.0))",
    "budget": 100
  }
]
```


# 8 Get all persons
`curl -X GET -H "Content-Type: application/json" "ec2-35-165-161-51.us-west-2.compute.amazonaws.com:8080/v1/person/getpersons"`


#Response
```json
[
  {
    "city": "USA",
    "name": "Karanjeet Singh Sarna",
    "id": 1,
    "age": 21
  },
  {
    "city": "USA",
    "name": "Abhishek Patro",
    "id": 2,
    "age": 25
  },
  {
    "city": "USA",
    "name": "Shiven Saiwal",
    "id": 3,
    "age": 24
  },
  {
    "city": "Bangalore",
    "name": "Sridhar",
    "id": 4,
    "age": 24
  },
  {
    "city": "Bangalore",
    "name": "karthik",
    "id": 5,
    "age": 22
  },
  {
    "city": "USA",
    "name": "Sagar Narang",
    "id": 7,
    "age": 23
  }
]
```


# 9 Get person by name/id

`curl -X POST -H "Content-Type: application/json"  -d '{   "name" : "Abhishek Patro" }' "ec2-35-165-161-51.us-west-2.compute.amazonaws.com:8080/v1/person/getperson"`

`curl -X POST -H "Content-Type: application/json"  -d '{   "id" : 2 }' "ec2-35-165-161-51.us-west-2.compute.amazonaws.com:8080/v1/person/getperson"`
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

# 10 Delete an ad by user
`curl -X POST -H "Content-Type: application/json" -d '{    "personId" : 2,    "adId" : 9}' "ec2-35-165-161-51.us-west-2.compute.amazonaws.com:8080/v1/ad/deletead"`
#Response
```json
[
  {
    "adId": 9,
    "personId": 2,
    "id": 0
  }
]
```
