package com.shine.threadPool.util;

import java.util.HashMap;
import java.util.List;

import com.shine.threadPool.config.ThreadConfig;
import com.shine.threadPool.threads.SuperThread;

public class ThreadPool extends HashMap<String, SuperThread> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 965986777503322375L;

	/**
	 * 初始化线程池
	 */
	public void initThreadPool() {
		for (int i = 0; i < ThreadConfig.minThreadSize; i++) {
			appendSuperThread();
		}
		System.out.println("初始化线程池完成");
		System.out.println("======================");
		System.out.println("初始化结果：");
		System.out.println("初始化线程数：" + ThreadConfig.minThreadSize);
		System.out.println("最大线程数：" + ThreadConfig.maxThreadSize);
		System.out.println("======================");
	}

	/**
	 * 补充新的线程
	 * 
	 * @return
	 */
	private synchronized SuperThread appendSuperThread() {
		SuperThread superThread = new SuperThread();
		superThread.start();
		this.put("superThread" + this.size(), superThread);
		return superThread;
	}

	/**
	 * 获取线程池的空闲线程
	 * 
	 * @return
	 */
	public synchronized SuperThread getFreeThread() {
		for (SuperThread superThread : this.values()) {
			if (!superThread.isBusy())
				return superThread;
		}
		if (this.size() < ThreadConfig.maxThreadSize) {
			return appendSuperThread();
		}
		return null;
	}

	public synchronized List<SuperThread> getTagsThread() {
		return null;
	}

}
