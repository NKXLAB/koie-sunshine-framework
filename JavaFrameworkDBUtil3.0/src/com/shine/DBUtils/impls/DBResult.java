package com.shine.DBUtils.impls;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.shine.DBUtils.ifs.DBResultIf;
import com.shine.DBUtils.model.DBRowModel;
import com.shine.framework.core.util.XmlConverUtil;
import com.shine.framework.core.util.XmlUitl;

public class DBResult extends ArrayList<DBRowModel> implements DBResultIf {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 列名集
	protected List<String> columnName = new ArrayList<String>();

	public DBResult() {
		super();
	}

	public DBResult(ResultSet rs) throws SQLException {
		super();

		setResultSet(rs);
		rs = null;
	}

	/**
	 * 导入数据集
	 * 
	 * @param rs
	 */
	public void setResultSet(ResultSet rs) throws SQLException {
		// 导入列名
		ResultSetMetaData md = rs.getMetaData();
		for (int j = 0; j < md.getColumnCount(); j++) {
			columnName.add(md.getColumnName(j + 1));
		}

		// 导入数据
		while (rs.next()) {
			DBRowModel dbRowModel = new DBRowModel();
			for (int j = 0; j < columnName.size(); j++) {
				dbRowModel.put(columnName.get(j), rs.getString(j + 1));
			}
			this.add(dbRowModel);
		}
	}

	@Override
	public DBRowModel gerRow(int i) {
		return this.gerRow(i);
	}

	@Override
	public int getRowsSize() {
		return this.size();
	}

	@Override
	public String toJson() {
		return XmlConverUtil.xmltoJson(toXml());
	}

	@Override
	public String toXml() {
		Document document = DocumentHelper.createDocument();
		Element configElement = document.addElement("nodes");

		for (int j = 0; j < this.size(); j++) {
			Element dataElement = configElement.addElement("node");
			DBRowModel dbRowModel = (DBRowModel) this.get(j);
			for (int i = 0; i < columnName.size(); i++) {
				if (dbRowModel.get(columnName.get(i)) != null) {
					if (XmlUitl.getStringType(
							(String) dbRowModel.get(columnName.get(i))).equals(
							"XML")) {
						dataElement.addElement("key").addAttribute("label",
								columnName.get(i)).add(
								XmlUitl.string2Document(
										(String) dbRowModel.get(columnName
												.get(i))).getRootElement());
					} else {
						dataElement.addElement("key").addAttribute("label",
								columnName.get(i)).setText(
								(String) dbRowModel.get(columnName.get(i)));
					}
				} else {
					dataElement.addElement(columnName.get(i));
				}
			}
		}
		return XmlUitl.doc2String(document);
	}

	@Override
	public List<DBRowModel> getAllRowModel() {
		return this;
	}

	@Override
	public List<String> getColumnName() {
		return columnName;
	}

	@Override
	public void toCopy(DBResultIf resultIf) {
		this.clean();
		this.columnName.addAll(resultIf.getColumnName());
		this.addAll(resultIf.getAllRowModel());
	}

	@Override
	public void clean() {
		this.columnName.clear();
		this.clear();
	}

}
