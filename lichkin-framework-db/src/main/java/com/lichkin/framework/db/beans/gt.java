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
		super(columnResId, GT, param, true);
	}

}
