package com.shine.DBUtils.ifs;

import com.shine.DBUtils.model.DBRowModel;


public interface DBResultIf {
	public String toJson();

	public String toXml();

	public int getRowsSize();

	public DBRowModel gerRow(int i);
}
