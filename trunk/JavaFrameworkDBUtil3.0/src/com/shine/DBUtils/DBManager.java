package com.shine.DBUtils;

import com.shine.DBUtils.dbSource.DataSource;
import com.shine.DBUtils.dbSource.RelationSource;
import com.shine.DBUtils.dbSourceImpl.RelationDBSource;
import com.shine.DBUtils.utils.DataSourceMap;

/**
 * 数据管理
 * 
 * @author Ken
 * @email viruscodecn@gmail.com
 */
public class DBManager {
	private static DBManager manager = null;

	private DataSourceMap map = new DataSourceMap();

	public static DBManager getManager() {
		if (manager == null)
			manager = new DBManager();

		return manager;
	}

	public void addDBConfig(String configPath) {

	}

	/**
	 * 加入关系型数据库
	 * 
	 * @param jndi
	 * @param dbUserName
	 * @param dbPassWord
	 * @param jdbcUrl
	 * @param driverClass
	 * @param initSize
	 * @param minPoolSize
	 * @param maxPoolSize
	 * @param maxStatements
	 * @param maxIdleTime
	 */
	public void addRelationDataSource(String jndi, String dbUserName,
			String dbPassWord, String jdbcUrl, String driverClass,
			int initSize, int minPoolSize, int maxPoolSize, int maxStatements,
			int maxIdleTime) {
		RelationSource dataSource = new RelationDBSource(dbUserName,
				dbPassWord, jdbcUrl, driverClass, initSize, minPoolSize,
				maxPoolSize, maxStatements, maxIdleTime);
		map.put(jndi, dataSource);
		dataSource = null;
	}

	/**
	 * 获取数据源
	 * 
	 * @param jndi
	 * @return
	 */
	public DataSource getDataSource(String jndi) {
		return map.get(jndi);
	}
}
