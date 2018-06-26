package com.lichkin.framework.db.beans;

/**
 * SQL语句 -&gt; NOT IN
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class notIn extends ExpIn {

	/**
	 * 构造方法
	 * @param columnResId 列资源ID
	 * @param paramsStr 参数。使用LKFrameworkStatics.SPLITOR作为分隔符。
	 */
	public notIn(int columnResId, String paramsStr) {
		this(0, columnResId, paramsStr);
	}


	/**
	 * 构造方法
	 * @param tableIdx 表索引
	 * @param columnResId 列资源ID
	 * @param paramsStr 参数。使用LKFrameworkStatics.SPLITOR作为分隔符。
	 */
	public notIn(int tableIdx, int columnResId, String paramsStr) {
		super(tableIdx, false, columnResId, paramsStr);
	}

}
