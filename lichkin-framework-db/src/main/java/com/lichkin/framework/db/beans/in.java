package com.lichkin.framework.db.beans;

import java.util.List;

/**
 * SQL语句 -&gt; IN
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class in extends ExpIn {

	/**
	 * 构造方法
	 * @param columnResId 列资源ID
	 * @param paramsStr 参数。使用LKFrameworkStatics.SPLITOR作为分隔符。
	 */
	public in(int columnResId, String paramsStr) {
		this(0, columnResId, paramsStr);
	}


	/**
	 * 构造方法
	 * @param tableIdx 表索引
	 * @param columnResId 列资源ID
	 * @param paramsStr 参数。使用LKFrameworkStatics.SPLITOR作为分隔符。
	 */
	public in(int tableIdx, int columnResId, String paramsStr) {
		super(tableIdx, true, columnResId, paramsStr);
	}


	/**
	 * 构造方法
	 * @param columnResId 列资源ID
	 * @param paramsList 参数
	 */
	public in(int columnResId, List<String> paramsList) {
		this(0, columnResId, paramsList);
	}


	/**
	 * 构造方法
	 * @param tableIdx 表索引
	 * @param columnResId 列资源ID
	 * @param paramsList 参数
	 */
	public in(int tableIdx, int columnResId, List<String> paramsList) {
		super(tableIdx, true, columnResId, paramsList);
	}


	/**
	 * 构造方法
	 * @param columnResId 列资源ID
	 * @param paramsArr 参数
	 */
	public in(int columnResId, String[] paramsArr) {
		this(0, columnResId, paramsArr);
	}


	/**
	 * 构造方法
	 * @param tableIdx 表索引
	 * @param columnResId 列资源ID
	 * @param paramsArr 参数
	 */
	public in(int tableIdx, int columnResId, String[] paramsArr) {
		super(tableIdx, true, columnResId, paramsArr);
	}

}
