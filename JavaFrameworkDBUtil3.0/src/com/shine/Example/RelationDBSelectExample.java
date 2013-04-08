package com.shine.Example;

import com.shine.DBUtils.DBManager;
import com.shine.DBUtils.impls.RelationDBExcute;

public class RelationDBSelectExample {

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
						"jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&amp;characterEncoding=utf-8",
						"com.mysql.jdbc.Driver", 2, 1, 10, 5, 60);
		// 查询
		RelationDBExcute excute = new RelationDBExcute("jndi/test", "test");
		excute.select();
		System.out.println(excute.toXml());

		// 拼sql查询
		excute.select("and one='1'");
		System.out.println(excute.toXml());

	}

}
