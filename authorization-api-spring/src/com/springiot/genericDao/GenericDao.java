/**
 * This package contain the class use to define all the Methods to perform operations on Database.
 */
package com.springiot.genericDao;

import java.util.Collection;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.AliasToEntityMapResultTransformer;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * This class is to define all the Methods to perform operations on Database.
 */
@Repository
@SuppressWarnings("rawtypes")
public class GenericDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private SessionFactory sessionFactoryHsql;

	/**
	 * save() method use for save the data in database
	 */
	public Object save(Object object) {
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
	public Object update(Object object) {
		try {
			sessionFactory.getCurrentSession().update(object);

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	/**
	 * saveAndUpdate() method use for save and update row in database
	 */
	public Object saveAndUpdate(Object object) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(object);

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	/**
	 * saveOrUpdateAll() method use for save and update all data in database
	 */
	public Object saveOrUpdateAll(Collection collection) {
		try {

			for (Object object : collection) {
				sessionFactory.getCurrentSession().saveOrUpdate(object);

			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	/**
	 * delete() method use for delete data in database
	 */
	public Object delete(Object object) {
		try {
			sessionFactory.getCurrentSession().delete(object);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	/**
	 * findAll() method use for find all data in database
	 */
	public Object findAll(Class clz) {
		try {

			Criteria criteria = sessionFactory.getCurrentSession().createCriteria(clz);

			Object object = criteria.list();

			return object;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	/**
	 * findByID() method use for find data by id in database
	 */
	public Object findByID(Class clz, Object value) {
		try {

			Criteria criteria = sessionFactory.getCurrentSession().createCriteria(clz).add(Restrictions.idEq(value));

			Object object = criteria.uniqueResult();

			return object;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	/**
	 * findByColumn() method use for find data by column in database
	 */
	public Object findByColumn(Class clz, String key, Object value) {
		try {

			Criteria criteria = sessionFactory.getCurrentSession().createCriteria(clz).add(Restrictions.eq(key, value));

			Object object = criteria.list();

			return object;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	/**
	 * findByColumn() method use for find data by column in database
	 */
	public Object findByColumnUnique(Class clz, String key, Object value) {
		try {

			Criteria criteria = sessionFactory.getCurrentSession().createCriteria(clz).add(Restrictions.eq(key, value));

			Object object = criteria.uniqueResult();

			return object;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	/**
	 * executeSqlQuery() method used to execute query in database
	 * 
	 * @param sql
	 * @return results
	 */
	public Object executeSqlQuery(String sql) {
		try {
			SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
			query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);

			Object results = query.list();
			return results;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * executeAnySqlQuery() method used to execute any sql query in database
	 * 
	 * @param sql
	 * @return results
	 */
	public Object executeAnySqlQuery(String sql) {
		try {

			SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);

			Object results = query.executeUpdate();

			return results;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * executeSqlQuery() method used to execute query in database when query anf
	 * class is passed
	 * 
	 * @param sql
	 * @param clz
	 * @return results
	 */
	public Object executeSqlQuery(String sql, Class clz) {
		try {

			SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
			query.addEntity(clz);
			Object results = query.list();

			return results;
		} catch (Exception e) {
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

	public Object executeProcesure(Class clz, String sql, Object[] objects) throws Exception {

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

			return result;
		} catch (Exception exception) {

			throw exception;
		}
	}

	public Object executeHSqlQuery(String sql) {
		try {
			SQLQuery query = sessionFactoryHsql.getCurrentSession().createSQLQuery(sql);
			
			query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);

			int queryResult = query.executeUpdate();

			return queryResult;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Object executeHSqlselectQuery(String sql) {
		try {

			SQLQuery query = sessionFactoryHsql.getCurrentSession().createSQLQuery(sql);

			query.setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);

			Object results = query.list();

			return results;
		} catch (Exception e) {
			return null;
		}
	}
}