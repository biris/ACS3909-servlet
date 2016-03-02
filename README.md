Project Report, Part I with servlets API
Intro
=====
This projects consist of a simple,  single  web page app, where we have a in some way gives a controlled access to database. They can select other users collection of students, stored in database on our server, we use student number as the key. The users provide their student number which gives them and the system keeps track of who selected who.
Server side features
=====================
The server consist of the assumption of the availability of SQL database with a one table. The requests get's intercepted by main servlet, depending on the nature of the request it forwards it to other servlets. There is a thin layer between the database and the object model of Java, where it transforms SQL queries results into Java objects (type Student), provided by the class `DatabaseStuff.java`. And provides us also API to presently store Student objects in the database (update). I have also used the servlet API for cookies, and session to track first time app users, and returning users.
Application of MVC
I tried to keep the model simple, by wrapping all the changing state, depending on the request from user, into one object (the bean), the class name is `State`. The state in this app mostly relates to who is requesting, what's his previous selection, who selected him. The state get set by the controller if some preconditions are true (we know who requested the page), otherwise we deal with that and forward it to another page, the controller also handle the requests coming from inside the app, not just the first time, where it plays the role of router. The views, we have essentially two, to handle the first time users, and the normal interface (`getIDView.jsp, selectView.jsp`)
Client-Side Features
===================
On the client, I have used the browser cookie functionality to store user student id, when first entered. Also used the HTML5 Drag and Drop API to allow users to move their selections in the provided list  however they want to.
Conclusion
==========
When using Java servlets I found that it wasn't simple to create single web page apps, since the server builds and sends different pages of html, but I think with meteor it will be simple as I only send the data and let the client update its state according to it.
References 
==========
SQL starting table: 

| id      | name            | selected        |
|---------|-----------------|-----------------|
| 3040500 | J.C.R LickLider | 3040501 3040502 |
| 3040501 | John McCarthy   | 3040500 3040502 |
| 3040502 | Rich Hickey     | 3040501 3040500 |

demo



 

