package com.shine.threadPool.Example;

import com.shine.threadPool.ThreadPoolManager;

public class CodeExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StringBuffer code = new StringBuffer();
		code.append("import com.shine.threadPool.Example.test.Test;");
		code.append("Test t=new Test();");
		code.append("t.test();");
		ThreadPoolManager.getManager().excuteCode(code.toString());
	}

}
