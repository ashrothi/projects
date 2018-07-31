package com.rld.constant;

import java.util.HashMap;
import java.util.List;

/*
 * Class is used to create dynamic query for insertion of data in table in MySql as well as SQL Server.
 */
public class DynamicQuery {
	/*
	 * Dynamic query is created
	 */
	public String createDynamicQuery(List<HashMap<String, String>> data, String tableName, String parameter) {
		try {

			// Initializing of String Builder.
			StringBuilder builder = new StringBuilder();
			// Append in String Builder according to insert query.
			builder.append("insert into " + tableName + " (" + parameter + ") values");
			System.out.println("==============" + parameter);

			String[] keys = parameter.split(",");
			System.out.println("keys are: " + keys.length);

			for (HashMap<String, String> valuesdB : data) {
				//System.out.println("MAP :" + valuesdB);
				builder.append("(");

				for (int j = 0; j < keys.length; j++) {
					//System.out.println(keys[0]);

					if (j == keys.length - 1) {
						//System.out.println(valuesdB.get(keys[0].toString()));

						if (valuesdB.get(keys[j].toString()) != null) {
							// System.out.println("===check in loop");
							builder.append("'" + valuesdB.get(keys[j].toString()) + "'");
						} else {
							builder.append("''");
						}

						continue;
					}
					// System.out.println(valuesdB.get(keys[j].toString()));

					if (valuesdB.get(keys[j].toString()) != null) {
						builder.append("'" + valuesdB.get(keys[j].toString()) + "',");
					} else {
						builder.append("'',");
					}
				}

				builder.append("),");
			}
			builder.deleteCharAt(builder.lastIndexOf(","));
			//System.out.println("builder:- " + builder);
			return builder.toString();

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
