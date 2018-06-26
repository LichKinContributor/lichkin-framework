package com.lichkin.framework.db.beans;

import static com.lichkin.framework.defines.LKStringStatics.BLANK;

/**
 * SQL语句 -&gt; 列表达式
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
class Exp extends __COLUMN {

	/** 表达式类型 */
	private final String expressionType;


	/**
	 * 构造方法
	 * @param tableIdx 表索引
	 * @param columnResId 列资源ID
	 * @param expressionType 表达式类型
	 */
	Exp(int tableIdx, int columnResId, String expressionType) {
		super(tableIdx, columnResId);
		this.expressionType = expressionType;
	}


	@Override
	StringBuilder getSQL(boolean useSQL) {
		return super.getSQL(useSQL).append(BLANK).append(expressionType);
	}

}
