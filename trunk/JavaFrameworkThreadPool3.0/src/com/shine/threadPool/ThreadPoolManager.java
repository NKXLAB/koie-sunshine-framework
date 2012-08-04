package com.shine.threadPool;

public class ThreadPoolManager {
	private static ThreadPoolManager manager = null;

	public static ThreadPoolManager getManager() {
		if (manager == null)
			manager = new ThreadPoolManager();
		return manager;
	}
}
