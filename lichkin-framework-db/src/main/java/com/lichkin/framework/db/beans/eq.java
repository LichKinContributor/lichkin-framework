package com.lichkin.framework.db.beans;

import static com.lichkin.framework.db.beans.__SQL_STATICS.EQ;

/**
 * SQL语句 -> 等于
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class eq extends ExpCompare {

	/**
	 * 构造方法
	 * @param columnResId 列资源ID
	 * @param param 参数
	 */
	public eq(int columnResId, Object param) {
		super(columnResId, EQ, param, true);
	}

}
