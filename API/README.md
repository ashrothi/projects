# ThirdPartyGMRApplication Apis
API's of Third Party GMR Application are essentially a way for programmers to commumnicate with Application.

This directory contains the source code for GMR Application API's and aims to fully support REST API's

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
Third Party Flint  API's
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
				|--					|------AuditLogGetAllSwagger.java
				|--					|------PoiUpdateSwagger.java
				|--					|------PasswordResetSwagger.java
				|--					|------ServiceInventoryStatusDeviceGetManyWithoutDataSwagger.java
				|--					|------BinatoneModelGetFileSwagger.java
				|--					|------ThirdPartyIntegrationTokenSwagger.java
				|--					|------OauthTokenSwagger.java
				|--					|------ExecuteProfileCommandSwagger.java
				|--					|------PerformanceserviceDeviceGetSingleLimitWithoutDataSwagger.java
				|--					|------PasswordUpdateSwagger.java
				|--					|------ExecuteCommandSwagger.java
				|--					|------GmrGetReportTripSummarySwagger.java
				|--					|------DeviceGetTagsByModelSwaggerResponse.java
				|--					|------MappingHandlerSwagger.java
				|--					|------GmrGetReportVehicleDetailsSwagger.java
				|--					|------UploadFileSwagger.java
				|--					|------LiveTrackingGetAllSwagger.java
				|--					|------DeviceSearchSwagger.java
				|--					|------OauthTokenExpireSwagger.java
				|--					|------GetPoiListSwagger.java
				|--					|------ReturnOauthTokenSwagger.java
				|--					|------GmrGetReportAlertGraphSwagger.java
				|--					|------PerformanceServicestatusDeviceGetAllSwagger.java
				|--					|------PoiDeleteSwagger.java
				|--					|------AuditLogInsertSwagger.java
				|--					|------UploadFirmwareFileSwagger.java
				|--					|------AuditLogGetAllLimitSwagger.java
				|--					|------UploadMultipleFileSwagger.java
				|--					|------GetapiurlSwagger.java
				|--					|------HistoryTrackingGetAllSwagger.java
				|--					|------AlertStatusReportSwagger.java
				|--					|------GetPoiSwagger.java
				|--					|------ExcelDownloadSwagger.java
				|--					|------PoiInsertSwagger.java
				|--					|------GmrTripDetailsInsertSwagger.java
				|--					|------AlertDeviceTypeGetAllLimitSwagger.java
				|--					|------DeviceGetModelCategoryServiceDatasourceSwagger.java
				|--					|------DeviceModelGetAllSwagger.java
				|--					|------DeviceGetMetadataSwagger.java
				|--					|------ForgotPasswordSwagger.java
				|--					|------GmrGetReportDownloadSwagger.java
				|--					|------BinatoneModelAddFileSwagger.java
				|--					|------RuleEngineDeviceGetByModelSwagger.java
				|--					|------GmrGetReportTripSummaryGraphSwagger.java
				|--					|------AuditLogCountSwagger.java
				|--					|------GmrGetReportAlertsSwagger.java
				|--					|------DeviceGetMetadataStatusByTypeLimitSwagger.java
				|--					|------TripManagementSwagger.java
				|--					|------GetapiurlClassSwagger.java
				|--			constant
				|--				|------URLParameter.java
				|--				|------CustomerService.java
				|--				|------LatLng.java
				|--				|------Constant.java
				|--				|------ProcessParameter.java
				|--			excel
				|--				|------.~lock.TemplateDailyReportSS.xlsx#
				|--				|------Excel.java
				|--			controllers
				|--				|------ThirdPartyController.java
				|--				|------ReportController.java
				|--				|------TripContoller.java
				|--				|------AuditController.java
				|--				|------MappingHandler.java
				|--				|------OAUTHTokenController.java
				|--				|------PoiController.java
				|--				|------GenericController.java
				|--			hibernate
				|--				transform
				|--					|------AliasToEntityLinkedHashMapResultTransformer.java
				|--			filter
				|--				|------TokenFilter.java
				|--			services
				|--				|------GenericProcess.java
				|--				|------MappingHandlerService.java
				|--				|------OAUTHTokenServices.java
				|--				|------TrackingServices.java
				|--				|------DownloadServices.java
				|--				|------ThirdPartyServices.java
				|--				|------GenericServices.java
				|--			genericDao
				|--				|------GenericDao.java
				|--			genericService
				|--				|------GenericService.java
				|--			response
				|--				|------TokenSPResponse.java
				|--				|------Token.java
				|--				|------GetTokenResponse.java
				|--				|------GenericMessages.java
				|--				|------Message.java
				|--	template
				|--		|------swagger.vm
				|--	|------swagger.properties
				|--|------pom.xml
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
    http://i.teramatrix.in:4444/ThirdPartyGMRApplicationApplication/swagger-ui.html