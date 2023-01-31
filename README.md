# M320
Joel Sow Mischa Strauss 

## Introduction
Welcome to the program where we create a GUI client using Java Swing and a backend built with abstract classes. 
Our backend, consisting of "AbstractEntity", "AbstractEntityService", "AbstractEntityController", and "AbstractEntityRepository", 
is integrated within the same project and communicates with a JSON server as the database. 
The program does not use Spring Boot and offers a unique approach to creating a "robust" and "efficient" backend.
_(!!Disclaimer: This is not a real-world application and is only used for educational purposes. Because of this, the backend is not using Spring...!!)_
Get ready to dive into the world of Java and develop a powerful and dynamic application.

I had alot of fun creating this program and I hope you enjoy it as well, though I do not recommend using this as a reference for your own projects.
As I had to go through alot of pain making everything generic, especially when mapping objects from json, to json etc.
(the hibernate layer is missing)

## Content
- CRUD operations for two entities (User and Osu)
- Java Swing GUI
- Abstract classes for backend for easy implementing of new entities
- JSON server as database
- Generic methods for mapping objects to json and vice versa

### Architecture




---
#### sequence diagram of creating a new osu object and saving it in the DB
```mermaid
sequenceDiagram
actor User
User ->> OsuActionsPage : create
activate OsuActionsPage
OsuActionsPage ->> OsuActionsPage : promptForInput
activate OsuActionsPage
OsuActionsPage -->> OsuActionsPage : #32; 
deactivate OsuActionsPage
OsuActionsPage ->> JsonService : fromJson
activate JsonService
JsonService -->> OsuActionsPage : #32; 
deactivate JsonService
OsuActionsPage ->> AbstractEntityController : create
activate AbstractEntityController
AbstractEntityController ->> AbstractEntityService : create
activate AbstractEntityService
AbstractEntityService ->> AbstractEntityService : createUUID
activate AbstractEntityService
AbstractEntityService -->> AbstractEntityService : #32; 
deactivate AbstractEntityService
AbstractEntityService ->> AbstractEntityRepository : save
activate AbstractEntityRepository
AbstractEntityRepository ->> JsonService : toJson
activate JsonService
JsonService -->> AbstractEntityRepository : #32; 
deactivate JsonService
AbstractEntityRepository ->> API : post
activate API
API -->> AbstractEntityRepository : #32; 
deactivate API
AbstractEntityRepository -->> AbstractEntityService : #32; 
deactivate AbstractEntityRepository
AbstractEntityService ->> JsonService : fromJson
activate JsonService
JsonService -->> AbstractEntityService : #32; 
deactivate JsonService
AbstractEntityService ->> OsuLog : log
activate OsuLog
OsuLog -->> AbstractEntityService : #32; 
deactivate OsuLog
AbstractEntityService -->> AbstractEntityController : #32; 
deactivate AbstractEntityService
AbstractEntityController -->> OsuActionsPage : #32; 
deactivate AbstractEntityController
deactivate OsuActionsPage

```
---


## Setup
start db:
`json-server --watch m320.db.json`
initialize the db:
```json
{
  "osu": [],
  "user": []
}
```

