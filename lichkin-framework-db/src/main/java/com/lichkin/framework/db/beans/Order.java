package com.lichkin.framework.db.beans;

import static com.lichkin.framework.defines.LKStringStatics.BLANK;

/**
 * 排序信息对象
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class Order extends __COLUMN {

	/** ASC */
	private static final String ASC = "ASC";

	/** DESC */
	private static final String DESC = "DESC";

	/** 是否正序 */
	final boolean asc;


	/**
	 * 构造方法
	 * @param columnResId 列资源ID
	 */
	public Order(int columnResId) {
		this(columnResId, true);
	}


	/**
	 * 构造方法
	 * @param columnResId 列资源ID
	 * @param asc true:正序;false倒序.
	 */
	public Order(int columnResId, boolean asc) {
		super(columnResId);
		this.asc = asc;
	}


	@Override
	StringBuilder getSQL(boolean useSQL) {
		return new StringBuilder().append(BLANK).append(super.getSQL(useSQL)).append(BLANK).append(asc ? ASC : DESC);
	}

}