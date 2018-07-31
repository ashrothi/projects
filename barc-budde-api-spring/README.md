# barc-budde-api-spring
API's of Barc Budde  Application are essentially a way for programmers to commumnicate with Application.

This directory contains the source code for Barc Budde  Application API's and aims to fully support RESTful API's

### Guidelines for API's
- A URL identifies a resource.
- Each method in a Controller class that has a @RequestMapping annotation is served as a url.
- All classes must contain the proper annotations.Controllers must be labeled @Controller, methods/routes to be documented must have the @RequestMapping annotation,and services must have @Service annotation.
- Only uses POST Requests.

### Spring Web MVC Framework Example
- Create the controller class
- Provide the entry of controller in the web.xml file
- Define the bean in the xml file
- Load the spring core and mvc jar files
- Start Tomcat server and deploy the project
```
### Structure
Barc Budde  Application  API's
				|--src
				|--	com
				|--		springiot
				|--			domain
				|--				|------SwaggerClassGenerator.java
				|--				|------TemplateSwagger.java
				|--			http
				|--				client
				|--					|------HttpURLCalling.java
				|--			swagger
				|--				response
				|--					|------UsersGetAllSwagger.java
				|--					|------PasswordResetSwagger.java
				|--					|------UserDeleteSwagger.java
				|--					|------OauthTokenSwagger.java
				|--					|------OrganizationGetCitySwagger.java
				|--					|------OrganizationInsertSwagger.java
				|--					|------PasswordUpdateSwagger.java
				|--					|------UploadFileSwagger.java
				|--					|------OauthTokenExpireSwagger.java
				|--					|------OrganizationDeleteSwagger.java
				|--					|------UserCreateSwagger.java
				|--					|------OrganizationGetByUserSwagger.java
				|--					|------OrganizationGetCountrySwagger.java
				|--					|------UploadFirmwareFileSwagger.java
				|--					|------StateGetByCountryIdSwagger.java
				|--					|------OrganizationGetStateSwagger.java
				|--					|------UploadMultipleFileSwagger.java
				|--					|------GetapiurlSwagger.java
				|--					|------OrganizationGetAllSwagger.java
				|--					|------OrganizationUsersListSwagger.java
				|--					|------CountryGetSwagger.java
				|--					|------ForgotPasswordSwagger.java
				|--					|------UserUpdateSwagger.java
				|--					|------OrganizationUpdateSwagger.java
				|--					|------CityGetByStateIdSwagger.java
				|--			logging
				|--				|------AOPLogging.java
				|--			constant
				|--				|------URLParameter.java
				|--				|------TableParameter.java
				|--				|------CustomerService.java
				|--				|------Constant.java
				|--				|------ProcessParameter.java
				|--			excel
				|--				|------Excel.java
				|--			controllers
				|--				|------ThirdPartyController.java
				|--				|------AuditController.java
				|--				|------FileUploadController.java
				|--				|------MappingHandler.java
				|--				|------UserController.java
				|--				|------OAUTHTokenController.java
				|--				|------OrganizationController.java
				|--				|------GenericController.java
				|--				|------FileController.java
				|--				|------FTPController.java
				|--			hibernate
				|--				transform
				|--					|------AliasToEntityLinkedHashMapResultTransformer.java
				|--			filter
				|--				|------ServerSideFiltering.java
				|--				|------TokenFilter.java
				|--			services
				|--				|------UserService.java
				|--				|------GenericProcess.java
				|--				|------FileUploadService.java
				|--				|------MappingHandlerService.java
				|--				|------FTPService.java
				|--				|------OAUTHTokenServices.java
				|--				|------DownloadServices.java
				|--				|------FileService.java
				|--				|------ThirdPartyService.java
				|--				|------OrganizationService.java
				|--			genericDao
				|--				|------GenericDao.java
				|--			genericService
				|--				|------GenericService.java
				|--			response
				|--				|------Token.java
				|--				|------GetTokenResponse.java
				|--				|------GenericMessages.java
				|--				|------Message.java
				|--	template
				|--		|------swagger.vm
				|--	|------swagger.properties
				|--WebContent::::::::::
				|--	META-INF::::::::::
				|--		|------MANIFEST.MF
				|--	WEB-INF::::::::::
				|--		|------UserCreate.properties
				|--		lib::::::::::
				|--		|------mvc-dispatcher-servlet.xml
				|--		|------local_profiles.xml
				|--		|------web.xml
				|--	|------index.jsp
				|------pom.xml		
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
8.Scheduling is used to schedule cron JOb.
9.Services contains the buisness logic for the API's.
10.Swagger/Response Package is used for specific response of API's.
11.META-INF defines the maven classes.
12.WEB-INF contains the web.xml and mvc-dispatcher-servlet.xml classes.
13.Notification package is used to push notification using Fcm.
14.Hibernate package is used to transform the result from DB
15.template package contain .vm file for creatin response class and swagger properties

```
### Error Handling
- 200 -> Success
- 401 -> Authentication Error
- 404 -> URL not Found
- 500 -> Internal Server Error 

### Swagger Integration
- API's are integrated with Swagger for the ease of end users to discover and understand the input and output parameters of the     API.The link is:    
http://192.168.1.242:4444/BarcBuddeClientApplication/swagger-ui.html
