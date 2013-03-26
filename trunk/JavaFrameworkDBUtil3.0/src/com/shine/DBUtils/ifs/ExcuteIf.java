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
	 * @param dataSource
	 */
	public void initDataSource(DataSource dataSource);

	/**
	 * 查询操作
	 * 
	 * @param findOptions
	 */
	public void find(String... findOptions);

	/**
	 * 插入操作
	 * 
	 * @param datas
	 */
	public void save(String... datas);

	/**
	 * 删除操作
	 * 
	 * @param removeOptions
	 */
	public void remove(String... removeOptions);

	/**
	 * 更新操作
	 * 
	 * @param updateOptions
	 */
	public void update(String... updateOptions);

	public void close();
}
