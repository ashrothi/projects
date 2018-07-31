package GenralExample;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabasConnection {
public static void main(String[] args) {
	try {
		Class.forName("org.mariadb.jdbc.Driver");
		Connection con = (Connection) DriverManager.
			getConnection("jdbc:mariadb://192.168.1.122:3306/obd_development"
				,"developer","admin@123");
		Statement stmt = (Statement) con.createStatement();
		System.out.println("Created DB Connection...."+con.getClientInfo());
	} catch (ClassNotFoundException e) {
		
		e.printStackTrace();
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
}
}
