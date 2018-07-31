/**
 * This package contain  class as Repository is used to call the GenericDao
 */
package com.springiot.genericDao;

/**
 * To Import Classes to access their functionality
 */
import java.util.Collection;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springiot.hibernate.transform.AliasToEntityLinkedHashMapResultTransformer;

/**
 * 
 * This class use as Repository to call all Method in all possible cases to
 * interact with Databases for their different CRUD and other Functionality
 * 
 * @author Ankita Shrothi
 *
 */
@Repository
@SuppressWarnings("rawtypes")
public class GenericDao {
	/**
	 * To Access the respective class Methods as their services
	 */
	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * save() method is used for saving the data in database
	 */
	public Object save(Object object) throws Exception {
		try {

			Object obj = sessionFactory.getCurrentSession().save(object);

			return obj;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * update() method is used for updating row in database.
	 */
	public Object update(Object object) throws Exception {
		try {
			sessionFactory.getCurrentSession().update(object);

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	/**
	 * saveAndUpdate() method used for saving and updating row in database.
	 */
	public Object saveAndUpdate(Object object) throws Exception {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(object);

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	/**
	 * saveOrUpdateAll() method used for saving and updating all data in database.
	 */
	public Object saveOrUpdateAll(Collection collection) throws Exception {
		try {

			for (Object object : collection) {
				sessionFactory.getCurrentSession().saveOrUpdate(object);

			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	/**
	 * delete() method used for deleting data in database
	 */
	public Object delete(Object object) throws Exception {
		try {
			sessionFactory.getCurrentSession().delete(object);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	/**
	 * findAll() method used for find all data in database
	 */
	public Object findAll(Class clz) throws Exception {
		try {

			Criteria criteria = sessionFactory.getCurrentSession().createCriteria(clz);

			Object object = criteria.list();

			return object;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	/**
	 * findByID() method use for find data by id in database
	 */
	public Object findByID(Class clz, Object value) throws Exception {
		try {

			Criteria criteria = sessionFactory.getCurrentSession().createCriteria(clz).add(Restrictions.idEq(value));

			Object object = criteria.uniqueResult();

			return object;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	/**
	 * findByColumn() method use for find data by column in database
	 */
	public Object findByColumn(Class clz, String key, Object value) throws Exception {
		try {

			Criteria criteria = sessionFactory.getCurrentSession().createCriteria(clz).add(Restrictions.eq(key, value));

			Object object = criteria.list();

			return object;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	/**
	 * findByColumn() method use for find data by column in database
	 */
	public Object findByColumnUnique(Class clz, String key, Object value) throws Exception {
		try {

			Criteria criteria = sessionFactory.getCurrentSession().createCriteria(clz).add(Restrictions.eq(key, value));

			Object object = criteria.uniqueResult();

			return object;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	/**
	 * executeSqlQuery() method used to execute query in database
	 * 
	 * @param sql
	 * @return results
	 */
	public Object executeSqlQuery(String sql) throws Exception {
		try {
			SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
			query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);

			Object results = query.list();
			return results;
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * executeAnySqlQuery() method used to execute any sql query in database
	 * 
	 * @param sql
	 * @return results
	 */
	public Object executeAnySqlQuery(String sql) throws Exception {
		try {

			SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);

			Object results = query.executeUpdate();

			return results;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
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
	public Object executeSqlQuery(String sql, Class clz) throws Exception {
		try {

			SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
			query.addEntity(clz);
			Object results = query.list();

			return results;
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * executeProcesure() method is used to execute the Procesure
	 * 
	 * @param clz
	 * @param sql
	 * @param objects
	 * @return result
	 */

	public Object executeProcesure(Class clz, String sql, Object[] objects) throws Exception {
		try {
			Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);

			if (clz != null) {
				query.setResultTransformer(Transformers.aliasToBean(clz));
			} else {
				query.setResultTransformer(AliasToEntityLinkedHashMapResultTransformer.INSTANCE);
			}

			if (objects.length > 0) {
				for (int i = 0; i < objects.length; i++) {
					query.setParameter(i, objects[i]);
				}
			}

			Object result = query.list();
			
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}
