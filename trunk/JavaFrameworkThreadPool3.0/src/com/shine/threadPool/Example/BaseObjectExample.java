package com.shine.threadPool.Example;

import com.shine.threadPool.ThreadPoolManager;
import com.shine.threadPool.Example.test.Test;

/**
 * object 线程调用
 * 
 * @author Ken
 * 
 */
public class BaseObjectExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Test t = new Test();
		ThreadPoolManager.getManager().excuteObjectsValue(t, "test");
		ThreadPoolManager.getManager().excuteObjectsValue(t, "test2", "thread");

	}

}
