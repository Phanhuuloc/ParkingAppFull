### Web service api

###### ID:  R-A-PIR-01, R-A-PIR-02
- Request:
```
/api/lot/{lot_uid}
``` 
- Response:
```JSON
{
  "name": "string",       //Lot name
  "uid": "string",        //lot uid
  "areas": [
    {
      "name": "string",   //Area name
      "status": 0,        //Area status (0 or 1)
      "lt": {             //left-top point
        "lat": 0,         //longtitude
        "lon": 0          //latitude
      },
      "rt": {             //right-top point
        "lat": 0,
        "lon": 0
      },
      "lb": {             //left-bottom point
        "lat": 0,
        "lon": 0
      },
      "rb": {             //right-bottom point
        "lat": 0,
        "lon": 0
      }
    }
  ]
}
```
- Example

** REQ
``
http://localhost:8888/api/lot/330103a6-f350-45fe-ad90-ce500d74e354
``

** RES
```JSON
{
  "uid": "330103a6-f350-45fe-ad90-ce500d74e354",
  "name": "Lot L1",
  "areas": [
    {
      "name": "A2",
      "status": 0,
      "lt": {
        "lat": 4,
        "lon": 4
      },
      "rt": {
        "lat": 4,
        "lon": 9
      },
      "lb": {
        "lat": 9,
        "lon": 4
      },
      "rb": {
        "lat": 9,
        "lon": 9
      }
    },
    {
      "name": "A5",
      "status": 0,
      "lt": {
        "lat": 4,
        "lon": 4
      },
      "rt": {
        "lat": 4,
        "lon": 9
      },
      "lb": {
        "lat": 9,
        "lon": 4
      },
      "rb": {
        "lat": 9,
        "lon": 9
      }
    },
    {
      "name": "A6",
      "status": 0,
      "lt": {
        "lat": 4,
        "lon": 4
      },
      "rt": {
        "lat": 4,
        "lon": 9
      },
      "lb": {
        "lat": 9,
        "lon": 4
      },
      "rb": {
        "lat": 9,
        "lon": 9
      }
    },
    {
      "name": "A4",
      "status": 0,
      "lt": {
        "lat": 4,
        "lon": 4
      },
      "rt": {
        "lat": 4,
        "lon": 9
      },
      "lb": {
        "lat": 9,
        "lon": 4
      },
      "rb": {
        "lat": 9,
        "lon": 9
      }
    },
    {
      "name": "A1",
      "status": 0,
      "lt": {
        "lat": 4,
        "lon": 4
      },
      "rt": {
        "lat": 4,
        "lon": 9
      },
      "lb": {
        "lat": 9,
        "lon": 4
      },
      "rb": {
        "lat": 9,
        "lon": 9
      }
    },
    {
      "name": "A3",
      "status": 0,
      "lt": {
        "lat": 4,
        "lon": 4
      },
      "rt": {
        "lat": 4,
        "lon": 9
      },
      "lb": {
        "lat": 9,
        "lon": 4
      },
      "rb": {
        "lat": 9,
        "lon": 9
      }
    }
  ]
}
```

###### ID:  R-A-PIR-03
- Request:
```
/api/car/info/{car_uid}
``` 
- Response:
```JSON
{
  "gps": {          //car gps position
    "lat": 0,       //latitide
    "lon": 0        //longtitude
  },
  "id": "string",   //car id 
  "status": 0       //status 0 or 1
}
```
- Example

** REQ
``
http://localhost:8888/api/car/info/48a8e388-a4cf-41d0-a4ac-1fccdef907f3
``

** RES
```JSON
{
  "id": "50B1-99999",     
  "status": 0,            
  "gps": {
    "lat": 345,
    "lon": 123
  }
}
```
