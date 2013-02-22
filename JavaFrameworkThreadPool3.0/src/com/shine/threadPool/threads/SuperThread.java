package com.shine.threadPool.threads;

import com.shine.framework.BeanshellUtil.BeanShellUtil;
import com.shine.framework.core.util.JarLoader;
import com.shine.framework.core.util.ReflectionUtil;

/**
 * 线程基类
 * 
 * @author Ken
 * 
 */
public class SuperThread extends Thread {
	// 线程标识
	private String tags = "";
	// 线程
	private boolean busy = false;
	// 线程运行状态
	private boolean threadState = true;
	// 线程修改时间
	private long sleepTime = 1000;

	// 脚本代码
	private String code = null;

	// Reflection代码
	private String classPath = null;
	private String method = null;
	private Object[] objects = null;

	// jar代码
	private String jarPath = null;
	private String jarClassPath = null;
	private String jarMethod = null;
	private Object[] jarObjects = null;

	// object代码
	private Object objectValue = null;
	private String objectMethod = null;
	private Object[] objectss = null;

	public void run() {
		while (threadState) {
			try {
				busy = true;

				try {
					if (code != null)
						excuteCode();

					if (classPath != null && method != null)
						excuteReflection();
					else {
						classPath = null;
						method = null;
						objects = null;
					}

					if (jarPath != null && jarClassPath != null
							&& jarMethod != null)
						excuteJar();
					else {
						jarPath = null;
						jarClassPath = null;
						jarMethod = null;
						jarObjects = null;
					}

					if (objectValue != null && objectMethod != null
							&& objectss != null)
						excuteObject();
					else {
						objectValue = null;
						objectMethod = null;
						objectss = null;
					}

				} catch (Exception ex) {
					ex.printStackTrace();
				}

				busy = false;
				Thread.sleep(sleepTime);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				busy = false;
			}
		}
	}

	/**
	 * 执行脚本代码
	 */
	private void excuteCode() {
		BeanShellUtil.executBeanShell(code);
		code = null;
	}

	/**
	 * 反射执行代码
	 * 
	 * @throws Exception
	 */
	private void excuteReflection() throws Exception {
		try {
			ReflectionUtil.invokeMethod(classPath, method, objects);
		} catch (Exception e) {
			throw e;
		} finally {
			classPath = null;
			method = null;
			objects = null;
		}
	}

	/**
	 * 执行jar的方法
	 * 
	 * @throws Exception
	 */
	private void excuteJar() throws Exception {
		try {
			JarLoader.executeJarClass(jarPath, jarClassPath, jarMethod,
					jarObjects);
		} catch (Exception e) {
			throw e;
		} finally {
			jarPath = null;
			jarClassPath = null;
			jarMethod = null;
			jarObjects = null;
		}
	}

	/**
	 * 执行object方法
	 * 
	 * @throws Exception
	 */
	private void excuteObject() throws Exception {
		try {
			ReflectionUtil.invokeMethod(objectValue, objectMethod, objectss);
		} catch (Exception e) {
			throw e;
		} finally {
			objectValue = null;
			objectMethod = null;
			objectss = null;
		}
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public boolean isBusy() {
		return busy;
	}

	public void setBusy(boolean busy) {
		this.busy = busy;
	}

	public boolean isThreadState() {
		return threadState;
	}

	public void setThreadState(boolean threadState) {
		this.threadState = threadState;
	}

	public long getSleepTime() {
		return sleepTime;
	}

	public void setSleepTime(long sleepTime) {
		this.sleepTime = sleepTime;
	}

	/**
	 * 注入线程执行脚本
	 * 
	 * @param code
	 */
	public void setCode(String code) {
		busy = true;
		this.code = code;
	}

	/**
	 * 注入反射脚本命令
	 * 
	 * @param classPath
	 * @param method
	 * @param objects
	 */
	public void setReflectionValues(String classPath, String method,
			Object... objects) {
		busy = true;
		this.classPath = classPath;
		this.method = method;
		this.objects = objects;
	}

	/**
	 * 注入object命令
	 * 
	 * @param objectValue
	 * @param objectMethod
	 * @param objectss
	 */
	public void setObjectsValue(Object objectValue, String objectMethod,
			Object... objectss) {
		busy = true;
		this.objectValue = objectValue;
		this.objectMethod = objectMethod;
		this.objectss = objectss;
	}

	/**
	 * 注入jar执行命令
	 * 
	 * @param jarPath
	 * @param jarClassPath
	 * @param jarMethod
	 * @param jarObjects
	 */
	public void setJarValues(String jarPath, String jarClassPath,
			String jarMethod, Object... jarObjects) {
		busy = true;
		this.jarPath = jarPath;
		this.jarClassPath = jarClassPath;
		this.jarMethod = jarMethod;
		this.jarObjects = jarObjects;
	}

}
