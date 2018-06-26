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
		this(0, columnResId);
	}


	/**
	 * 构造方法
	 * @param tableIdx 表索引
	 * @param columnResId 列资源ID
	 */
	public isNull(int tableIdx, int columnResId) {
		super(tableIdx, true, columnResId);
	}

}
