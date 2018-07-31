package com.springiot.genericService;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springiot.genericDao.GenericDao;

/**
 * 
 * @author Garima Joshi This Class is used to call the Generic Services
 */

@Service
@Transactional
@SuppressWarnings("rawtypes")
public class GenericService {

	/**
	 * To access the functionality of the following Class
	 */

	@Autowired
	private GenericDao genericDao;

	/**
	 * To Declare the save Method
	 * 
	 * @param object
	 * @return Object
	 */

	public Object save(Object object) throws Exception {
		return genericDao.save(object);
	}
	/**
	 * To Declare the findByID Method
	 * 
	 * @param clz
	 * @param object
	 * @return Object
	 */
	public Object findByID(Class clz, Object object) throws Exception {
		return genericDao.findByID(clz, object);
	}

	/**
	 * To Declare the findByColumn Method
	 * 
	 * @param clz
	 * @param key
	 * @param object
	 * @return Object
	 */
	public Object findByColumn(Class clz, String key, Object object) throws Exception {
		return genericDao.findByColumn(clz, key, object);
	}

	/**
	 * To Declare the findAll Method
	 * 
	 * @param clz
	 * @return Object
	 */

	public Object findAll(Class clz) throws Exception {
		return genericDao.findAll(clz);
	}

	/**
	 * To Declare the update Method
	 * 
	 * @param object
	 * @return Object
	 */
	public Object update(Object object) throws Exception {
		return genericDao.update(object);
	}

	/**
	 * To Declare the findByColumnUnique Method
	 * 
	 * @param clz
	 * @param key
	 * @param value
	 * @return Object
	 */

	public Object findByColumnUnique(Class clz, String key, Object value) throws Exception {
		return genericDao.findByColumnUnique(clz, key, value);
	}

	/**
	 * To Declare the executeSqlQuery Method
	 * 
	 * @param sql
	 * @return Object
	 */

	public Object executeSqlQuery(String sql) throws Exception {
		return genericDao.executeSqlQuery(sql);
	}

	/**
	 * To Declare the executeAnySqlQuery Method
	 * 
	 * @param sql
	 * @return Object
	 */

	public Object executeAnySqlQuery(String sql) throws Exception {
		return genericDao.executeAnySqlQuery(sql);
	}

	public Object executeAnySqlQueryMetaData(String sql) throws Exception {
		return genericDao.executeAnySqlQueryMetaData(sql);
	}

	public Object executeAnySqlQueryConfigData(String sql) throws Exception {
		return genericDao.executeAnySqlQueryConfigData(sql);
	}

	/**
	 * To Declare the executeProcesure Method of Performance Table.
	 * 
	 * @param clz
	 * @param sql
	 * @param objects
	 * @return Object
	 */
	public Object executeProcesure(Class clz, String sql, Object... objects) throws Exception {
		System.out.println("sql" + sql);

		// Check the procedure string contains ?
		if (sql.contains("?")) {
			System.out.println("?");
			// return the response retrieved from procedure
			return genericDao.executeProcesure(clz, sql, objects);
		} else {

			// Initializing the string builder
			StringBuilder builder = new StringBuilder();

			// Break the sql in required format
			String newSql = sql.substring(0, sql.indexOf("(") + 1);
			builder.append(newSql);

			// Calculate the number of commas in procedure
			int count = StringUtils.countMatches(sql, ",");

			// Append the '?' in sql helps to call procedure
			for (int i = 0; i < count + 1; i++) {
				String comma = "?,";

				// Append in builder
				builder.append(comma);
			}

			// Append the data in builder as per requirement
			builder.deleteCharAt(builder.lastIndexOf(","));
			builder.append(")");

			// return the response retrieved from procedure
			return genericDao.executeProcesure(clz, builder.toString(), objects);
		}
	}

