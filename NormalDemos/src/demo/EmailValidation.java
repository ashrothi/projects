package demo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidation {

	public static void main(String[] args) {

		System.out.println("Helllloooooooooooooo");

		//String hex = "+231 9876543456";
		String hex = "94130 45633";
		Pattern pattern = Pattern.compile("([+][0-9]{1,}[\\s])?[0-9]{1,}");
		Matcher matcher = pattern.matcher(hex);
		System.out.println(matcher.matches());

	}
}
