package com.shine.DBUtils.dbSourceImpl;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.shine.DBUtils.dbSource.RelationSource;
import com.shine.DBUtils.ifs.DBResultIf;
import com.shine.DBUtils.impls.DBResult;

/**
 * 关系数据库的数据源
 * 
 * @author Ken
 * 
 */
public class RelationDBSource implements RelationSource {

	private ComboPooledDataSource dataSource;

	private String dbUserName;
	private String dbPassWord;
	private String jdbcUrl;
	private String driverClass;
	// 设置初始连接池的大小
	private int initSize = 2;
	// 设置连接池的最小值
	private int minPoolSize = 1;
	// 设置连接池的最大值
	private int maxPoolSize = 10;
	// 设置连接池中的最大Statements数量
	private int maxStatements = 50;
	// 设置连接池的最大空闲时间
	private int maxIdleTime = 60;

	public RelationDBSource() {

	}

	public RelationDBSource(String dbUserName, String dbPassWord,
			String jdbcUrl, String driverClass, int initSize, int minPoolSize,
			int maxPoolSize, int maxStatements, int maxIdleTime) {
		init(dbUserName, dbPassWord, jdbcUrl, driverClass, initSize,
				minPoolSize, maxPoolSize, maxStatements, maxIdleTime);

	}

	@Override
	public void close() {
		if (dataSource != null)
			dataSource.close();

	}

	@Override
	public DBResultIf find(String find) {
		// TODO Auto-generated method stub
		return null;
	}

	private void init() {
		try {
			dataSource = new ComboPooledDataSource();
			dataSource.setUser(dbUserName);
			dataSource.setPassword(dbPassWord);
			dataSource.setJdbcUrl(jdbcUrl);
			dataSource.setDriverClass(driverClass);
			// 设置初始连接池的大小
			dataSource.setInitialPoolSize(initSize);
			// 设置连接池的最小值
			dataSource.setMinPoolSize(minPoolSize);
			// 设置连接池的最大值
			dataSource.setMaxPoolSize(maxPoolSize);
			// 设置连接池中的最大Statements数量
			dataSource.setMaxStatements(maxStatements);
			// 设置连接池的最大空闲时间
			dataSource.setMaxIdleTime(maxIdleTime);
			System.out.println("初始数据源" + jdbcUrl + "完成");
		} catch (PropertyVetoException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void init(String config) {
		// TODO Auto-generated method stub

	}

	@Override
	public int remove(String remove) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void restart() {
		if (dataSource != null) {
			dataSource.close();
		}
		dataSource = null;
		init();

	}

	@Override
	public int save(String save) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(String update) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int excuteSql(String sql) {
		int i = 0;
		Connection conn = null;
		Statement stat = null;
		try {
			conn = getConnection();
			stat = conn.createStatement();
			i = stat.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("执行失败sql:" + sql);
		} finally {
			try {
				if (stat != null)
					stat.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return i;
	}

	@Override
	public DBResultIf findSql(String sql) {
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		DBResultIf dbrsIf = null;
		try {
			conn = getConnection();
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			dbrsIf = new DBResult(rs);
			return dbrsIf;
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("执行失败sql:" + sql);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stat != null)
					stat.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public Connection getConnection() throws Exception {
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException("无法从数据源获取连接 ", e);
		}
	}

	@Override
	public int getNumBusyConnection() throws SQLException {
		return dataSource.getNumBusyConnections();
	}

	@Override
	public int getNumConnection() throws SQLException {
		return dataSource.getNumConnections();
	}

	@Override
	public int getNumIdleConection() throws SQLException {
		return dataSource.getNumIdleConnections();
	}

	@Override
	public void init(String dbUserName, String dbPassWord, String jdbcUrl,
			String driverClass) {
		this.dbUserName = dbUserName;
		this.dbPassWord = dbPassWord;
		this.jdbcUrl = jdbcUrl;
		this.driverClass = driverClass;
		init();

	}

	@Override
	public void init(String dbUserName, String dbPassWord, String jdbcUrl,
			String driverClass, int initSize, int minPoolSize, int maxPoolSize,
			int maxStatements, int maxIdleTime) {
		this.dbUserName = dbUserName;
		this.dbPassWord = dbPassWord;
		this.jdbcUrl = jdbcUrl;
		this.driverClass = driverClass;
		this.initSize = initSize;
		this.minPoolSize = minPoolSize;
		this.maxPoolSize = maxPoolSize;
		this.maxStatements = maxStatements;
		this.maxIdleTime = maxIdleTime;
		init();

	}

	@Override
	public boolean testCheckoutConnection() throws SQLException {
		return dataSource.isTestConnectionOnCheckout();
	}

}
