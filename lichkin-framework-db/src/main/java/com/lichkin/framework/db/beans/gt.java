package com.lichkin.framework.db.beans;

import static com.lichkin.framework.db.beans.__SQL_STATICS.GT;

/**
 * SQL语句 -&gt; 大于
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class gt extends ExpCompare {

	/**
	 * 构造方法
	 * @param columnResId 列资源ID
	 * @param param 参数
	 */
	public gt(int columnResId, Object param) {
		this(0, columnResId, param);
	}


	/**
	 * 构造方法
	 * @param tableIdx 表索引
	 * @param columnResId 列资源ID
	 * @param param 参数
	 */
	public gt(int tableIdx, int columnResId, Object param) {
		super(tableIdx, columnResId, GT, param, true);
	}

}
