package com.shine.DBUtils.impls;

import com.shine.DBUtils.dbSource.DataSource;
import com.shine.DBUtils.dbSource.RelationSource;
import com.shine.DBUtils.ifs.ExcuteIf;

public class RelationExcute extends DBResult implements ExcuteIf {

	private RelationSource dataSource = null;

	@Override
	public void close() {
		this.dataSource = null;
	}

	@Override
	public void find(String... findOptions) {
		// TODO Auto-generated method stub

	}

	@Override
	public void initDataSource(DataSource dataSource) {
		this.dataSource = (RelationSource) dataSource;

	}

	@Override
	public void remove(String... removeOptions) {
		// TODO Auto-generated method stub

	}

	@Override
	public void save(String... datas) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(String... updateOptions) {
		// TODO Auto-generated method stub

	}

}
