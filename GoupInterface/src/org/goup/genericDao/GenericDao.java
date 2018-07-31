/**
 * This package contain  class as Repository is used to call the GenericDao
 */
package org.goup.genericDao;

/**
 * To Import Classes to access their functionality
 */
import java.util.Collection;

import org.goup.hibernate.transform.AliasToEntityLinkedHashMapResultTransformer;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
			// System.out.println("Query "+query);
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
	 * executeProcesure() method is used to execute the Procesure
	 * 
	 * @param clz
	 * @param sql
	 * @param objects
	 * @return result
	 */

	public Object executeThirdPartyProcesure(Class clz, String sql, Object[] objects) {

		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);

		if (clz != null) {
			query.setResultTransformer(Transformers.aliasToBean(clz));
		} else {
			// query.setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
			query.setResultTransformer(AliasToEntityLinkedHashMapResultTransformer.INSTANCE);
		}

		for (int i = 0; i < objects.length; i++) {
			query.setParameter(i, objects[i]);
		}

		Object result = query.list();

		return result;
	}

}
