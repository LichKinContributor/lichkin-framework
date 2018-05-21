package com.lichkin.framework.db.beans;

/**
 * SQL语句 -> IS NULL/IS NOT NULL表达式
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
class ExpNull extends Exp {

	/**
	 * 构造方法
	 * @param isNull true:IS NULL; false:IS NOT NULL
	 * @param columnResId 列资源ID
	 */
	protected ExpNull(boolean isNull, int columnResId) {
		super(columnResId, isNull ? IS_NULL : IS_NOT_NULL);
	}

}
