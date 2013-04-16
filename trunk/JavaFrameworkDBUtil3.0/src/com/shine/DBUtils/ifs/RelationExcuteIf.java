package com.shine.DBUtils.ifs;

import java.util.Map;

import com.shine.DBUtils.utils.SqlOption;

/**
 * 关系数据库数据操作类
 * 
 * @author Ken
 * 
 */
public interface RelationExcuteIf extends ExcuteIf {
	public void appendSqlOptions(String options);

	public String getSqlOption();

	public void removeSqlOption();

	public void putOptions(SqlOption sqloption, String key, String method,
			String value);

	public void insert(String... values);

	public void select(String... options);

	public void update(Map<String, String> map, String... options);

	public void delete(String... options);
}
