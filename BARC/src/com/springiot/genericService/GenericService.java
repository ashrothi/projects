/**
 * This package contain the class used to perform database operation and apply generic services methods.
 */
package com.springiot.genericService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springiot.genericDao.GenericDao;

/**
 * This Class is used to call the Generic Services
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
	 * To Declare the executeProcesure Method
	 * 
	 * @param clz
	 * @param sql
	 * @param objects
	 * @return Object
	 * @throws Exception
	 */
	public Object executeProcesure(Class clz, String sql, Object... objects) throws Exception {
		return genericDao.executeProcesure(clz, sql, objects);
	}

	/**
	 * To Declare the executeProcesure Method for different database ping server
	 * 
	 * @param clz
	 * @param sql
	 * @param objects
	 * @return Object
	 * @throws Exception
	 */
	public Object executeProcesurePingServer(Class clz, String sql, Object... objects) throws Exception {
		return genericDao.executeProcesurePingServer(clz, sql, objects);
	}
}