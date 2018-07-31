/**
 * This package is use to configure all properties of HERO
 */
package in.teramatrix.barc.configuration;

/**
 * This Class is use to configure all properties of which is useful for the
 * project.
 * 
 * @author Mandeep Singh
 *
 */
public class Configuration {

	private static String zookeeperConnection;
	private static String kafkaConsumerId;
	private static String kafkaSubscriberTopic;
	private static String kafkaBroker;

	private static String dbDriver;
	private static String dbUrl;
	private static String procedureName;
	private static String apiUrl;
	
	private static String logsPath;

	/**
	 * @return the kafkaSubscriberTopic
	 */
	public static String getKafkaSubscriberTopic() {
		return kafkaSubscriberTopic;
	}

	/**
	 * @param kafkaSubscriberTopic
	 *            the kafkaSubscriberTopic to set
	 */
	public static void setKafkaSubscriberTopic(String kafkaSubscriberTopic) {
		Configuration.kafkaSubscriberTopic = kafkaSubscriberTopic;
	}

	/**
	 * @return the zookeeperConnection
	 */
	public static String getZookeeperConnection() {
		return zookeeperConnection;
	}

	/**
	 * @param zookeeperConnection
	 *            the zookeeperConnection to set
	 */
	public static void setZookeeperConnection(String zookeeperConnection) {
		Configuration.zookeeperConnection = zookeeperConnection;
	}

	/**
	 * @return the kafkaConsumerId
	 */
	public static String getKafkaConsumerId() {
		return kafkaConsumerId;
	}

	/**
	 * @param kafkaConsumerId
	 *            the kafkaConsumerId to set
	 */
	public static void setKafkaConsumerId(String kafkaConsumerId) {
		Configuration.kafkaConsumerId = kafkaConsumerId;
	}

	/**
	 * @return the kafkaBroker
	 */
	public static String getKafkaBroker() {
		return kafkaBroker;
	}

	/**
	 * @param kafkaBroker
	 *            the kafkaBroker to set
	 */
	public static void setKafkaBroker(String kafkaBroker) {
		Configuration.kafkaBroker = kafkaBroker;
	}

	/**
	 * @return the dbDriver
	 */
	public static String getDbDriver() {
		return dbDriver;
	}

	/**
	 * @param dbDriver the dbDriver to set
	 */
	public static void setDbDriver(String dbDriver) {
		Configuration.dbDriver = dbDriver;
	}

	/**
	 * @return the dbUrl
	 */
	public static String getDbUrl() {
		return dbUrl;
	}

	/**
	 * @param dbUrl the dbUrl to set
	 */
	public static void setDbUrl(String dbUrl) {
		Configuration.dbUrl = dbUrl;
	}


	/**
	 * @return the procedureName
	 */
	public static String getProcedureName() {
		return procedureName;
	}

	/**
	 * @param procedureName the procedureName to set
	 */
	public static void setProcedureName(String procedureName) {
		Configuration.procedureName = procedureName;
	}

	/**
	 * @return the apiUrl
	 */
	public static String getApiUrl() {
		return apiUrl;
	}

	/**
	 * @param apiUrl the apiUrl to set
	 */
	public static void setApiUrl(String apiUrl) {
		Configuration.apiUrl = apiUrl;
	}

	/**
	 * @return the logsPath
	 */
	public static String getLogsPath() {
		return logsPath;
	}

	/**
	 * @param logsPath the logsPath to set
	 */
	public static void setLogsPath(String logsPath) {
		Configuration.logsPath = logsPath;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "${class.name} [ kafkaConsumerId=" + kafkaConsumerId + ", zookeeperConnection=" + zookeeperConnection
				+ ", kafkaBroker=" + kafkaBroker + ", kafkaSubscriberTopic=" + kafkaSubscriberTopic + "]";
	}
}
