package com.lichkin.framework.db.beans;

/**
 * SQL语句 -> IS NOT NULL
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class isNotNull extends ExpNull {

	/**
	 * 构造方法
	 * @param columnResId 列资源ID
	 */
	public isNotNull(int columnResId) {
		super(false, columnResId);
	}

}
