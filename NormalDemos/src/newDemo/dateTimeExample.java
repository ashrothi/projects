package newDemo;

import java.util.Calendar;
import java.util.Date;

public class dateTimeExample {
	public static void main(String[] args) {

		dateTimeExample dateTimeExample = new dateTimeExample();
		System.out.println(dateTimeExample.getStartOfDay(new Date()));
		System.out.println(dateTimeExample.getEndOfDay(new Date()));
	}

	public long getEndOfDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, -1);
//		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		calendar.set(Calendar.MILLISECOND, 999);
		return calendar.getTimeInMillis();
	}

	public long getStartOfDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, -1);
//		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTimeInMillis();
	}

}
