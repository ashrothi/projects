/**
 * 
 */
package demo;

/**
 * @author tanvigarg
 *
 */
public class Servicename {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuilder servicebuilder = new StringBuilder();
		StringBuilder databuilder = new StringBuilder();
		StringBuilder latbuilder = new StringBuilder();
		StringBuilder longbuilder = new StringBuilder();
		StringBuilder timebuilder = new StringBuilder();

		for (int i = 0; i < 84; i++) {
			latbuilder.append("String.valueOf(map2.get(\"score_lat_list_" + (i + 1) + "\")),");
			longbuilder.append("String.valueOf(map2.get(\"score_long_list_" + (i + 1) + "\")),");
			timebuilder.append("String.valueOf(map2.get(\"score_time_list_" + (i + 1) + "\")),");
			databuilder.append(
					"lat_list_" + (i + 1) + ",long_list_" + (i + 1) + ",time_list_" + (i + 1) + ",");
			servicebuilder.append( "score" + ",");
		}
		System.out.println(databuilder.toString());
		System.out.println(latbuilder.toString());
		System.out.println(longbuilder.toString());
		System.out.println(timebuilder.toString());
		System.out.println(servicebuilder.toString());
	}

}
