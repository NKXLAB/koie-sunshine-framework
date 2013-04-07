package com.shine.DBUtils.ifs;

import com.shine.DBUtils.dbSource.DataSource;

/**
 * 具有持久化操作特性的数据接口
 * 
 * @author Ken
 * 
 */
public interface ExcuteIf {

	/**
	 * 初始化持数据源
	 * 
	 * @param jndi
	 * @param table
	 */
	public void initDataSource(String jndi, String table);

	/**
	 * 初始化持数据源
	 * 
	 * @param dataSource
	 * @param table
	 */
	public void initDataSource(DataSource dataSource, String table);
}
