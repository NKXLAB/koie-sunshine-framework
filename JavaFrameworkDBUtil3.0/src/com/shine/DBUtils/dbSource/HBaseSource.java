package com.shine.DBUtils.dbSource;

import java.sql.Connection;

import com.shine.DBUtils.ifs.DBResultIf;

public interface HBaseSource extends DataSource {
	/**
	 * 初始化HBase连接
	 * 
	 * @param dbUserName
	 * @param dbPassWord
	 * @param jdbcUrl
	 */
	public void init(String dbUserName, String dbPassWord, String jdbcUrl);

	/**
	 * 获取数据库连接
	 * 
	 * @return
	 */
	public Connection getConnection() throws Exception;

	/**
	 * 执行sql查询
	 * 
	 * @param sql
	 * @return
	 */
	public DBResultIf findSql(String sql);
}
