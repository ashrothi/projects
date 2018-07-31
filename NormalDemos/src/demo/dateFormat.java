package demo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class dateFormat {
	
	
	
	
	
	
	
	
	

	/**
	 * Utility function to convert java Date to TimeZone format
	 * @param date
	 * @param format
	 * @param timeZone
	 * @return
	 */
	public static String formatDateToString(Date date, String format,
			String timeZone) {
		// null check
		if (date == null) return null;
		// create SimpleDateFormat object with input format
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		// default system timezone if passed null or empty
		if (timeZone == null || "".equalsIgnoreCase(timeZone.trim())) {
			timeZone = Calendar.getInstance().getTimeZone().getID();
		}
		// set timezone to SimpleDateFormat
		sdf.setTimeZone(TimeZone.getTimeZone(timeZone));
		// return Date in required format with timezone as String
		return sdf.format(date);
	}

	public static void main(String[] args) throws ParseException {
		//Test formatDateToString method
//		Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2018-05-18 07:19:04");
//		System.out.println("Default Date:"+date.toString());
//		System.out.println("System Date: "+formatDateToString(date, "yyyy-MM-dd HH:mm:ss", null));
//		System.out.println("System Date in PST: "+formatDateToString(date, "yyyy-MM-dd HH:mm:ss", "PST"));
//		System.out.println("System Date in IST: "+formatDateToString(date, "yyyy-MM-dd HH:mm:ss", "IST"));
//		System.out.println("System Date in GMT: "+formatDateToString(date, "yyyy-MM-dd HH:mm:ss", "GMT"));
		
		
		
		String input = "2018-06-03";
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = format.parse(input);
		Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
		calendar.setTime(date);
		System.out.println(calendar.get(Calendar.YEAR));
		
		System.out.println(new SimpleDateFormat("MM").format(calendar.getTime()));
		System.out.println(new SimpleDateFormat("dd").format(calendar.getTime()));
		
//		
//		
//		 Calendar calendar = Calendar.getInstance();
//		 calendar.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2018-05-18 07:19:04"));
//	        System.out.println("Original = " + calendar.getTime());
//	 
//	        // Substract 2 hour from the current time
////	        calendar.add(Calendar.HOUR, -2);
//	 
//	        // Add 30 minutes to the calendar time
//	        calendar.add(Calendar.MINUTE, 330);
//	 
//	        // Add 300 seconds to the calendar time
////	        calendar.add(Calendar.SECOND, 300);
//	        System.out.println("Updated  = " + calendar.getTime());
//	        
//	        
//	        System.out.println("Updated  = " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format( calendar.getTime()));
//	       
	}
	
	
	// public static void main(String[] args) {
	// ZonedDateTime utc = ZonedDateTime.now(ZoneOffset.UTC);
	//
	// System.out.println("DATETIME = " + Date.from(utc.toInstant()));
	// System.out.println("DATETIME = " +
	// utc.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
	// }
//	public static void main(String[] args) throws ParseException {

		// SimpleDateFormat formatter = new SimpleDateFormat("ddMMMyyyy");
		// String dateInString = "07January2013";
		//
		// try {
		//
		// Date date = formatter.parse(dateInString);
		// System.out.println(date);

		// SimpleDateFormat sm =
		// new SimpleDateFormat("yyyy-MM-dd");
		// String dateInString = "2018-02-23 16:35:31";
		// Date date = sm.parse(dateInString);
		// System.out.println("111111111 " + date);
		// System.out.println(sm.format(date));
		//
		// } catch (ParseException e) {
		// e.printStackTrace();
		// }
		// System.out.println(" 111111111111 " + String.valueOf(new
		// Date().getTime() - 1 * 24 * 3600 * 1000));
		//
		// Calendar calendar = Calendar.getInstance();
		// Date epoch = new Date();
		// calendar.setTime(epoch);
		// calendar.add(Calendar.MINUTE, -15);
		// Date result = calendar.getTime();
		
	}
	// private Object convertDateInEpoch(String replace) throws ParseException {
	//
	// DateFormat dF = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); // The mask
	// Date date = dF.parse(replace); // parsing the String into a Date using
	// // the mask
	//
	// return date.getTime();
	// }

//}
