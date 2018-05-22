package com.lichkin.framework.db.beans;

import static com.lichkin.framework.db.beans.__SQL_STATICS.NEQ;

/**
 * SQL语句 -> 不等于
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class neq extends ExpCompare {

	/**
	 * 构造方法
	 * @param columnResId 列资源ID
	 * @param param 参数
	 */
	public neq(int columnResId, Object param) {
		super(columnResId, NEQ, param, true);
	}

}
