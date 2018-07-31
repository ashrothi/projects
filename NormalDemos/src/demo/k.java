package demo;

import java.io.File;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class k {
public static void main(String[] args) throws Exception {
       File folder = new File("/home/tanvigarg/git/gt-zoom-api-spring");
       listFiles(folder,"|--");
   }

   public static final String JAVA_FILE_REGEX = "^\\w+//.java";
   public static final String JAVA_METHOD_REGEX = "(public|protected|private|static|\\s) +[\\w\\<\\>\\[\\]]+\\s+(\\w+) *\\([^\\)]*\\)";

   public static void listFiles(File folder, String prefix) throws Exception {
       for (final File fileEntry : folder.listFiles()) {
           if (fileEntry.isDirectory()) {
               System.out.println(prefix + fileEntry.getName() + "");
               listFiles(fileEntry, prefix + "\t");
           } else {
               System.out.println(prefix+"|------"+ fileEntry.getName());
               if (fileEntry.getName().matches(JAVA_FILE_REGEX)) {
                   readMethodsFromJavaFile(fileEntry.getAbsolutePath(), prefix + "\t");
               }
           }
       }
   }

   public static void readMethodsFromJavaFile(String fileName, String prefix) throws Exception {
       Scanner scanner = new Scanner(new File(fileName));
       String text = scanner.useDelimiter("\\A").next();
       scanner.close();
       Pattern pattern = Pattern.compile(JAVA_METHOD_REGEX);
       Matcher matcher = pattern.matcher(text);

       while (matcher.find()) {
           System.out.println(prefix+"|------"+matcher.group(0));
       }
   }
}