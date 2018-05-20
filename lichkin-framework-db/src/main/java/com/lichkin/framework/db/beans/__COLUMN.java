package com.lichkin.framework.db.beans;

/**
 * SQL语句 -> 列
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
class __COLUMN extends __SQL {

	/**
	 * 构造方法
	 * @param columnResId 列资源ID
	 */
	__COLUMN(int columnResId) {
		appendColumn(columnResId);
	}

}
