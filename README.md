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
- Generic methods for mapping objects to json and vice versa\
- Logging to external file

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
get json-server:
`npm install -g json-server`
start db:
`json-server --watch m320.db.json`
initialize the db:
```json
{
  "osu": [],
  "user": []
}
```

# Conclusion
- was it worth it?
  - yes:
    I learned alot about abstract classes and how to use them in a real-world application.
    I also learned alot about the java swing library and how to use it to create a GUI. 
    It took me most of the time to implement the first Entity, and the user entity took me 10 minutes to implement, because its all generic.
  - no:
    I had to go through alot of pain to make everything generic, especially when mapping objects from json, to json etc.
    (the hibernate layer is missing)
- would I do it again?
  - No. Although it was fun, I would not do it again. Though I would use the same approach (generic programming) for a real-world application.
- would I recommend it?
  - No. I would not recommend it. It was fun, but it was not worth it. I would recommend using Spring Boot instead.

----

example objects:

```json
{
  "osu": [
    {
      "title": "From Ruin... We Rise",
      "artist": "Shadow of Intent",
      "gamemode": 0,
      "mapper": "[N1co]",
      "difficulty_ar": 9.8,
      "difficulty_hp": 4,
      "source": "",
      "bpm": 180,
      "play_length": 38,
      "difficulty_od": 9.5,
      "beatmapset": 1111686,
      "favorites": 0,
      "date": "2023-01-23T21:03:23",
      "genre": "Unspecified",
      "difficulty": 6.19553,
      "difficulty_cs": 4.2,
      "difficulty_name": "Elegy",
      "pass_count": 0,
      "beatmap_id": 3981791,
      "beatmapset_id": 1928101,
      "language": "Other",
      "total_length": 55,
      "beatmap_status": -1,
      "map_count": 1,
      "play_count": 0,
      "id": "53e564b4-2e9e-4c87-8261-65aac02c2c7d"
    }
  ],
  "user": [
    {
      "username": "Mischa",
      "country": "CH",
      "country_code": "CH",
      "join_date": "12.09.21",
      "playstyle": "osu",
      "id": "2c4d0109-d8bb-4f87-bc89-af4150d7c928"
    }
  ]
}```