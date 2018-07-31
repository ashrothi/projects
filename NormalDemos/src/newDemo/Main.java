package newDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection(
				"jdbc:mysql://192.168.1.58:3306/gmonstar_orchestration?user=root&password=Ttpl@123");
		System.out.println(connection.getClientInfo());
		Statement statement = connection.createStatement();

		ResultSet set = statement.executeQuery("call gmonstar_api_get_by_api_group_id('67', '234206210072040', '8944200012789720400F', 'IN')");
		System.out.println(set.toString());
		ResultSetMetaData data = set.getMetaData();

		int id = data.getColumnCount();

		for (int i = 1; i <= id; i++) {
			System.out.print(data.getColumnLabel(i) + " " + data.getColumnName(i));
		}
		System.out.println();

		while (set.next()) {
			for (int i = 1; i <= id; i++) {
				System.out.print(set.getString(i));
			}

		}

	}
}
