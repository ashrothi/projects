/**
 * This package contain the class used to perform database operation and apply generic services methods.
 */
package com.springiot.genericService;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springiot.genericDao.GenericDao;

/**
 * This Class is used to call the Generic Services
 */
@Service
@Transactional(readOnly = true)
@SuppressWarnings("rawtypes")
public class GenericService {

	/**
	 * To access the Methodality of the following Class Method
	 */
	@Autowired
	private GenericDao genericDao;

	/**
	 * To Declare the save Method
	 * 
	 * @param object
	 * @return Object
	 */
	public Object save(Object object) {
		return genericDao.save(object);
	}

	/**
	 * To Declare the findByID Method
	 * 
	 * @param clz
	 * @param object
	 * @return Object
	 */
	public Object findByID(Class clz, Object object) {
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
	public Object findByColumn(Class clz, String key, Object object) {
		return genericDao.findByColumn(clz, key, object);
	}

	/**
	 * To Declare the findAll Method
	 * 
	 * @param clz
	 * @return Object
	 */
	public Object findAll(Class clz) {
		return genericDao.findAll(clz);
	}

	/**
	 * To Declare the update Method
	 * 
	 * @param object
	 * @return Object
	 */
	public Object update(Object object) {
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
	public Object findByColumnUnique(Class clz, String key, Object value) {
		return genericDao.findByColumnUnique(clz, key, value);
	}

	/**
	 * To Declare the executeSqlQuery Method
	 * 
	 * @param sql
	 * @return Object
	 */
	/**
	 * @param sql
	 * @return
	 */
	public Object executeSqlQuery(String sql) {
		return genericDao.executeSqlQuery(sql);
	}

	/**
	 * To Declare the executeAnySqlQuery Method
	 * 
	 * @param sql
	 * @return Object
	 */
	public Object executeAnySqlQuery(String sql) {
		return genericDao.executeAnySqlQuery(sql);
	}

	/**
	 * To Declare the executeProcesure Method
	 * 
	 * @param clz
	 * @param sql
	 * @param objects
	 * @return Object
	 * @throws Exception
	 */
	public Object executeProcesure(Class clz, String sql, Object... objects) throws Exception {

		// System.out.println("sql" + sql);
		// Check the procedure string contains ?
		if (sql.contains("?")) {

			// return the response retrieved from procedure
			return genericDao.executeProcesure(clz, sql, objects);
		} else {

			// Initializing the string builder
			StringBuilder builder = new StringBuilder();

			// Break the sql in requiref format
			String newSql = sql.substring(0, sql.indexOf("(") + 1);
			builder.append(newSql);

			// Calculate the number of commas in procedure
			int count = StringUtils.countMatches(sql, ",");
			// System.out.println("count" + count);

			if (count == 0) {

				builder.append(")");
				// System.out.println("builder" + builder);

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
			return genericDao.executeProcesure(clz, builder.toString(), objects);
		}

	}

	public Object executeHSqlQuery(String sql) {
		try {

			return genericDao.executeHSqlQuery(sql);
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return null;
	}

	public Object executeHSqlSelectQuery(String sql) {
		try {

			return genericDao.executeHSqlselectQuery(sql);
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return null;
	}

}