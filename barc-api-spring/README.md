# barc-api-spring

API's of BARC are essentially a way for programmers to commumnicate with Application.

This directory contains the source code for BARC API's and aims to fully support RESTful API's

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
						| 	  	          |--- constant
						| 	  	          |
						| 	  	          |--- controllers
						| 	  	          |	  
						| 	  	          |--- filter
						| 	  	          |
						| 	  	          |--- genericDao
						| 	  		  |
						| 	  		  |--- genericService
						|			  |		           
						|		          |--- response
						|		          | 
						|		          |--- services
						|		          |
						|			  |--- swagger/response
						|		
						|				
						|	
						|-- Web Content ---
						|	         |-- META-INF
						|		 |-- WEB-INF
						|	    
```

Structure Description :

1. Constant package includes domain classes.
2. Controllers are responsible for processing user requests and building appropriate model and passes it to the view for rendering.
3. Filter Package is used for server side filtering and for authentication.
4. All database access in the system is made through a GenericDao to achieve encapsulation.
5. GenericService is  responsible for handling transactions, sessions, or connections.
6. Services contains the buisness logic for the API's.
7. Swagger/Response Package is used for specific response of API's.
8. META-INF defines the maven classes.
9. WEB-INF contains the web.xml and mvc-dispatcher-servlet.xml classes.

Error Handling
- 200 -> Success
- 401 -> Authentication Error
- 404 -> URL not Found
- 500 -> Internal Server Error 

Swagger Integration
- API's are integrated with Swagger for the ease of end users to discover and understand the input and output parameters of the API.The link is:
    http://i.teramatrix.in:7878/BARC/swagger-ui.html



