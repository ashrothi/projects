# Customization of Swagger UI Files

We have customized the source code of open source jar file of swagger ui to change the theme as per our requirement.  

##Guidlines to update existing swagger ui

1. The swagger ui jar file is the part of package springfox.springfox-swagger-ui.2.2.2 which can be extract using maven dependencies.
2. After extracting we get the .jar file with the name of springfox-swagger-ui-2.2.2.jar.
3. When we extracty the jar we get the source code packages in following hierarchy.
 
   META-INF/
  
          |---------------------META-INF/resources
                         |-----swagger-ui.html
                         |-----webjars/
                               |-----------springfox-swagger-ui
                                           |----------css/
                                           |----------fonts/
                                           |----------images/
                                           |----------lang/
                                           |----------lib/
                                           |----------o2c.html
                                           |----------springfox.js
                                           |----------swagger-ui.min

4. For UI customization we have updated only following files:-

  * META-INF/resources/swagger-ui.html
  * META-INF/resources/webjars/springfox-swagger-ui

# Updated File Location

After updating the files we have created updated jar file with the same name so that we can replace the original one and use our own specified code.

Here the location of jar file is https://github.com/peeyush-tm/Teramatrix-GIT-Policy/blob/master/java/Swagger-UI/springfox-swagger-ui-2.2.2.jar.

Please use this .jar file in code to implement updated theme as per our requirment.


