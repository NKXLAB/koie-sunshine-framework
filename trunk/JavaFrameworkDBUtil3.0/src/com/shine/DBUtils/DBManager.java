package com.shine.DBUtils;

import com.shine.DBUtils.dbSource.DataSource;

public class DBManager {
	private static DBManager manager = null;

	public static DBManager getManager() {
		if (manager == null)
			manager = new DBManager();
		return manager;
	}

	public void addDBConfig(String configPath) {

	}

	public DataSource getDataSource() {
		return null;
	}
}
