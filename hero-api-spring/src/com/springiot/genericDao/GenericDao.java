/**
 * This package contain  class as Repository is used to call the GenericDao
 */
package com.springiot.genericDao;
/**
 * To Import Classes to access their functionality
 */
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.internal.SessionImpl;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springiot.hibernate.transform.AliasToEntityLinkedHashMapResultTransformer;
/**
 * 
 * This class use as Repository to call all
 *  Method in all possible cases to interact with Databases for
 * their different CRUD and other Functionality
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

	public Object executeProcesure(Class clz, String sql, Object[] objects) {

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

	/**
	 * executeProcesure() method is used to execute the Procesure
	 * 
	 * @param clz
	 * @param sql
	 * @param objects
	 * @return result
	 */

	public Object executeProcedureMultipleResultSet(Class clz, String sql, Object[] objects) {

		List<List<Map<String, Object>>> resultResponseList = new ArrayList<List<Map<String, Object>>>();

		try {
			/**
			 * To get Current Session
			 */
			SessionImpl sessionImpl = (SessionImpl) sessionFactory.getCurrentSession();
			/**
			 * To Make Connection
			 */
			Connection connection = sessionImpl.connection();
			CallableStatement callableStatement = null;
			System.out.println("\n connection" + connection + "\n sql" + sql);
			callableStatement = connection.prepareCall("{" + sql + " }");
			System.out.println("callableStatement:-" + callableStatement);
			
			for (int i = 0; i < objects.length; i++) {
				
				callableStatement.setString((i + 1), objects[i].toString());
			}

			boolean queryBooleanValue = callableStatement.execute();

			while (queryBooleanValue)

			{

				ResultSet queryResultSet = callableStatement.getResultSet();

				if (queryResultSet == null) {
					break;
				}

				List<Map<String, Object>> mainList = new ArrayList<Map<String, Object>>();

				ResultSetMetaData queryResultSetMetaData = queryResultSet.getMetaData();

				int columnCount = queryResultSetMetaData.getColumnCount();

				System.out.println("column Count:- " + columnCount + "===" + queryResultSet);

				while (queryResultSet.next()) {

					System.out.println("row Starting");

					Map<String, Object> map = new HashMap<String, Object>();

					for (int i = 1; i <= columnCount; i++) {
						
						if (queryResultSetMetaData.getColumnTypeName(i).equalsIgnoreCase("BIGINT")) {
							map.put(queryResultSetMetaData.getColumnName(i), queryResultSet.getInt(i));
						}
						if (queryResultSetMetaData.getColumnTypeName(i).equalsIgnoreCase("LONG")) {
							map.put(queryResultSetMetaData.getColumnName(i), queryResultSet.getLong(i));
							continue;
						}
						if (queryResultSetMetaData.getColumnTypeName(i).equalsIgnoreCase("DOUBLE")) {
							map.put(queryResultSetMetaData.getColumnName(i), queryResultSet.getDouble(i));
							continue;
						}
						if (queryResultSetMetaData.getColumnTypeName(i).equalsIgnoreCase("BOOLEAN")) {
							map.put(queryResultSetMetaData.getColumnName(i), queryResultSet.getBoolean(i));
							continue;
						}

						if (queryResultSetMetaData.getColumnTypeName(i).equalsIgnoreCase("DATETIME")) {
							map.put(queryResultSetMetaData.getColumnName(i), queryResultSet.getDate(i).getTime());
							continue;
						}

						if (queryResultSetMetaData.getColumnTypeName(i).equalsIgnoreCase("INTEGER")) {
							map.put(queryResultSetMetaData.getColumnName(i), queryResultSet.getInt(i));
							continue;
						}

						if (queryResultSetMetaData.getColumnTypeName(i).equalsIgnoreCase("VARCHAR")) {
							map.put(queryResultSetMetaData.getColumnName(i), queryResultSet.getString(i));
							continue;
						}

						if (queryResultSetMetaData.getColumnTypeName(i).equalsIgnoreCase("BIGINT")) {
							map.put(queryResultSetMetaData.getColumnName(i), queryResultSet.getInt(i));
							continue;
						}

						map.put(queryResultSetMetaData.getColumnName(i), queryResultSet.getObject(i));
					}
					mainList.add(map);

				}

				resultResponseList.add(mainList);

				queryBooleanValue = callableStatement.getMoreResults();

			}

			System.out.println(resultResponseList);

			return resultResponseList;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return resultResponseList;
	}

}
