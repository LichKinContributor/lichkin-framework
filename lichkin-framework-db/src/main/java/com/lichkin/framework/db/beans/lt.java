package com.lichkin.framework.db.beans;

/**
 * SQL语句 -> 小于
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class lt extends ExpCompare {

	/**
	 * 构造方法
	 * @param columnResId 列资源ID
	 * @param param 参数
	 */
	public lt(int columnResId, Object param) {
		super(columnResId, LT, param, true);
	}

}
