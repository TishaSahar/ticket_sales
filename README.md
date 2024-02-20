# ticket_sales
This is a Java microservice that implements the backend for the transport company's website.

# Build
Linux / Windows:
- run <mvn clean install> from source directory

# Launging
Linux:
- run <bash run_local.sh> from source directory

Default service URI: http://localhost:8080

# Test requests body:

- GET
http://localhost:8080/tickets

1) departure body
{
  "page": 0,
  "departurePoint": "City A" 
}

2) destination body
{
  "page": 0,
  "destinationPoint": "City Y" 
}

- POST
1) endpoint http://localhost:8080/tickets/buy

{
    "userId": "1f642050-0e45-489e-963f-98f9cb1b2039",
    "ticketId": "6ba7b813-9dad-11d1-80b4-00c04fd430c4"
}

2) http://localhost:8080/user/register

{
    "name": "Tikhon",
    "password": "ilovejava",
    "email": "andreev.tihon@gmail.com"
}