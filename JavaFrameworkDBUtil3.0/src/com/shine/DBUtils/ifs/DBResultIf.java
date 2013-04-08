package com.shine.DBUtils.ifs;

import java.util.List;

import com.shine.DBUtils.model.DBRowModel;

public interface DBResultIf {
	public String toJson();

	public String toXml();

	public List<DBRowModel> getAllRowModel();

	public int getRowsSize();

	public DBRowModel gerRow(int i);

	public List<String> getColumnName();

	public void toCopy(DBResultIf resultIf);

	public void clean();
}
