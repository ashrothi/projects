# daimlerorchestration-interface-spring
API's of Daimler Orchestration Interface API are essentially a way for programmers to commumnicate with Application.

This directory contains the source code for Daimler Orchestration Core Methods and aims to fully support RESTful API's

### Guidelines for API's
- A URL identifies a resource.
- Each method in a Controller class that has a @RequestMapping annotation is served as a url.
- All classes must contain the proper annotations.Controllers must be labeled @Controller, methods/routes to be documented must have the @RequestMapping annotation,and services must have @Service annotation.
- It uses POST,GET,PUT and DELETE Requests.

### Spring Web MVC Framework Example
- Create the controller class
- Provide the entry of controller in the web.xml file
- Define the bean in the xml file
- Load the spring core and mvc jar files
- Start Tomcat server and deploy the project
```
### Structure
Orchestration Interface API  API's
				|--src
				|--	org
				|--		thirdparty
				|--			resources
				|--				|------JsonModification.java
				|--				|------package-info.java
				|--			http
				|--				client
				|--					|------HttpURLCalling.java
				|--					|------package-info.java
				|--			swagger
				|--				response
				|--					|------AuditLogResponseSwagger.java
				|--					|------ApiResponseSwagger.java
				|--					|------package-info.java
				|--			constant
				|--				|------ProcessParameter.java
				|--			request
				|--				model
				|--					|------IMSI.java
				|--					|------package-info.java
				|--					|------Message.java
				|--					|------SwapDeviceProfile.java
				|--			controllers
				|--				|------NotificationController.java
				|--				|------OrchestrationAPI.java
				|--				|------AuthController.java
				|--				|------AuditLogController.java
				|--			hibernate
				|--				transform
				|--					|------AliasToEntityLinkedHashMapResultTransformer.java
				|--			filter
				|--				|------package-info.java
				|--				|------TokenFilter.java
				|--			services
				|--				|------GenericProcess.java
				|--				|------AuthService.java
				|--				|------AuditServices.java
				|--				|------ThirdPartyService.java
				|--			genericDao
				|--				|------GenericDao.java
				|--			genericService
				|--				|------GenericService.java
				|--	|------swagger.properties
				|--WebContent
				|--	META-INF
				|--		|------MANIFEST.MF
				|--	WEB-INF
				|--		lib
				|--			|------springfox-swagger-ui-2.2.2.jar
				|--			|------olcore.jar
				|--		|------log4j.properties
				|--		|------mvc-dispatcher-servlet.xml
				|--		|------local_profiles.xml
				|--		|------web.xml
				|--	|------index.jsp
				|--|------pom.xml
						
```

### Structure Description :


```
1.Constant package includes domain classes.
2.Controllers are responsible for processing user requests and building appropriate model and passes it to the view for rendering.
3.Filter Package is used for server side filtering and for authentication.
4.All database access in the system is made through a olcore.jar's GenericDao to achieve encapsulation.
5.GenericService of olcore.jar is  responsible for handling transactions, sessions, or connections.
6.HTTP/client is used to call the API Requests.
6.Services contains the buisness logic for the API's.
7.Swagger/Response Package is used for specific response of API's.
8.META-INF defines the maven classes.
9.WEB-INF contains the web.xml and mvc-dispatcher-servlet.xml classes.
10.Hibernate package is used to transform the result from DB
11.olcore.jar  contain all the method to execute the functionality of OL Core.

```
### Error Handling
- 200 -> Success
- 401 -> Authentication Error
- 404 -> URL not Found
- 500 -> Internal Server Error 

### Swagger Integration
- API's are integrated with Swagger for the ease of end users to discover and understand the input and output parameters of the  API.The link is:
    http://host_url:7878/DaimlerApplication/swagger-ui.html
