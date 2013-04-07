package com.shine.DBUtils.dbSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.shine.DBUtils.ifs.DBResultIf;

public interface RelationSource extends DataSource {

	/**
	 * 初始化连接池
	 * 
	 * @param dbUserName
	 * @param dbPassWord
	 * @param jdbcUrl
	 * @param driverClass
	 */
	public void init(String dbUserName, String dbPassWord, String jdbcUrl,
			String driverClass);

	/**
	 * 初始化连接池
	 * 
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
	public void init(String dbUserName, String dbPassWord, String jdbcUrl,
			String driverClass, int initSize, int minPoolSize, int maxPoolSize,
			int maxStatements, int maxIdleTime);

	/**
	 * 获取数据库连接
	 * 
	 * @return
	 */
	public Connection getConnection() throws Exception;

	/**
	 * 获取连接总数
	 * 
	 * @return
	 * @throws SQLException
	 */
	public int getNumConnection() throws SQLException;

	/**
	 * 获取空闲连接总数
	 * 
	 * @return
	 * @throws SQLException
	 */
	public int getNumIdleConection() throws SQLException;

	/**
	 * 获取繁忙连接总数
	 * 
	 * @return
	 * @throws SQLException
	 */
	public int getNumBusyConnection() throws SQLException;

	/**
	 * 检查是否可以获取连接
	 * 
	 * @return
	 * @throws SQLException
	 */
	public boolean testCheckoutConnection() throws SQLException;

	/**
	 * 执行sql查询
	 * 
	 * @param sql
	 * @return
	 */
	public DBResultIf findSql(String sql);

	/**
	 * 执行sql查询
	 * 
	 * @param sql
	 * @return
	 */
	public ResultSet findResultSql(String sql);

	/**
	 * 执行sql语句
	 * 
	 * @param sql
	 * @return
	 */
	public int excuteSql(String sql);
}
