package com.lichkin.framework.db.beans;

import static com.lichkin.framework.defines.LKStringStatics.BLANK;

/**
 * SQL语句 -> EQ/NEQ/GT/GTE/LT/LTE表达式
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
class ExpCompare extends Exp {

	/**
	 * 构造方法
	 * @param leftColumnResId 左边列资源ID
	 * @param expressionType 表达式类型
	 * @param rightColumnResId 右边列资源ID
	 */
	ExpCompare(int leftColumnResId, String expressionType, int rightColumnResId) {
		super(leftColumnResId, expressionType);
		sql.append(BLANK);
		appendColumn(rightColumnResId);
	}


	/**
	 * 构造方法
	 * @param columnResId 左边列资源ID
	 * @param expressionType 表达式类型
	 * @param param 参数
	 * @param withParam 是否带参数，本参数只为解决重载构造方法冲突。
	 */
	ExpCompare(int columnResId, String expressionType, Object param, boolean withParam) {
		super(columnResId, expressionType);
		sql.append(BLANK).append(PLACEHOLDER);
		params.add(param);
	}

}
