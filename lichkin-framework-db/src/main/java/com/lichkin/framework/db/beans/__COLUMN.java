package com.lichkin.framework.db.beans;

/**
 * SQL语句 -> 列
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
abstract class __COLUMN extends __SQL {

	/** 列资源ID */
	private final int columnResId;


	/**
	 * 构造方法
	 * @param columnResId 列资源ID
	 */
	protected __COLUMN(int columnResId) {
		this.columnResId = columnResId;
	}


	@Override
	StringBuilder getSQL(boolean useSQL) {
		return getColumnSQL(useSQL, columnResId);
	}

}
