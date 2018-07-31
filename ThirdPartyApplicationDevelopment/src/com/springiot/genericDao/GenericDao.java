/**
 * This package contains class for generating session with database and performing operation using hibernate.
 */
package com.springiot.genericDao;

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
 * This class is to define all the Methods to perform operations on Database.
 * 
 * @author Mandeep Singh 
 */
@Repository
@SuppressWarnings("rawtypes")
public class GenericDao {

	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * save() method use for save the data in database.
	 * 
	 * @param object : Here pass object to save into database.
	 * @return Object of result after saving the context.
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
	 * update() method use for update row the data in database.
	 * 
	 * @param object : Here pass object to update into database.
	 * @return Object of result after updating the context.
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
	 * saveAndUpdate() method use for save and update row in database.
	 * 
	 * @param object : Here pass object to save and update into database.
	 * @return Object of result after saving and updating the context.
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
	 * saveOrUpdateAll() method use for save and update all data in database.
	 * 
	 * @param collection : Here pass collection to update multiple records into database.
	 * @return Object of result after saving or updating the context.
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
	 * delete() method use for delete data in database.
	 * 
	 * @param object : Here pass object to delete into database.
	 * @return Object of result after deleting the context.
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
	 * findAll() method use for find all data in database.
	 * 
	 * @param clz : Here pass class to find into database.
	 * @return Object of result of found context.
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
	 * findByID() method use for find data by id in database.
	 * 
	 * @param clz : Here pass class from which find operation is to be done into database.
	 * @param value : Here pass value of id to find into database.
	 * @return Object of result of found context.
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
	 * findByColumn() method use for find data by column in database.
	 * 
	 * @param clz : Here pass class from which find operation is to be done into database.
	 * @param key : Here pass key on which find operation is to be performed into database.
	 * @param value : Here pass value of the defined key to find into database.
	 * @return Object of result of found context.
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
	 * findByColumnUnique() method use for find only unique data by column in database.
	 * 
	 * @param clz : Here pass class from which find operation is to be done into database.
	 * @param key : Here pass key on which find operation is to be performed into database.
	 * @param value : Here pass value of the defined key to find into database.
	 * @return Object of result of found context.
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
	 * executeSqlQuery() method used to execute query in database.
	 * 
	 * @param sql : Here pass the query to be executed.
	 * @return The resultset returned from the query.
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
	 * executeAnySqlQuery() method used to execute any sql query in database.
	 * 
	 * @param sql : Here pass the query to be executed.
	 * @return The object returned from the query.
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
	 * executeSqlQuery() method used to execute query in database when query and
	 * class is passed.
	 * 
	 * @param sql : Here pass the query to be executed.
	 * @param clz : Here pass class for which query to be run.
	 * @return The object extracted from the query.
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
	 * executeProcesure() method is used to call the Procedure.
	 * 
	 * @param clz : Here pass database class for which procedure to be called.
	 * @param sql : Here pass the procedure to be executed.
	 * @param objects : Here pass the parameters to be passed for calling procedure.
	 * @return The object returned from the query.
	 */
	public Object executeProcesure(Class clz, String sql, Object[] objects) {
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);

		if (clz != null) {
			query.setResultTransformer(Transformers.aliasToBean(clz));
		} else {
			query.setResultTransformer(AliasToEntityLinkedHashMapResultTransformer.INSTANCE);
		}

		for (int i = 0; i < objects.length; i++) {
			query.setParameter(i, objects[i]);
		}

		Object result = query.list();

		return result;
	}
}