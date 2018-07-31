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
@Transactional(readOnly=false,noRollbackFor=Exception.class)
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
	 * @throws Exception 
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
	 * @throws Exception 
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
	 * @throws Exception 
	 */
	public Object findByColumn(Class clz, String key, Object object) throws Exception {
		return genericDao.findByColumn(clz, key, object);
	}

	/**
	 * To Declare the findAll Method
	 * 
	 * @param clz
	 * @return Object
	 * @throws Exception 
	 */
	public Object findAll(Class clz) throws Exception {
		return genericDao.findAll(clz);
	}

	/**
	 * To Declare the update Method
	 * 
	 * @param object
	 * @return Object
	 * @throws Exception 
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
	 * @throws Exception 
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
	/**
	 * @param sql
	 * @return
	 * @throws Exception 
	 */
	public Object executeSqlQuery(String sql) throws Exception {
		return genericDao.executeSqlQuery(sql);
	}

	/**
	 * To Declare the executeAnySqlQuery Method
	 * 
	 * @param sql
	 * @return Object
	 * @throws Exception 
	 */
	public Object executeAnySqlQuery(String sql) throws Exception {
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
	public Object executeThirdPartyProcesure(Class clz, String sql, Object... objects) {
		return genericDao.executeThirdPartyProcesure(clz, sql, objects);
	}

}
