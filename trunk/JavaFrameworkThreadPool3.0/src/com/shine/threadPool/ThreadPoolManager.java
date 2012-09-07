package com.shine.threadPool;

/**
 * 线程池
 * 
 * @author Ken
 *
 */
public class ThreadPoolManager {
	private static ThreadPoolManager manager = null;

	public static ThreadPoolManager getManager() {
		if (manager == null)
			manager = new ThreadPoolManager();
		return manager;
	}
	
	
	/**
	 * 启动线程池
	 */
	public void start(){
		
	}
	
	
	
}
