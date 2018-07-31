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
 * 
 * @author Garima Joshi This class is to define all the Methods to perform
 *         operations on Database
 */
@Repository
@SuppressWarnings("rawtypes")
public class GenericDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private SessionFactory sessionFactoryConfig;

	@Autowired
	private SessionFactory sessionFactoryMetaData;

	@Autowired
	private SessionFactory sessionFactoryLogs;

	@Autowired
	private SessionFactory sessionFactoryHsql;

	/**
	 * save() method use for save the data in database
	 */
	public Object save(Object object) throws Exception {
		try {

			Object obj = sessionFactory.getCurrentSession().save(object);

			return obj;
		} catch (Exception exception) {
			throw exception;
		}

	}

	/**
	 * update() method use for update row the data in database
	 */
	public Object update(Object object) throws Exception {
		try {
			sessionFactory.getCurrentSession().update(object);

			return true;
		} catch (Exception exception) {
			throw exception;
		}

	}

	/**
	 * saveAndUpdate() method use for save and update row in database
	 */
	public Object saveAndUpdate(Object object) throws Exception {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(object);

			return true;
		} catch (Exception exception) {
			throw exception;
		}

	}

	/**
	 * saveOrUpdateAll() method use for save and update all data in database
	 */
	public Object saveOrUpdateAll(Collection collection) throws Exception {
		try {

			for (Object object : collection) {
				sessionFactory.getCurrentSession().saveOrUpdate(object);

			}
			return true;
		} catch (Exception exception) {
			throw exception;
		}

	}

	/**
	 * delete() method use for delete data in database
	 */
	public Object delete(Object object) throws Exception {
		try {
			sessionFactory.getCurrentSession().delete(object);
			return true;
		} catch (Exception exception) {
			throw exception;
		}

	}

	/**
	 * findAll() method use for find all data in database
	 */
	public Object findAll(Class clz) throws Exception {
		try {

			Criteria criteria = sessionFactory.getCurrentSession().createCriteria(clz);

			Object object = criteria.list();

			return object;
		} catch (Exception exception) {
			throw exception;
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
		} catch (Exception exception) {
			throw exception;
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
		} catch (Exception exception) {
			throw exception;
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
		} catch (Exception exception) {
			throw exception;
		}

	}

	/**
	 * Execute the specified sql query.
	 */

	public Object executeSqlQuery(String sql) throws Exception {
		try {
			SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
			query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);

			Object results = query.list();
			return results;
		} catch (Exception exception) {
			throw exception;
		}
	}

	/**
	 * Execute the specified sql query.
	 */

	public Object executeSqlQuery(String sql, Class clz) throws Exception {
		try {

			SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
			query.addEntity(clz);
			Object results = query.list();

			return results;
		} catch (Exception exception) {
			throw exception;
		}
	}

	/**
	 * Execute the specified sql query.
	 */
	public Object executeAnySqlQuery(String sql) throws Exception {
		try {

			SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);

			Object results = query.executeUpdate();

			return results;
		} catch (Exception exception) {
			throw exception;
		}
	}

	/**
	 * Execute the specified sql query.
	 */
	public Object executeAnySqlQueryMetaData(String sql) throws Exception {
		try {

			SQLQuery query = sessionFactoryMetaData.getCurrentSession().createSQLQuery(sql);

			query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);

			Object results = query.list();
			return results;
		} catch (Exception exception) {
			throw exception;
		}
	}

	public Object executeAnySqlQueryConfigData(String sql) throws Exception {
		try {

			SQLQuery query = sessionFactoryConfig.getCurrentSession().createSQLQuery(sql);

			Object results = query.executeUpdate();

			return results;
		} catch (Exception exception) {
			// exception.printStackTrace();
			// return null;
			throw exception;
		}
	}

	/**
	 * Execute the specified query from Performance Table.
	 */
	public Object executeProcesure(Class clz, String sql, Object[] objects) throws Exception {
		try {

			/*
			 * for (int j = 0; j < objects.length; j++) {
			 * System.out.println("objects" + objects[j]); }
			 */

			System.out.println("Before dB Connection" + System.currentTimeMillis());

			Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);

			// System.out.println("query" + query);

			if (clz != null) {
				query.setResultTransformer(Transformers.aliasToBean(clz));
			} else {
				query.setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
			}

			for (int i = 0; i < objects.length; i++) {
				try {

					if (objects[i] == null) {
						query.setParameter(i, null);

					} else {
						query.setParameter(i, objects[i]);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
			// System.out.println("query.list" + query.list());
			Object result = query.list();

			
			
			System.out.println("result" + result);
			System.out.println("After dB Connection" + System.currentTimeMillis());
			// System.out.println("result" + result);
			return result;

		} catch (Exception exception) {
			throw exception;
		}
	}

	/**
	 * Execute the specified query from Config Table.
	 */
	public Object executeProcesureFromConfig(Class clz, String sql, Object[] objects) throws Exception {
		try {
			Query query = sessionFactoryConfig.getCurrentSession().createSQLQuery(sql);

			if (clz != null) {
				query.setResultTransformer(Transformers.aliasToBean(clz));
			} else {
				query.setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
			}

			for (int i = 0; i < objects.length; i++) {
				query.setParameter(i, objects[i]);
			}

			Object result = query.list();

			return result;
		} catch (Exception exception) {
			throw exception;
		}
	}

	/**
	 * Execute the specified query from Metadata Table.
	 */
	public Object executeProcesureFromMetaData(Class clz, String sql, Object[] objects) throws Exception {
		try {

			/*
			 * for (int i = 0; i < objects.length; i++) { System.out.println(
			 * "objects " + objects[i]); }
			 */
			System.out.println("Before dB Connection in Generic Metadata" + System.currentTimeMillis());
			Query query = sessionFactoryMetaData.getCurrentSession().createSQLQuery(sql);

			if (clz != null) {
				query.setResultTransformer(Transformers.aliasToBean(clz));
			} else {
				query.setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
			}

			for (int i = 0; i < objects.length; i++) {

				try {
					if (objects[i] == null) {
						query.setParameter(i, null);
					} else {
						query.setParameter(i, objects[i]);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			Object result = query.list();
			System.out.println("After dB Connection in Generic Metadata" + System.currentTimeMillis());
			return result;
		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
			// return null;
		}
	}

	public Object executeProcesureFromLogs(Class clz, String sql, Object[] objects) throws Exception {
		try {
			Query query = sessionFactoryLogs.getCurrentSession().createSQLQuery(sql);

			/*
			 * for (int i = 0; i < objects.length; i++) {
			 * System.out.println("object" + objects[i]); }
			 */

			if (clz != null) {
				query.setResultTransformer(Transformers.aliasToBean(clz));
			} else {
				query.setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
			}

			for (int i = 0; i < objects.length; i++) {

				try {
					if (objects[i] == null) {
						query.setParameter(i, null);
					} else {

						query.setParameter(i, objects[i]);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			Object result = query.list();

			return result;
		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
			// return null;
		}
	}

	public Object executeHSqlQuery(String sql) {
		try {
			SQLQuery query = sessionFactoryHsql.getCurrentSession().createSQLQuery(sql);
			System.out.println("query in dao" + query.getQueryString());
			query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);

			Object queryResult = query.executeUpdate();
			System.out.println("query list" + queryResult);

			// Object queryResult = query.list(); //
			// System.out.println("results" + queryResult);

			return queryResult;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Object executeHSqlselectQuery(String sql) {
		try {

			SQLQuery query = sessionFactoryHsql.getCurrentSession().createSQLQuery(sql);
			// query.addEntity(clz);
			Object results = query.list();

			return results;
		} catch (Exception e) {
			return null;
		}
	}

}