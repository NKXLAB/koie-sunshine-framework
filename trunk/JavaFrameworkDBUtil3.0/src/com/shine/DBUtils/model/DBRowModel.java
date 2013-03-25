package com.shine.DBUtils.model;

import java.util.HashMap;
import java.util.Iterator;


public class DBRowModel extends HashMap<String, String> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 获取行的值
	 * 
	 * @param key
	 * @return
	 */
	public String getString(String key) {
		if (this.get(key) == null)
			return "";
		return this.get(key);
	}
}
