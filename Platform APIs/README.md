# xFusion Apis
API's of xFusion Platform are essentially a way for programmers to commumnicate with Application.

This directory contains the source code for xFusion Platform API's and aims to fully support RESTful API's

Guidelines for API's
- A URL identifies a resource.
- Each method in a Controller class that has a @RequestMapping annotation is served as a url.
- All classes must contain the proper annotations.Controllers must be labeled @Controller, methods/routes to be documented must have the @RequestMapping annotation,and services must have @Service annotation.
- Only uses POST Requests.

Spring Web MVC Framework Example
- Create the controller class
- Provide the entry of controller in the web.xml file
- Define the bean in the xml file
- Load the spring core and mvc jar files
- Start Tomcat server and deploy the project

Structure

```
xFusion Platform API's
						|-- src ---com/springiot--------
						| 	  	          |--- command
						| 	  	          |
						| 	  	          |--- constant
						| 	  	          |
						| 	  	          |--- controllers
						| 	  	          |
						| 	  	          |--- excel
						| 	  	          |	  
						| 	  	          |--- filter
						| 	  	          |
						| 	  	          |--- genericDao
						| 	  		      |
						| 	  		      |--- genericService
						|			      |		           
						|		          |--- hsql 
						|			      | 
						|			      |--- http/client
						|			      | 
						|			      |--- logging
						|			      | 
						|			      |--- response
						|		          | 
						|			      |--- scheduling
						|			      |	 	
						|		          |--- services
						|		          |
						|			      |--- swagger/response
						|		
						|				
						|	
						|-- Web Content ---
						|	         |-- META-INF
						|		     |-- WEB-INF
						|	    
```

Structure Description :

1. Command Package is used to exceute/push command on the device. 
2. Constant package includes domain classes.
3. Controllers are responsible for processing user requests and building appropriate model and passes it to the view for rendering.
4. Excel Pacakge is used while downloading them and set templates for the same.
5. Filter Package is used for server side filtering and for authentication.
6. All database access in the system is made through a GenericDao to achieve encapsulation.
7. GenericService is  responsible for handling transactions, sessions, or connections.
8. Hsql Package is used to connect with HSQL database for Rule Engine.
9. HTTP/client is used to call the POST Requests.
10. Logging is used for Audit as well as Error Logging. 
11. Scheduling is used to schedule cron JOb.
12. Services contains the buisness logic for the API's.
13. Swagger/Response Package is used for specific response of API's.
14. META-INF defines the maven classes.
15. WEB-INF contains the web.xml and mvc-dispatcher-servlet.xml classes.

Error Handling
- 200 -> Success
- 401 -> Authentication Error
- 404 -> URL not Found
- 500 -> Internal Server Error 

Swagger Integration
- API's are integrated with Swagger for the ease of end users to discover and understand the input and output parameters of the API.The link is:
    http://i.teramatrix.in:7878/XFusionPlatform/swagger-ui.html