	/**
	 * To Declare the executeProcesure Method of Config Table.
	 * 
	 * @param clz
	 * @param sql
	 * @param objects
	 * @return Object
	 */
	public Object executeProcesureFromConfig(Class clz, String sql, Object... objects) throws Exception {

		// Check the procedure string contains ?
		if (sql.contains("?")) {

			// return the response retrieved from procedure
			return genericDao.executeProcesureFromConfig(clz, sql, objects);
		} else {

			// Initializing the string builder
			StringBuilder builder = new StringBuilder();

			// Break the sql in required format
			String newSql = sql.substring(0, sql.indexOf("(") + 1);
			builder.append(newSql);

			// Calculate the number of commas in procedure
			int count = StringUtils.countMatches(sql, ",");

			// Append the '?' in sql helps to call procedure
			for (int i = 0; i < count + 1; i++) {
				String comma = "?,";

				// Append in builder
				builder.append(comma);
			}

			// Append the data in builder as per requirement
			builder.deleteCharAt(builder.lastIndexOf(","));
			builder.append(")");

			// return the response retrieved from procedure
			return genericDao.executeProcesureFromConfig(clz, builder.toString(), objects);
		}

	}

	/**
	 * To Declare the executeProcesure Method of Metadata Table.
	 * 
	 * @param clz
	 * @param sql
	 * @param objects
	 * @return Object
	 * @throws Exception
	 */
	public Object executeProcesureFromMetaData(Class clz, String sql, Object... objects) throws Exception {
		System.out.println("sql" + sql);

		// Check the procedure string contains ?
		if (sql.contains("?")) {

			// return the response retrieved from procedure
			return genericDao.executeProcesureFromMetaData(clz, sql, objects);
		} else {

			// Initializing the string builder
			StringBuilder builder = new StringBuilder();

			// Break the sql in required format
			String newSql = sql.substring(0, sql.indexOf("(") + 1);
			builder.append(newSql);

			// Calculate the number of commas in procedure
			int count = StringUtils.countMatches(sql, ",");

			if (count == 0) {
				builder.append(")");
			} else {
				// Append the '?' in sql helps to call procedure
				for (int i = 0; i < count + 1; i++) {
					String comma = "?,";

					// Append in builder
					builder.append(comma);
				}

				// Append the data in builder as per requirement
				builder.deleteCharAt(builder.lastIndexOf(","));
				builder.append(")");
			}

			// return the response retrieved from procedure
			return genericDao.executeProcesureFromMetaData(clz, builder.toString(), objects);

		}
	}

	public Object executeProcesureFromLogs(Class clz, String sql, Object... objects) throws Exception {

		System.out.println("sql" + sql);

		// Check the procedure string contains ?
		if (sql.contains("?")) {

			// return the response retrieved from procedure
			return genericDao.executeProcesureFromLogs(clz, sql, objects);
		} else {

			// Initializing the string builder
			StringBuilder builder = new StringBuilder();

			// Break the sql in required format
			String newSql = sql.substring(0, sql.indexOf("(") + 1);
			builder.append(newSql);

			// Calculate the number of commas in procedure
			int count = StringUtils.countMatches(sql, ",");

			if (count == 0) {
				builder.append(")");
			} else {
				// Append the '?' in sql helps to call procedure
				for (int i = 0; i < count + 1; i++) {
					String comma = "?,";

					// Append in builder
					builder.append(comma);
				}

				// Append the data in builder as per requirement
				builder.deleteCharAt(builder.lastIndexOf(","));
				builder.append(")");
			}
			// return the response retrieved from procedure
			return genericDao.executeProcesureFromLogs(clz, builder.toString(), objects);

		}
	}

	public Object executeHSqlQuery(String sql) {
		try {
			System.out.println("hsql query in Generic Service" + sql);
			return genericDao.executeHSqlQuery(sql);
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return null;
	}

	public Object executeHSqlSelectQuery(String sql) {
		try {
			System.out.println("hsql query in Generic Service" + sql);
			return genericDao.executeHSqlselectQuery(sql);
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return null;
	}
}
