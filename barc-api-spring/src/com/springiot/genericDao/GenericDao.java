/**
 * This package contain the class use to define all the Methods to perform operations on Database.
 */
package com.springiot.genericDao;

import java.util.Date;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springiot.hibernate.transform.AliasToEntityLinkedHashMapResultTransformer;

/**
 * This class is to define all the Methods to perform operations on Database.
 */
@Repository
@SuppressWarnings("rawtypes")
public class GenericDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private SessionFactory sessionFactoryPingServer;

	/**
	 * executeProcesure() method is used to execute the Procesure
	 * 
	 * @param clz
	 * @param sql
	 * @param objects
	 * @return result
	 */

	public Object executeProcesure(Class clz, String sql, Object[] objects) throws Exception {

		Object result = null;

		try {

			Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);

			if (clz != null) {
				query.setResultTransformer(Transformers.aliasToBean(clz));
			} else {
				// query.setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
				query.setResultTransformer(AliasToEntityLinkedHashMapResultTransformer.INSTANCE);
			}

			for (int i = 0; i < objects.length; i++) {

				if (objects[i] == null) {

					query.setParameter(i, null);

				} else {

					query.setParameter(i, objects[i]);
				}
			}
			long initialTime = new Date().getTime();

			result = query.list();
			long finalTime = new Date().getTime();
			System.out.println("query time :" + (finalTime - initialTime));

			// System.out.println("Result in Generic dao is :- " + result);
		} catch (Exception exception) {
			exception.printStackTrace();
		}

		return result;
	}

	/**
	 * executeProcesure() method is used to execute the procedure for the
	 * database ping server
	 * 
	 * @param clz
	 * @param sql
	 * @param objects
	 * @return result
	 */

	public Object executeProcesurePingServer(Class clz, String sql, Object[] objects) throws Exception {

		Object result = null;

		try {

			Query query = sessionFactoryPingServer.getCurrentSession().createSQLQuery(sql);

			if (clz != null) {
				query.setResultTransformer(Transformers.aliasToBean(clz));
			} else {
				// query.setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
				query.setResultTransformer(AliasToEntityLinkedHashMapResultTransformer.INSTANCE);
			}

			for (int i = 0; i < objects.length; i++) {

				if (objects[i] == null) {

					query.setParameter(i, null);

				} else {

					query.setParameter(i, objects[i]);
				}
			}

			result = query.list();
			// System.out.println("Result in Generic dao is :- " + result);

		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return result;
	}

}