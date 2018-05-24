package com.lichkin.framework.db.beans;

import static com.lichkin.framework.defines.LKStringStatics.BLANK;

/**
 * 排序信息对象
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class Order extends __SQL {

	/** ASC */
	private static final String ASC = "ASC";

	/** DESC */
	private static final String DESC = "DESC";

	/** 列资源ID */
	final int columnResId;

	/** 是否正序 */
	final boolean asc;


	/**
	 * 构造方法
	 * @param columnResId 列资源ID
	 * @param asc true:正序;false倒序.
	 */
	public Order(int columnResId, boolean asc) {
		super();
		this.columnResId = columnResId;
		this.asc = asc;
	}


	@Override
	StringBuilder getSQL(boolean useSQL) {
		return new StringBuilder().append(BLANK).append(getColumnSQL(useSQL, columnResId)).append(BLANK).append(asc ? ASC : DESC);
	}

}