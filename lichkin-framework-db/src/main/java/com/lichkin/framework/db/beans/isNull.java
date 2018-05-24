package com.lichkin.framework.db.beans;

/**
 * SQL语句 -&gt; IS NULL
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class isNull extends ExpNull {

	/**
	 * 构造方法
	 * @param columnResId 列资源ID
	 */
	public isNull(int columnResId) {
		super(true, columnResId);
	}

}
