package com.shine.Example;

import com.shine.threadPool.ThreadPoolManager;


/**
 * 基础反射线程执行
 * 
 * @author Ken
 * 
 */
public class BaseReflectionExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ThreadPoolManager.getManager().excuteReflectionValues(
				"com.shine.threadPool.Example.test.Test", "test");
		ThreadPoolManager.getManager().excuteReflectionValues(
				"com.shine.threadPool.Example.test.Test", "test2", "thread");

	}

}
