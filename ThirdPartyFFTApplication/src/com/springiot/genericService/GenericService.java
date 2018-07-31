/**
 * This package contain  class as Service is used to call the Generic Services
 */
package com.springiot.genericService;

/**
 * To Import Classes to access their functionality
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springiot.genericDao.GenericDao;

/**
 * 
 * This class use as Service to call all the Generic Dao Method in all possible
 * cases to interact with Databases for their different CRUD and other
 * Functionality
 * 
 * @author Ankita Shrothi
 *
 */
@Service
@Transactional
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
	 */
	public Object executeProcesure(Class clz, String sql, Object... objects) {
		return genericDao.executeProcesure(clz, sql, objects);
	}

}
