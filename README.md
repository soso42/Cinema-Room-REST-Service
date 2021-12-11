# Cinema-Room-REST-Service
This is a Jetbrains academy project, where I have created a simple Spring REST service that manages a small movie theatre. It's Handling HTTP requests in controllers, creates services and responds with JSON objects.
# About
JetBrains Academy  
Track: Java Backend Developer  
Project: Cinema Room REST Service
https://hyperskill.org/projects/189?track=12
# Development Environment
Java SE 16.0.2
# Dependencies
Project lombok

# API specification
```GET /seats```  
Get the list of available seats.  

```POST /purchase {"row": 3, "column": 4}```  
Purchase a ticket for the specified seat;  
On success returns a string token of the sold ticket.  

```POST /return {"token": "9b674be1-b42e-4659-b54f-0663e5d4b218"}```  
Return a ticket with provided token.  

```POST /stats?password=super_secret```  
Display statistics on sold tickets.  
