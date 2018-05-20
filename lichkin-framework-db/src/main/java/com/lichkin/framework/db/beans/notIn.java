package com.lichkin.framework.db.beans;

/**
 * SQL语句 -> NOT IN
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class notIn extends ExpIn {

	/**
	 * 构造方法
	 * @param columnResId 列资源ID
	 * @param paramsStr 参数。使用#@#作为分隔符。
	 */
	public notIn(int columnResId, String paramsStr) {
		super(false, columnResId, paramsStr);
	}

}
