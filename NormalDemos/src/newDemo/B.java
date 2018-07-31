package newDemo;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class B {
	/**
	 * convertDate() is used to convert date and time according to database
	 * format
	 * 
	 * @param dateStr
	 * @return
	 * @throws ParseException
	 */
	public String convertDate(String dateStr) throws ParseException {

		Date d = new Date(Long.parseLong(dateStr));
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		String formatted = format.format(d);

		if (formatted != null) {

			return formatted;
		} else {
			return "";
		}

	}

	/**
	 * fromDate() to get the fromDate in required format
	 * 
	 * @return
	 * @throws Exception
	 */
	public String fromDate() throws Exception {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		return dateFormat.format(cal.getTime());
	}

	/**
	 * endDate() to get the endDate in required format
	 * 
	 * @return
	 * @throws Exception
	 */
	public String endDate() throws Exception {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd 23:59:59");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		return dateFormat.format(cal.getTime());

	}
	public static void main(String[] args) throws ParseException {

		
		String str = "2017-01-06 15:28:10";
		DateFormat dF = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); // The mask		
		Date date = dF.parse(str); // parsing the String into a Date using the mask
//
//		
		System.out.println("Epoch representation of this date is: " + date.getTime()); 
//		String dateString = "1482923701216";
//		Date d = new Date(Long.parseLong(dateString));
//		DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//		String formatted = format.format(d);
//		System.out.println(formatted);
//		

		// final String input = "ashrothi@gmail.com";
		// final Pattern pattern =
		// Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		// + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		// if (!pattern.matcher(input).matches()) {
		// System.out.println("Hello");
		// throw new IllegalArgumentException("Invalid String");
		//
		// }
		// else
		// {
		// System.out.println(input);
		// }
		// A abc = new A();
		// abc.abh();
		
	}

}
