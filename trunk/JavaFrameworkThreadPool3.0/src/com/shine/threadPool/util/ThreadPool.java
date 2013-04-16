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

	/**
	 * 用空闲线程执行源代码
	 * 
	 * @param code
	 */
	public synchronized void excuteCode(String code) {
		for (SuperThread superThread : this.values()) {
			if (!superThread.isBusy())
				superThread.setCode(code);
		}
		if (this.size() < ThreadConfig.maxThreadSize) {
			appendSuperThread().setCode(code);
		}
	}

	/**
	 * 用空闲线程执行指定类的指定方法
	 * 
	 * @param classPath
	 * @param method
	 * @param objects
	 */
	public synchronized void excuteReflectionValues(String classPath,
			String method, Object... objects) {
		for (SuperThread superThread : this.values()) {
			if (!superThread.isBusy())
				superThread.setReflectionValues(classPath, method, objects);
		}
		if (this.size() < ThreadConfig.maxThreadSize) {
			appendSuperThread().setReflectionValues(classPath, method, objects);
		}
	}

	/**
	 * 执行指定对象的指定方法
	 * 
	 * @param objectValue
	 * @param objectMethod
	 * @param objectss
	 */
	public synchronized void excuteObjectsValue(Object objectValue,
			String objectMethod, Object... objectss) {
		for (SuperThread superThread : this.values()) {
			if (!superThread.isBusy())
				superThread
						.setObjectsValue(objectValue, objectMethod, objectss);
		}
		if (this.size() < ThreadConfig.maxThreadSize) {
			appendSuperThread().setObjectsValue(objectValue, objectMethod,
					objectss);
		}
	}

}
