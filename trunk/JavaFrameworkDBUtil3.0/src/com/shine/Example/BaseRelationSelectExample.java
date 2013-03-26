package com.shine.Example;

import com.shine.DBUtils.DBManager;
import com.shine.DBUtils.dbSource.RelationSource;
import com.shine.DBUtils.ifs.DBResultIf;

public class BaseRelationSelectExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DBManager
				.getManager()
				.addRelationDataSource(
						"jndi/test",
						"root",
						"sunshine",
						"jdbc:mysql://127.0.0.1:3306/nms46?useUnicode=true&amp;characterEncoding=utf-8",
						"com.mysql.jdbc.Driver", 2, 1, 10, 5, 60);

		RelationSource dataSource = (RelationSource) DBManager.getManager()
				.getDataSource("jndi/test");

		DBResultIf resultIf = dataSource.findSql("select * from element");
		System.out.println(resultIf.toXml());

	}
}
