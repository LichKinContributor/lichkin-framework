package com.lichkin.framework.db.beans;

/**
 * SQL语句 -> IN
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class in extends ExpIn {

	/**
	 * 构造方法
	 * @param columnResId 列资源ID
	 * @param paramsStr 参数。使用#@#作为分隔符。
	 */
	public in(int columnResId, String paramsStr) {
		super(true, columnResId, paramsStr);
	}

}
