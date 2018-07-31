/**
 * 
 */
package demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.OptionalDouble;

import org.neo4j.cypher.internal.compiler.v2_1.functions.Str;

/**
 * @author tanvigarg
 *
 */
public class a {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ArrayList<Integer> array = new ArrayList<Integer>();

		for (int i = 0; i < 3; ++i) {

			array.add(i);

		}

		int max = Collections.max(array);
		int min = Collections.min(array);

		OptionalDouble avg = array.stream().mapToInt(a -> a).average();

		System.out.println("Max: " + max);
		System.out.println("Min: " + min);
		System.out.println("avg: " + avg);

		String group_id = "12|#@|15";
		String new_group_id = group_id.substring(0, group_id.indexOf("|#@|"));

		System.out.println("new_group_id " + new_group_id);

		String a = "105.0";

		System.out.println("======================="+a.replaceAll("\\.0", ""));
		
		
		
		String string="{imsi Value not supported}";
		System.out.println(string.replaceAll("\\{", "").replaceAll("\\}", ""));
	}

}
