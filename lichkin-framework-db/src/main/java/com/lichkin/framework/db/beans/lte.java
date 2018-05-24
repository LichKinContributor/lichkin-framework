package com.lichkin.framework.db.beans;

import static com.lichkin.framework.db.beans.__SQL_STATICS.LTE;

/**
 * SQL语句 -&gt; 小于等于
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class lte extends ExpCompare {

	/**
	 * 构造方法
	 * @param columnResId 列资源ID
	 * @param param 参数
	 */
	public lte(int columnResId, Object param) {
		super(columnResId, LTE, param, true);
	}

}
