/**
 * 
 */
package demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author tanvigarg
 *
 */
public class DatabaseConn {

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
			Class.forName("org.hsqldb.jdbcDriver");
			System.out.println("Hello");
			Connection connection = DriverManager.getConnection("jdbc:hsqldb:hsql://13.94.42.90:9001/TokenManagement","SA", "");

			System.out.println("connection:-" + connection.getCatalog());
			// return connection;

	
	}

}
