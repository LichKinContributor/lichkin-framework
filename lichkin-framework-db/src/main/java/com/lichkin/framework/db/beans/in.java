package com.lichkin.framework.db.beans;

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

}
