package com.lichkin.framework.db.beans;

import static com.lichkin.framework.defines.LKStringStatics.BLANK;

/**
 * SQL语句 -> 列表达式
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
class Exp extends __COLUMN {

	/**
	 * 构造方法
	 * @param columnResId 列资源ID
	 * @param expressionType 表达式类型
	 */
	Exp(int columnResId, String expressionType) {
		super(columnResId);
		sql.append(BLANK).append(expressionType);
	}

}
