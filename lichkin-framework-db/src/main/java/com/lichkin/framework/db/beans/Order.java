package com.lichkin.framework.db.beans;

import static com.lichkin.framework.db.beans.__SQL_STATICS.ASC;
import static com.lichkin.framework.db.beans.__SQL_STATICS.DESC;
import static com.lichkin.framework.defines.LKStringStatics.BLANK;

/**
 * 排序信息对象
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class Order extends __COLUMN {

	/** 是否正序 */
	private final boolean asc;


	/**
	 * 构造方法
	 * @param columnResId 列资源ID
	 */
	public Order(int columnResId) {
		this(0, columnResId, true);
	}


	/**
	 * 构造方法
	 * @param columnResId 列资源ID
	 * @param asc true:正序;false:倒序.
	 */
	public Order(int columnResId, boolean asc) {
		this(0, columnResId, asc);
	}


	/**
	 * 构造方法
	 * @param tableIdx 表索引
	 * @param columnResId 列资源ID
	 */
	public Order(int tableIdx, int columnResId) {
		this(tableIdx, columnResId, true);
	}


	/**
	 * 构造方法
	 * @param tableIdx 表索引
	 * @param columnResId 列资源ID
	 * @param asc true:正序;false:倒序.
	 */
	public Order(int tableIdx, int columnResId, boolean asc) {
		super(tableIdx, columnResId);
		this.asc = asc;
	}


	@Override
	StringBuilder getSQL(boolean useSQL) {
		return new StringBuilder().append(BLANK).append(super.getSQL(useSQL)).append(BLANK).append(asc ? ASC : DESC);
	}

}