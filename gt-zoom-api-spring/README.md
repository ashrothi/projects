# gt-zoom-api-spring Apis
API's of gt-zoom-api-spring are essentially a way for programmers to commumnicate with Application.

This directory contains the source code for gt-zoom-api-spring API's and aims to fully support RESTful API's

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
gt-zoom-api-spring  API's
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
		|--					|------FlintAuditLogCountSwagger.java
		|--					|------PasswordresetSwagger.java
		|--					|------RolesGetAllSwagger.java
		|--					|------OauthMobileTokenSwagger.java
		|--					|------FlintDeleteVehicleSwagger.java
		|--					|------UserDeleteSwagger.java
		|--					|------RolesGetAllUserApplicationSwagger.java
		|--					|------FlintAuditLogGetAllLimitSwagger.java
		|--					|------UsersGetAllExceptApplicationSwagger.java
		|--					|------PasswordupdateSwagger.java
		|--					|------FlintAuditLogInsertSwagger.java
		|--					|------ReturnoauthtokenSwagger.java
		|--					|------FlintAuditLogGetAllSwagger.java
		|--					|------OauthTokenSwagger.java
		|--					|------OrganizationGetCitySwagger.java
		|--					|------FlintGetRoleSwagger.java
		|--					|------ThirdpartyIntegrationTokenSwagger.java
		|--					|------UserUpdateLockStatusSwagger.java
		|--					|------FlintGetStateSwagger.java
		|--					|------XfusionAttributesGetByRoleSwagger.java
		|--					|------OrganizationInsertSwagger.java
		|--					|------ApplicationUserAddSwagger.java
		|--					|------FlintGetCitySwagger.java
		|--					|------MappingHandlerSwagger.java
		|--					|------UploadFileSwagger.java
		|--					|------FlintErrorLogCountSwagger.java
		|--					|------OauthTokenExpireSwagger.java
		|--					|------FlintErrorLogGetAllLimitSwagger.java
		|--					|------OrganizationDeleteSwagger.java
		|--					|------UserInactiveSwagger.java
		|--					|------UserCreateSwagger.java
		|--					|------XfusionUserGetAttributeSwagger.java
		|--					|------OrganizationGetByUserSwagger.java
		|--					|------ForgotpasswordSwagger.java
		|--					|------OrganizationGetCountrySwagger.java
		|--					|------FlintGetCountrySwagger.java
		|--					|------FlintHistoryTrackingGetAllSwagger.java
		|--					|------UserUpdateRoleIdSwagger.java
		|--					|------StateGetByCountryIdSwagger.java
		|--					|------FlintLiveTrackingGetAllSwagger.java
		|--					|------FlintLiveTrackingGetAllMobileSwagger.java
		|--					|------OrganizationGetStateSwagger.java
		|--					|------UploadMultipleFileSwagger.java
		|--					|------GetapiurlSwagger.java
		|--					|------OrganizationGetAllSwagger.java
		|--					|------XfusionUserUpdateAttributeSwagger.java
		|--					|------ApplicationUserRemoveSwagger.java
		|--					|------OrganizationUsersListSwagger.java
		|--					|------CountryGetSwagger.java
		|--					|------UserUpdateSwagger.java
		|--					|------OrganizationUpdateSwagger.java
		|--					|------CityGetByStateIdSwagger.java
		|--					|------GetapiurlClassSwagger.java
		|--			logging
		|--				|------AOPLogging.java
		|--			constant
		|--				|------URLParameter.java
		|--				|------CustomerService.java
		|--				|------Constant.java
		|--				|------ProcessParameter.java
		|--			controllers
		|--				|------ThirdPartyController.java
		|--				|------AuditController.java
		|--				|------FileUploadController.java
		|--				|------MappingHandler.java
		|--				|------UserController.java
		|--				|------OAUTHTokenController.java
		|--				|------OrganizationController.java
		|--				|------GenericController.java
		|--				|------DriverController.java
		|--				|------TrackingController.java
		|--				|------VehicleController.java
		|--			hibernate
		|--				transform
		|--					|------AliasToEntityLinkedHashMapResultTransformer.java
		|--			filter
		|--				|------TokenFilter.java
		|--			service
		|--				processing
		|--					|------GeoAddress.java
		|--			notification
		|--				|------NotificationByFcm.java
		|--			services
		|--				|------GenericProcess.java
		|--				|------FileUploadService.java
		|--				|------MappingHandlerService.java
		|--				|------VehicleService.java
		|--				|------OAUTHTokenServices.java
		|--				|------TrackingServices.java
		|--				|------XFusionService.java
		|--				|------ThirdPartyServices.java
		|--				|------DriverServices.java
		|--			genericDao
		|--				|------GenericDao.java
		|--			genericService
		|--				|------GenericService.java
		|--			response
		|--				|------Token.java
		|--				|------GetTokenResponse.java
		|--				|------GenericMessages.java
		|--				|------Message.java
		|--WebContent
		|--	META-INF
		|--		|------MANIFEST.MF
		|--	WEB-INF
		|--		lib
		|--		|------mvc-dispatcher-servlet.xml
		|--		|------local_profiles.xml
		|--		|------web.xml
		|--|------pom.xml
		|--|------.gitignore
				|--	|------index.jsp
						
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
    http://i.teramatrix.in:7878/GtZoomApplication/swagger-ui.html