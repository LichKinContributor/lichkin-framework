package com.lichkin.framework.db.beans;

/**
 * SQL语句 -> 小于等于
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
