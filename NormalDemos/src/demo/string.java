package demo;

public class string {
public static void main(String[] args) {
//	StringBuilder s=new StringBuilder();
//	s.append("a-#-1-#-2-#-2-#-8-#-9-#-9-#-");
//	s.delete(s.lastIndexOf("-#-"), s.lastIndexOf("-#-")+3);
//	System.out.println(s.toString());
//	String string="responseCode:200{\"errorCode\":102,\"errorMessage\":";
//	System.out.println("responseCode:200".length());
//	System.out.println(string.substring(16));
	
	String masterQuesArray= "553#$#557 ";
	 String masterAnsArray="2487,2488,2491,2492#$#3188,318";
	 
	 String[] masterQuesArray1 = masterQuesArray.toString().split("\\#\\$\\#");
		String[] masterAnsArray1 = masterAnsArray.toString().split("\\#\\$\\#");
		
		
		for (int i = 0; i < masterAnsArray1.length; i++) {
			System.out.println(masterQuesArray1[i]);
			System.out.println(masterAnsArray1[i]);
		}
}
}
