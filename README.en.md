# Java RESTful API - myContacts

This README file is also available in [Português](README.md).

### What is this project?

This project is supposed to be a little study on RESTful Web Services with Java. It's quite simple as it is no more than an practical exercise. So, basically there is:

- A Contact class which creates an object with id, name, phone and email;
- A ContactHelper class containing a array of Contact objects plus some methods so I can manipulate it;
- A ContactResource class containing the GET, POST, PUT and DELETE methods.

### What did I used on this project?

Basically I used:
- Maven
- JDK 8
- Tomcat v8.5.

### About the project

I was covering from OOP concepts to some REST basics so thats why I'm not messing with database yet so the array is basically doing its job. One might note that there is two GET methods one of which receives an *id* so it can look for an specific contact (DELETE does it as well for its own purposes). I used Jersey (1.19.4) to implement REST and used Weld (2.2.16) with RESTEasy (3.1.4) to dependency injections. I saw a little bit of unit testing and exception handling but I haven't gone too far cause I'm making another project with a real database and didn't wanted to spoil the surprise. Anyway, I used JUnit (4.13.1) and Mockito (1.10.19).

Yea, I think that sums it all.

Éde