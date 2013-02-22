package com.shine.threadPool.Example;

import com.shine.threadPool.ThreadPoolManager;

public class BaseCodeExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ThreadPoolManager.getManager().excuteCode("System.out.println(123)");

	}

}
