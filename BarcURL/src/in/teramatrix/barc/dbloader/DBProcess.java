package in.teramatrix.barc.dbloader;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import in.teramatrix.barc.logger.BarcLogger;

/**
 * In this class initialize the all required database's variables, here create
 * the connection from the database. Here defined some required methods like for
 * create the database connection and call the defined stored procedures.
 * 
 * @author Mandeep Singh
 */
public class DBProcess {
	/**
	 * This method is used for creating the database connection. This method establish
	 * connection using database name and database authentication credentials.
	 * 
	 * @param DriverName : Here pass the name of database driver.
	 * @param url : Here pass the connection string of database.
	 * @return This method returns either connection object or null.
	 */
	public static Connection getDbConnection(String DriverName, String url) {

		try {
			/**
			 * Instance for driver class initialization.
			 */
			Class.forName(DriverName);

			/**
			 * Create the connection.
			 */
			Connection connection = DriverManager.getConnection(url);
			BarcLogger.logger.info("Connection Established: " + connection);
			/**
			 * Return connection if connection is established.
			 */
			return connection;

		} catch (Exception exception) {
			BarcLogger.logger.info("Exception occur while connecting to DB.");
			exception.printStackTrace(BarcLogger.printStream);
			return null;
		}
	}
	
	/**
	 * This method is used for calling stored procedures.
	 * 
	 * @return the resultset retrieved from the database.
	 */
	public static ResultSet callProcedure(Connection connection, String procedure) {
		
		/**
		 * Create object of type CallableStatement which maintain the call
		 * connection with storedProcedure
		 */
		CallableStatement statement = null;
		ResultSet resultSet = null;

		try {
				String storedProcedure = "Call " + procedure;
				/**
				 * initialize the object and execute the calling of procedure.
				 */
				statement = connection.prepareCall(storedProcedure);
				boolean procCalled = statement.execute();
				if(procCalled){
					BarcLogger.logger.info("Procedure called :-" + storedProcedure);
					resultSet = statement.getResultSet();
				}
				return resultSet;
		} catch (Exception exception) {
			BarcLogger.logger.info("Exception occur in calling procedures");
			exception.printStackTrace(BarcLogger.printStream);
			return resultSet;
		}
	}
}
