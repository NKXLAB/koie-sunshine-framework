package com.shine.io;

public class IOManager {
	private static IOManager manager = null;

	public static IOManager getManager() {
		if (manager == null)
			manager = new IOManager();
		return manager;
	}
	
	
}
