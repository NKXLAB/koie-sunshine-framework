package com.shine.Example;

import com.shine.threadPool.ThreadPoolManager;

public class CodeThreadExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ThreadPoolManager.getManager()
				.excuteCode("System.out.println(\"123\")");

	}

}
