package com.lichkin.framework.db.beans;

/**
 * SQL语句 -&gt; IS NOT NULL
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class isNotNull extends ExpNull {

	/**
	 * 构造方法
	 * @param columnResId 列资源ID
	 */
	public isNotNull(int columnResId) {
		this(0, columnResId);
	}


	/**
	 * 构造方法
	 * @param tableIdx 表索引
	 * @param columnResId 列资源ID
	 */
	public isNotNull(int tableIdx, int columnResId) {
		super(tableIdx, false, columnResId);
	}

}
