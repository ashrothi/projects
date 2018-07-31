package com.logging.service;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.logging.dao.*;

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
	public Object executeProcesure(Class clz, String sql, SessionFactory sessionFactory, Object... objects)
			throws Exception {

		try {
			return genericDao.executeProcesure(clz, sql, sessionFactory, objects);
		} catch (Exception e) {
			throw e;
		}

	}

}
