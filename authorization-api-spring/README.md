# authorization-api-spring
API's of Authorization Engine are essentially a way for programmers to commumnicate with Application.

This directory contains the source code for Authorization Engine API's and aims to fully support RESTful API's

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
Authorization Engine API's
						|-- src ---com/springiot--------
						| 	  	          |
						| 	  	          |--- constant
						| 	  	          |
						| 	  	          |--- controllers
						| 	  	          |
						| 	  	          |--- domain
						| 	  	          |	  
						| 	  	          |--- filter
						| 	  	          |
						| 	  	          |--- genericDao
						| 	  		      |
						| 	  		      |--- genericService
						|			      |		           
						|		          |--- hibernate.transform 
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

1. Constant package includes domain classes.
2. Controllers are responsible for processing user requests and building appropriate model and passes it to the view for rendering.
3. Domain is used for specific domain based classes.
4. Filter Package is used for server side filtering and for authentication.
5. All database access in the system is made through a GenericDao to achieve encapsulation.
6. GenericService is  responsible for handling transactions, sessions, or connections.
7. Hibernate Transform is used to return the same output as teh procedure returns.
8. HTTP/client is used to call the POST Requests.
9. Logging is used for Audit as well as Error Logging. 
10. Scheduling is used to schedule cron JOb.
11. Services contains the buisness logic for the API's.
12. Swagger/Response Package is used for specific response of API's.
13. META-INF defines the maven classes.
14. WEB-INF contains the web.xml and mvc-dispatcher-servlet.xml classes.

Error Handling
- 200 -> Success
- 401 -> Authentication Error
- 404 -> URL not Found
- 500 -> Internal Server Error 

Swagger Integration
- API's are integrated with Swagger for the ease of end users to discover and understand the input and output parameters of the API.The link is:
    http://i.teramatrix.in:7878/ThirdPartyBinatonApplication/swagger-ui.html



