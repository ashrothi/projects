package demo;

public class StringIndex {
	public static void main(String[] args) {
		String string = "ResponseCode:200123654789B";

//		System.out.println(string.substring(0, 2));
//		System.out.println(string.substring(2, string.length()));
		
		System.out.println(string.substring(string.indexOf("ResponseCode:200")+16));

	}
}
