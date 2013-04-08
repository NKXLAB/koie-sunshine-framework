package com.shine.DBUtils.ifs;

import java.util.Map;

/**
 * 关系数据库数据操作类
 * 
 * @author Ken
 * 
 */
public interface RelationExcuteIf extends ExcuteIf {	
	public void insert(String... values);

	public void select(String... options);

	public void update(Map map, String... options);

	public void delete(String... options);
}
