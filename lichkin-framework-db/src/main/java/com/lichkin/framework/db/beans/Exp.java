package com.lichkin.framework.db.beans;

import static com.lichkin.framework.defines.LKStringStatics.BLANK;

/**
 * SQL语句 -> 列表达式
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
class Exp extends __COLUMN {

	/** 表达式类型 */
	private final String expressionType;


	/**
	 * 构造方法
	 * @param columnResId 列资源ID
	 * @param expressionType 表达式类型
	 */
	protected Exp(int columnResId, String expressionType) {
		super(columnResId);
		this.expressionType = expressionType;
	}


	@Override
	StringBuilder getSql(boolean useSQL) {
		return super.getSql(useSQL).append(BLANK).append(expressionType);
	}

}
