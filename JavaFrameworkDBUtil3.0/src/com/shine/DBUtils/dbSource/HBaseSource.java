package com.shine.DBUtils.dbSource;

public interface HBaseSource extends DataSource {
	/**
	 * 初始化HBase连接
	 * 
	 * @param dbUserName
	 * @param dbPassWord
	 * @param jdbcUrl
	 */
	public void init(String dbUserName, String dbPassWord, String jdbcUrl);
}
