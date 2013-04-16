package com.shine.DBUtils.utils;

public enum SqlMethod {
	equal("="), notEqual("<>"), greater(">"), less("<"), like("like");

	private String method;

	SqlMethod(String method) {
		this.method = method;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

}
