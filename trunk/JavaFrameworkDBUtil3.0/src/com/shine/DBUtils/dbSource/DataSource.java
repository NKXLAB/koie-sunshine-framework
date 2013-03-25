package com.shine.DBUtils.dbSource;

import com.shine.DBUtils.ifs.DBResultIf;


public interface DataSource {
	/**
	 * 初始化数据源
	 * 
	 * @param config
	 */
	public void init(String config);

	/**
	 * 重启
	 */
	public void restart();

	/**
	 * 关闭
	 */
	public void close();

	/**
	 * find命令
	 * 
	 * @param find
	 * @return
	 */
	public DBResultIf find(String find);

	/**
	 * 升级命令
	 * 
	 * @param update
	 * @return
	 */
	public int update(String update);

	/**
	 * 删除命令
	 * 
	 * @param remove
	 * @return
	 */
	public int remove(String remove);

	/**
	 * 保存命令
	 * 
	 * @param save
	 * @return
	 */
	public int save(String save);

}
