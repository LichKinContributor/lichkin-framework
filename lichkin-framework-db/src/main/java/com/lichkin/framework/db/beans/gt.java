package com.lichkin.framework.db.beans;

/**
 * SQL语句 -> 大于
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
