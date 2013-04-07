package com.shine.DBUtils.impls;

import java.sql.SQLException;
import java.util.Map;

import com.shine.DBUtils.DBManager;
import com.shine.DBUtils.dbSource.DataSource;
import com.shine.DBUtils.dbSource.RelationSource;
import com.shine.DBUtils.ifs.RelationExcuteIf;

public class RelationDBExcute extends DBResult implements RelationExcuteIf {

	private RelationSource dataSource = null;
	private String table = null;

	public RelationDBExcute(String jndi, String table) {
		initDataSource(jndi, table);
	}

	@Override
	public void initDataSource(String jndi, String table) {
		initDataSource((RelationSource) DBManager.getManager().getDataSource(
				jndi), table);
	}

	@Override
	public void initDataSource(DataSource dataSource, String table) {
		this.dataSource = (RelationSource) dataSource;
		this.table = table;
	}

	@Override
	public void insert(String... values) {
		StringBuffer insertSql = new StringBuffer();
		insertSql.append("insert into ");
		insertSql.append(this.table).append(" ");
		insertSql.append("values('");
		for (String value : values) {
			insertSql.append(value);
			if (value.equals(values[values.length - 1]))
				insertSql.append("')");
			else
				insertSql.append("','");
		}
		this.dataSource.excuteSql(insertSql.toString());
		insertSql = null;
	}

	@Override
	public void select(String... options) {
		StringBuffer sql = new StringBuffer();
		sql.append("select * from where 1=1 and ");
		for (String option : options) {
			sql.append(option).append(" ");
		}
		try {
			this.setResultSet(this.dataSource.findResultSql(sql.toString()));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

		}
		sql = null;
	}

	@Override
	public void delete(String... options) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Map map, String... options) {
		// TODO Auto-generated method stub

	}
}
