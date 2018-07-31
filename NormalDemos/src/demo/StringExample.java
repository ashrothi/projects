package demo;

import org.apache.commons.lang.StringUtils;

public class StringExample {
	public static void main(String[] args) {
		// String a =
		// "(28.8364683333,78.2275733333,1489658751000,0.42,27.7,OFF,0)";
		//
		// String[] array = a.replaceAll("\\(", "").split(",");
		//
		// for (String string : array) {
		// System.out.println(string);
		// }
		// String b = array[0];
		// String c = array[1];
		//
		// System.out.println("yooo" + b+"\n"+c);

		// String string = "username, token, ip_address,
		// end_node_name,notificationmsg, notificationtype, mobileno, sendurl,
		// smsUsername, SmsPassword, subject, template, from,";
		//
		// System.out.println(StringUtils.countMatches(string, ","));
		//
		// String string = "{\"description\":\"Login
		// Success\",\"object\":{\"access_token\":\"956984e0-955a-4ddf-8bcc-8731b1a6afe4\",\"expires_in\":10,\"message\":\"You
		// have successfully logged
		// in...\",\"status\":false,\"userKey\":\"dcfb5f5f-588e-11e6-85b9-fe984cc15272\",\"access_key\":\"d3cd4e3f-5946-11e6-9bb0-fe984cc15272\",\"roles_name\":\"PLATFORM_ADMIN\",\"roles_id\":\"7\",\"user_id\":\"preeti.burad@teramatrix.co\",\"last_activity_date\":\"2017-04-22
		// 06:56:05.0\",\"last_password_change_date\":\"2017-04-03
		// 05:25:06.0\",\"last_login_date\":\"2017-04-22
		// 06:56:05.0\"},\"list\":null,\"valid\":true}";
		//
		// String token =
		// string.substring(string.indexOf("access_token")+"access_token".length()+3);
		//
		// String[] string2=token.split("\"");
		// System.out.println(string2[0]);
		//
		// String schoolbag2 = "Books,Pens,Pencils,Notebooks" ;
		// System.out.println(schoolbag2.toString().replaceAll(",", "|#@|"));

		String string = "<25#$#>8#$#<25#$#>5#$#=1#$#>4#$#>4#$#<25#$#<25#$#>4#$#>4#$#>4#$#=10#$#=10#$#<50#$#>4#$#<50#$#>4#$#>4#$#>4#$#<20#$#<50";

		String[] strings = string.split("\\#\\$\\#");
		System.out.println(strings.length);
		for (int i = 0; i < strings.length; i++) {
			System.out.println(strings[i]);
		}

		// if (string.contains("<")) {
		// System.out.println(string.substring(string.indexOf("<") + 1));
		//
		// } else {
		// System.out.println(string + " Check fails");
		// }

	}
}
