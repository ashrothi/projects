# JAVA

Before start working with Java, please read this document.  

##How to attempt assignments?

1. [**Eclipse**](https://www.eclipse.org/downloads/) will be used for the development.
2. In the [**Assignments.pdf**](https://github.com/peeyush-tm/Teramatrix-GIT-Policy/blob/master/java/Assignments.pdf) file, you will find a list of assignments that will be attempted one by one in the sequence.
3. Each assignment must be submitted on the day you've start working on.
4. Code must be commented with [**JavaDoc Documentation Comments**](https://www.tutorialspoint.com/java/java_documentation.htm) according to the standards.
5. Assignment code must be according to the Code Conventions described below in the next paragraph.
6. Every submission of assignment must have source code, jar file, flow diagram and code documentation.

##Code Conventions

* Java project name should be same as the Github repository name.
* Java package name must be according to domain of [Teramatrix](http://www.teramatrix.in/).

  For example if your project name is _assignments_ then package name will be _in.teramatrix.assignments_.
  
* Class, interface, enum and annotation name must be in TitleCase.

* Method and variable name must be in camelCase.

* Constant variable name will be in UPPER_CASE.

  ```java
  public static final int VISIBLE = 0x00000000;
  public static final int UPDATE_INTERVAL = 120;
  ```

* Use Meaningful, descriptive words to name variables. Do not use abbreviations.
  
  :o: **Allowed**
  
  ```java  
  String address
  int salary
  ```
  
  :x: **Not Allowed**
  
  ```java  
  String addr
  int sal 
  
  ```
  
* Method name should tell what it does. Do not use mis-leading names.

* Declare private member variables before public members in the java file.
  
* Don't use Hungarian notation anywhere.

  :o: **Allowed:** Because TextView, Button & ImageView is instance of View class

  ```java
  String address;
  int salary; 
  ```
  
  :x: **Not Allowed:** Besides View class instance, Dont use Hungarian Notations anywhere
  
  ```java  
  String strAddress;
  String sAddress;
  int iSalary; 
  int intSalary;
  Object objValue;
  ```
  
* Use the prefix “I” with TitleCasing for interfaces.

  ```java
  public interface IResponseListener {
        
  }
  ```

* Do not use single character variable names like i, j, n, s etc. But this is allowed in iteration.

* Do not use underscores (_) for variable, method or class names. It can only be used in constant's name.

* Prefix boolean variables, properties and methods with “is” or similar prefixes.

  ```java
  private boolean isPermissionGranted;
  public boolean isWritable = false;
  ```     
  
##Indentation and Spacing

* Use TAB for indentation. Do not use SPACES.

* Comments should be in the same level as the code (use the same level of indentation).

  :o: **Allowed**
  
  ```java
  // Checking whether user exists or not. If user exists then MainActivity.class
  // will be loaded otherwise LoginActivity.class.
  String userId = new SPUtils(this).getUserID();
  Class<?> c = userId.trim().equals("")? LoginActivity.class : MainActivity.class;
  startActivity(new Intent(SplashActivity.this, c));
  ```
  
  :x: **Not Allowed**
  
  ```java
  // Checking whether user exists or not. If user exists then MainActivity.class
  // will be loaded otherwise LoginActivity.class.
        String userId = new SPUtils(this).getUserID();
        Class<?> c = userId.trim().equals("")? LoginActivity.class : MainActivity.class;
        startActivity(new Intent(SplashActivity.this, c));
  ```
  
* Use one blank line to separate logical groups of code.

  ```java
  // Initializing basic elements
  SPUtils spUtils = new SPUtils(this);
  int interval = spUtils.getInterval();
  
  // Confirming that no other instance is active of handler
  if (locationHandler != null) {
    locationHandler.stop();                        
  }
  
  // now initiating fused location provider and notification builder
  AppCompatActivity activity = ((FlintDriver) getApplication()).getActivity();
  locationHandler = new LocationHandler(activity != null ? activity : this);                
  builder = new NotificationCompat.Builder(this).setContentTitle("Location Service");
  ```
  
* There should be one and only one single blank line between each method inside the class.

##Good Programming practices

* Project directory / Working directory / Workspace should be in Logical partition rather than Primary partition.

* Add/Update documentation comment while coding.

* Use latest JDK version in project.
