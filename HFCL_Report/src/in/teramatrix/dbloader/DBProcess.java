package in.teramatrix.dbloader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.teramatrix.logger.HfclLogger;

/**
 * In this class initialize the all required database's variables, here create
 * the connection from the database. Here defined some required methods like for
 * create the database connection and call the defined stored procedures.
 * 
 * @author Mandeep Singh
 */
public class DBProcess {
	/**
	 * This method is used for creating the database connection. This method
	 * establish connection using database name and database authentication
	 * credentials.
	 * 
	 * @param DriverName
	 *            : Here pass the name of database driver.
	 * @param url
	 *            : Here pass the connection string of database.
	 * @return This method returns either connection object or null.
	 */
	public static Connection getDbConnection(String DriverName, String url) {

		try {
			/**
			 * Instance for driver class initialization.
			 */
			Class.forName(DriverName);
			HfclLogger.logger.info("Connection DriverName: " + DriverName);
			HfclLogger.logger.info("Connection url: " + url);
			/**
			 * Create the connection.
			 */
			Connection connection = DriverManager.getConnection(url);
			HfclLogger.logger.info("Connection Established: " + connection);
			/**
			 * Return connection if connection is established.
			 */
			return connection;

		} catch (Exception exception) {
			HfclLogger.logger.info("Exception occur while connecting to DB.");
			exception.printStackTrace();
			return null;
		}
	}

	/**
	 * This method is used for calling stored procedures.
	 * 
	 * @return the resultset retrieved from the database.
	 */
	public static void executeQuery(Connection connection, String query) {

		/**
		 * Create object of type CallableStatement which maintain the call
		 * connection with storedProcedure
		 */
		PreparedStatement statement = null;

		try {

			/**
			 * initialize the object and execute the calling of procedure.
			 */
			statement = connection.prepareStatement(query);
			boolean procCalled = statement.execute();
			if (procCalled) {
				HfclLogger.logger.info("Query Executed :-" + procCalled);

				connection.close();
			}

		} catch (Exception exception) {
			HfclLogger.logger.info("Exception occur in calling query");
			exception.printStackTrace();

		}
	}
}
