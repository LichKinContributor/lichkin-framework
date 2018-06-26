package com.lichkin.framework.db.beans;

import static com.lichkin.framework.db.beans.__SQL_STATICS.PLACEHOLDER;
import static com.lichkin.framework.defines.LKStringStatics.BLANK;

/**
 * SQL语句 -&gt; EQ/NEQ/GT/GTE/LT/LTE表达式
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
class ExpCompare extends Exp {

	/** 右边表索引 */
	private int rightTableIdx;

	/** 右边列资源ID */
	private int rightColumnResId;

	/** 参数 */
	Object param;

	/** 是否带参数 */
	final boolean withParam;


	/**
	 * 构造方法
	 * @param leftTableIdx 左边表索引
	 * @param leftColumnResId 左边列资源ID
	 * @param expressionType 表达式类型
	 * @param rightTableIdx 右边表索引
	 * @param rightColumnResId 右边列资源ID
	 */
	ExpCompare(int leftTableIdx, int leftColumnResId, String expressionType, int rightTableIdx, int rightColumnResId) {
		super(leftTableIdx, leftColumnResId, expressionType);
		this.rightTableIdx = rightTableIdx;
		this.rightColumnResId = rightColumnResId;
		withParam = false;
	}


	/**
	 * 构造方法
	 * @param leftTableIdx 左边表索引
	 * @param columnResId 左边列资源ID
	 * @param expressionType 表达式类型
	 * @param param 参数
	 * @param withParam 是否带参数，本参数只为解决重载构造方法冲突。
	 */
	ExpCompare(int leftTableIdx, int columnResId, String expressionType, Object param, boolean withParam) {
		super(leftTableIdx, columnResId, expressionType);
		this.param = param;
		this.withParam = true;
	}


	@Override
	StringBuilder getSQL(boolean useSQL) {
		StringBuilder sql = super.getSQL(useSQL);
		if (withParam) {
			sql.append(BLANK).append(PLACEHOLDER);
		} else {
			sql.append(BLANK);
			sql.append(getColumnSQL(useSQL, rightColumnResId, rightTableIdx));
		}
		return sql;
	}

}
