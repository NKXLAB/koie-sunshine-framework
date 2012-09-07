package com.shine.threadPool.util;

public class SuperThread extends Thread {
	private boolean status = true;
	private boolean busy = false;
	// [type=jar/class,class=,method=,values=]
	private Object[] values;
	private int sleep = 100;

	public void run() {
		while (status) {
			try {
				if (values.length != 0 && values.length > 2) {
					busy = true;
					try {
						if (values[0].equals(ThreadMethodType.JAR)) {

						} else if (values[0].equals(ThreadMethodType.CLASS)) {

						}
					} catch (Exception ex) {
						ex.printStackTrace();
					}
					busy = false;
				} else {
					// values参数错误
				}
				this.sleep(sleep);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
