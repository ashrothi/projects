package com.logging.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.transform.AliasToEntityMapResultTransformer;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

@Repository
@SuppressWarnings("rawtypes")
public class GenericDao {

	public Object save(Object object, SessionFactory sessionFactory) {
		try {

			Object obj = sessionFactory.getCurrentSession().save(object);

			return obj;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	/**
	 * update() method use for update row the data in database
	 */
	public Object update(Object object, SessionFactory sessionFactory) {
		try {
			sessionFactory.getCurrentSession().update(object);

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	/**
	 * executeProcesure() method is used to execute the Procedure
	 * 
	 * @param clz
	 * @param sql
	 * @param objects
	 * @return result
	 */

	public Object executeProcesure(Class clz, String sql, SessionFactory sessionFactory, Object[] objects)
			throws Exception {

		// Create session with the database,the getCurrentSession()
		// automatically closes the connection.

		try {
			Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);

			if (clz != null) {
				query.setResultTransformer(Transformers.aliasToBean(clz));
			} else {
				query.setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
			}

			if (objects.length > 0) {

				for (int i = 0; i < objects.length; i++) {
					System.out.println("!!!!!" + objects[i]);

					// Check parameters are null
					if (objects[i] == null) {

						query.setParameter(i, null);

					} else {
						query.setParameter(i, objects[i]);
					}
				}
			}
			// Return the response
			Object result = query.list();
			System.out.println("Result in Generic dao is :- " + result);
			return result;
		} catch (Exception exception) {
			System.out.println("throws exception");
			throw exception;
		}
	}
}
