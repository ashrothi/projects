
# Android

Before start working with android, please read this document.  

## How to attempt assignments?

1. [**Android Studio**](https://developer.android.com/studio/index.html?gclid=CLKfpPzxhNICFZMXaAodtFoNfQ) will be used for the development.
2. In the [**Assignments.pdf**](https://github.com/peeyush-tm/Teramatrix-GIT-Policy/blob/master/android/Assignments.pdf) file, you will find a list of assignments that will be attempted one by one in the sequence.
3. Each assignment must be submitted on the day you've start working on.
4. Code must be commented with [**JavaDoc Documentation Comments**](https://www.tutorialspoint.com/java/java_documentation.htm) according to the standards.
5. Assignment code must be according to the Code Conventions described below in the next paragraph.
6. Every submission of assignment must have an APK file, flow diagram and code documentation.

## Code Conventions

* Android application name should be same as the Github repository name.
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
  
* Hungarian notation will be used to name instance of `View` class only otherwise don't use it anywhere.

  :o: **Allowed:** Because TextView, Button & ImageView is instance of View class

  ```java
  TextView txtEmail = (TextView) findViewById(R.id.txt_email);
  Button btnSubmit = (Button) findViewById(R.id.btn_submit);
  ImageView imgProfilePic = new ImageView(this);
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
        // Do magic here
  }
  ```

* Do not use single character variable names like i, j, n, s etc. But this is allowed in iteration.

* Do not use underscores (_) for variable, method or class names. It can only be used in constant's name.

* Prefix boolean variables, properties and methods with “is” or similar prefixes.

  ```java
  private boolean isConnectedToInternet;
  public boolean isWritable = false;
  ```

* Use appropriate prefix for the UI elements so that you can identify them from the rest of the variables. There are 2 different approaches recommended here...

  a. This will help you group all of the UI elements together and easy to access all of them from the intellisense (Help that appear in the IDE when we type).
  
  b. Use appropriate prefix for each of the ui element. A brief list is given below...
  
  | View / Component 	| Prefix 	| In Java File  	| In XML File          	|
  |------------------	|--------	|---------------	|----------------------	|
  | TextView         	| txt    	| txtPassword   	| @+id/txt_password    	|
  | Button           	| btn    	| btnSubmit     	| @+id/btn_submit      	|
  | CheckBox         	| chk    	| chkRememberMe 	| @+id/chk_remember_me 	|
  | RadioButton      	| radio  	| radioMale     	| @+id/radio_male      	|
  | Spinner          	| spn    	| spnCountry    	| @+id/spn_country     	|
  | ImageView        	| img    	| imgProfilePic 	| @+id/img_profile_pic 	|
  | ImageButton      	| imgBtn 	| imgBtnUpload  	| @+id/img_btn_upload  	|
  | CardView         	| card   	| cardLoginForm 	| @+id/card_login_form 	|
  | GridView         	| grid   	| gridGallery   	| @+id/grid_gallery    	|
  | ListView         	| list   	| listDevices   	| @+id/list_devices    	|
  | RecyclerView     	| rv     	| rvTickets     	| @+id/rv_tickets      	|
  | LinearLayout     	| layout 	| layoutFooter  	| @+id/layout_footer   	|
  | RelativeLayout   	| layout 	| layoutBody    	| @+id/layout_body     	|
  
* File name should match with class name. For example, for the class HelloWorld, the file name should be HelloWorld.java.

* If you are using _Log_ class to print on console/android monitor, then use only class name as a tag of log. This practice will be useful to track the origin of log and logs can be removed after use.

  ```java
  public class MainActivity extends AppCompatActivity {
      @Override    
      protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          setContentView(R.layout.activity_main);
        
          // Put class name in tag of log
          Log.e("MainActivity", "Main activity created");
        
          // Or you can use like this
          Log.e(getClass().getSimpleName(), "Main activity created");
      }
  }
  ```

* While making an android activity or a fragment... 
  
  a. Put Activity or Fragment as suffix to java class name as following:
     
      LoginActivity.class     
      MainActivity.class     
      HomeFragment.class     
      DashboardFragment.class     
      DetailsFragment.class
      
  b. Put activity or fragment as prefix to xml file name as following:
     
      activity_login.xml     
      activity_main.xml     
      fragment_home.xml
      fragment_dashboard.xml     
      fragment_details.xml
      
* Use lower case letters to name android resources and use underscore ( _ ) instead of white space or any other symbol.

  ```
  res/drawable/png_background.png      
  res/drawable/shape_rectangle.xml      
  res/mipmap/ic_launcher.png
      
  res/layout/activity_main.xml      
  res/layout/activity_login.xml      
  res/layout/fragment_home.xml      
  res/layout/fragment_details.xml
      
  res/menu/menu_search.xml      
  res/menu/menu_navigation.xml
      
  res/values/colors/color_primary      
  res/values/colors/color_primary_dark      
  res/values/colors/color_accent
      
  res/values/strings/app_name      
  res/values/strings/internet_error      
  res/values/strings/empty_list_message
  ```
  
## Indentation and Spacing

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

## Good Programming practices

* Project directory / Working directory / Workspace should be in Logical partition rather than Primary partition.

  For example if you're in windows environment, never use C Drive for workspace.
  
* Add/Update documentation comment while coding.

* `targetSdkVersion` must be the latest version of android SDK in `build.gradle` file.

* `minSdkVersion` should not be more than 15.
