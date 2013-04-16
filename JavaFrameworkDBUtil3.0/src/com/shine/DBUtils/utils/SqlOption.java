package com.shine.DBUtils.utils;


public enum SqlOption {
	and("and"), or("or");

	private String option;

	private SqlOption(String option) {
		this.option = option;
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

}
