package LambdaExpression;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class dateChane {
	public static void main(String[] args) {
		DateFormat currentFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		String fromdate = currentFormat.format(new Date(System.currentTimeMillis() - TimeUnit.HOURS.toMillis(1)));
		System.out.println(new Date(System.currentTimeMillis() - TimeUnit.HOURS.toMillis(1)).getTime());
	}
}
