package com.shine.DBUtils.ifs;

import com.shine.DBUtils.dbSource.DataSource;

public interface ExcuteIf {
	public void initDataSource(DataSource dataSource);

	public void find(String... findOptions);

	public void save(String... datas);

	public void remove(String... removeOptions);

	public void update(String... updateOptions);

	public void close();
}
