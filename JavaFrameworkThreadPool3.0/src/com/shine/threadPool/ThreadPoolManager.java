package com.shine.threadPool;

import com.shine.threadPool.util.ThreadPool;

/**
 * 线程池入口
 * 
 * @author viruscodecn@gmail.com
 * 
 */
public class ThreadPoolManager {
	private static ThreadPoolManager manager = null;

	private ThreadPool threadPool = null;

	public ThreadPoolManager() {
		threadPool = new ThreadPool();
		threadPool.initThreadPool();
	}

	public static ThreadPoolManager getManager() {
		if (manager == null)
			manager = new ThreadPoolManager();
		return manager;
	}

	/**
	 * 立刻用空闲线程执行指定代码
	 * 
	 * @param code
	 * @return
	 */
	public boolean excuteCode(String code) {
		try {
			this.threadPool.excuteCode(code);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 立刻用空闲线程执行指定类的指定方法
	 * 
	 * @param classPath
	 * @param method
	 * @param objects
	 * @return
	 */
	public boolean excuteReflectionValues(String classPath, String method,
			Object... objects) {
		try {
			this.threadPool.excuteReflectionValues(classPath, method, objects);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 执行指定对象的指定方法
	 * 
	 * @param objectValue
	 * @param objectMethod
	 * @param objectss
	 * @return
	 */
	public boolean excuteObjectsValue(Object objectValue, String objectMethod,
			Object... objectss) {
		try {
			this.threadPool.excuteObjectsValue(objectValue, objectMethod,
					objectss);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 删除指定id的线程
	 * 
	 * @param id
	 * @return
	 */
	public synchronized boolean removeThreadById(String id) {
		try {
			this.threadPool.remove(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 强行停止指定线程
	 * 
	 * @param id
	 * @return
	 */
	public synchronized boolean stopThreadById(String id) {
		try {
			this.threadPool.get(id).stop();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 获取线程数量
	 * 
	 * @return
	 */
	public int getThreadPoolSize() {
		return this.threadPool.size();
	}
}
