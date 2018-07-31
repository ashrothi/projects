# NotificationCenterApplication Apis
API's of NotificationCenterApplication are essentially a way for programmers to commumnicate with Application.

This directory contains the source code for NotificationCenterApplication API's and aims to fully support RESTful API's

### Guidelines for API's
- A URL identifies a resource.
- Each method in a Controller class that has a @RequestMapping annotation is served as a url.
- All classes must contain the proper annotations.
	Controllers must be labeled @Controller, 
	methods/routes to be documented must have the @RequestMapping annotation,and
	Services must have @Service annotation.
- Only uses POST Requests.

### Spring Web MVC Framework Example
- Create the controller class
- Provide the entry of controller in the web.xml file
- Define the bean in the xml file
- Load the spring core and mvc jar files
- Start Tomcat server and deploy the project
```
### Structure
NotificationCenterApplication  API's
		|--src
		|--	|------ApiConfiguration.properties
		|--	org
		|--		gmonstar
		|--			notification
		|--				swagger
		|--					response
		|--						|------NotificationResponseSwagger.java
		|--						|------AuditLogResponseSwagger.java
		|--				logging
		|--					|------package-info.java
		|--					|------AOPLogging.java
		|--				entity
		|--					model
		|--						|------package-info.java
		|--				constant
		|--					|------package-info.java
		|--					|------ProcessParameter.java
		|--				controllers
		|--					|------NotificationController.java
		|--					|------AuditController.java
		|--					|------package-info.java
		|--				hibernate
		|--					transform
		|--						|------AliasToEntityLinkedHashMapResultTransformer.java
		|--						|------package-info.java
		|--				filter
		|--					|------package-info.java
		|--					|------TokenFilter.java
		|--				services
		|--					|------GenericProcess.java
		|--					|------package-info.java
		|--					|------NotificationService.java
		|--				genericDao
		|--					|------GenericDao.java
		|--					|------package-info.java
		|--				genericService
		|--					|------GenericService.java
		|--					|------package-info.java
		|--				response
		|--					model
		|--						|------package-info.java
		|--						|------GenericMessages.java
		|--						|------Message.java
		|--	|------swagger.properties
		|--WebContent::::::::::
		|--	META-INF::::::::::
		|--		|------MANIFEST.MF
		|--	WEB-INF::::::::::
		|--		lib::::::::::
		|--		|------mvc-dispatcher-servlet.xml
		|--		|------local_profiles.xml
		|--		|------web.xml
		|--	|------index.jsp
		|--|------pom.xml
		|--|------.project
		|--|------.classpath
						
```

### Structure Description :


```
1.Constant package includes domain classes.
2.Controllers are responsible for processing user requests and building appropriate model and passes it to the view for rendering.
3.Filter Package is used for server side filtering and for authentication.
4.All database access in the system is made through a GenericDao to achieve encapsulation.
5.GenericService is  responsible for handling transactions, sessions, or connections.
6.HTTP/client is used to call the POST Requests.
7.Logging is used for Audit as well as Error Logging. 
8.Services contains the buisness logic for the API's.
9.META-INF defines the maven classes.
10.WEB-INF contains the web.xml and mvc-dispatcher-servlet.xml classes.
11.Hibernate package is used to transform the result from DB.
12.Response Model is to define the format of response.

```
### Error Handling
- 200 -> Success
- 401 -> Authentication Error
- 404 -> URL not Found
- 500 -> Internal Server Error 

### Swagger Integration
- API's are integrated with Swagger for the ease of end users to discover and understand the input and output parameters of the     API.The link is:
    http://hosturl:port/NotificationCenterApplication/swagger-ui.html
