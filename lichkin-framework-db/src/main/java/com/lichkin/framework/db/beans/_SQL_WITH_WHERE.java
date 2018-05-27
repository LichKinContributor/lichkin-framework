package com.lichkin.framework.db.beans;

import com.lichkin.framework.db.enums.LikeType;

/**
 * 增删改查
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
abstract class _SQL_WITH_WHERE extends _SQL {

	/**
	 * 构造方法
	 * @param useSQL true:SQL;false:HQL.
	 */
	_SQL_WITH_WHERE(boolean useSQL) {
		super(useSQL);
	}


	/** WHERE */
	protected __WHERE where;


	/**
	 * 校验WHERE对象
	 * @return WHERE对象
	 */
	private __WHERE checkWhere() {
		if (where == null) {
			where = new __WHERE();
		}
		return where;
	}


	/**
	 * 添加条件表达式
	 * @param conditions 条件表达式
	 */
	public void where(Condition... conditions) {
		checkWhere().where(conditions);
	}


	/**
	 * 添加表达式（等于）
	 * @param and true:AND;false:OR;null:无条件
	 * @param columnResId 列资源ID
	 * @param param 参数
	 */
	public void eq(Boolean and, int columnResId, Object param) {
		checkWhere().eq(and, columnResId, param);
	}


	/**
	 * 添加表达式（等于）
	 * @param columnResId 列资源ID
	 * @param param 参数
	 */
	public void eq(int columnResId, Object param) {
		eq(true, columnResId, param);
	}


	/**
	 * 添加表达式（等于）
	 * @param and true:AND;false:OR;null:无条件。
	 * @param leftColumnResId 左边列资源ID
	 * @param rightColumnResId 右边列资源ID
	 */
	public void eq_(Boolean and, int leftColumnResId, int rightColumnResId) {
		checkWhere().eq_(and, leftColumnResId, rightColumnResId);
	}


	/**
	 * 添加表达式（等于）
	 * @param leftColumnResId 左边列资源ID
	 * @param rightColumnResId 右边列资源ID
	 */
	public void eq_(int leftColumnResId, int rightColumnResId) {
		eq_(true, leftColumnResId, rightColumnResId);
	}


	/**
	 * 添加表达式（不等于）
	 * @param and true:AND;false:OR;null:无条件
	 * @param columnResId 列资源ID
	 * @param param 参数
	 */
	public void neq(Boolean and, int columnResId, Object param) {
		checkWhere().neq(and, columnResId, param);
	}


	/**
	 * 添加表达式（不等于）
	 * @param columnResId 列资源ID
	 * @param param 参数
	 */
	public void neq(int columnResId, Object param) {
		neq(true, columnResId, param);
	}


	/**
	 * 添加表达式（不等于）
	 * @param and true:AND;false:OR;null:无条件。
	 * @param leftColumnResId 左边列资源ID
	 * @param rightColumnResId 右边列资源ID
	 */
	public void neq_(Boolean and, int leftColumnResId, int rightColumnResId) {
		checkWhere().neq_(and, leftColumnResId, rightColumnResId);
	}


	/**
	 * 添加表达式（不等于）
	 * @param leftColumnResId 左边列资源ID
	 * @param rightColumnResId 右边列资源ID
	 */
	public void neq_(int leftColumnResId, int rightColumnResId) {
		neq_(true, leftColumnResId, rightColumnResId);
	}


	/**
	 * 添加表达式（大于）
	 * @param and true:AND;false:OR;null:无条件
	 * @param columnResId 列资源ID
	 * @param param 参数
	 */
	public void gt(Boolean and, int columnResId, Object param) {
		checkWhere().gt(and, columnResId, param);
	}


	/**
	 * 添加表达式（大于）
	 * @param columnResId 列资源ID
	 * @param param 参数
	 */
	public void gt(int columnResId, Object param) {
		gt(true, columnResId, param);
	}


	/**
	 * 添加表达式（大于）
	 * @param and true:AND;false:OR;null:无条件。
	 * @param leftColumnResId 左边列资源ID
	 * @param rightColumnResId 右边列资源ID
	 */
	public void gt_(Boolean and, int leftColumnResId, int rightColumnResId) {
		checkWhere().gt_(and, leftColumnResId, rightColumnResId);
	}


	/**
	 * 添加表达式（大于）
	 * @param leftColumnResId 左边列资源ID
	 * @param rightColumnResId 右边列资源ID
	 */
	public void gt_(int leftColumnResId, int rightColumnResId) {
		gt_(true, leftColumnResId, rightColumnResId);
	}


	/**
	 * 添加表达式（大于等于）
	 * @param and true:AND;false:OR;null:无条件
	 * @param columnResId 列资源ID
	 * @param param 参数
	 */
	public void gte(Boolean and, int columnResId, Object param) {
		checkWhere().gte(and, columnResId, param);
	}


	/**
	 * 添加表达式（大于等于）
	 * @param columnResId 列资源ID
	 * @param param 参数
	 */
	public void gte(int columnResId, Object param) {
		gte(true, columnResId, param);
	}


	/**
	 * 添加表达式（大于等于）
	 * @param and true:AND;false:OR;null:无条件。
	 * @param leftColumnResId 左边列资源ID
	 * @param rightColumnResId 右边列资源ID
	 */
	public void gte_(Boolean and, int leftColumnResId, int rightColumnResId) {
		checkWhere().gte_(and, leftColumnResId, rightColumnResId);
	}


	/**
	 * 添加表达式（大于等于）
	 * @param leftColumnResId 左边列资源ID
	 * @param rightColumnResId 右边列资源ID
	 */
	public void gte_(int leftColumnResId, int rightColumnResId) {
		gte_(true, leftColumnResId, rightColumnResId);
	}


	/**
	 * 添加表达式（小于）
	 * @param and true:AND;false:OR;null:无条件
	 * @param columnResId 列资源ID
	 * @param param 参数
	 */
	public void lt(Boolean and, int columnResId, Object param) {
		checkWhere().lt(and, columnResId, param);
	}


	/**
	 * 添加表达式（小于）
	 * @param columnResId 列资源ID
	 * @param param 参数
	 */
	public void lt(int columnResId, Object param) {
		lt(true, columnResId, param);
	}


	/**
	 * 添加表达式（小于）
	 * @param and true:AND;false:OR;null:无条件。
	 * @param leftColumnResId 左边列资源ID
	 * @param rightColumnResId 右边列资源ID
	 */
	public void lt_(Boolean and, int leftColumnResId, int rightColumnResId) {
		checkWhere().lt_(and, leftColumnResId, rightColumnResId);
	}


	/**
	 * 添加表达式（小于）
	 * @param leftColumnResId 左边列资源ID
	 * @param rightColumnResId 右边列资源ID
	 */
	public void lt_(int leftColumnResId, int rightColumnResId) {
		lt_(true, leftColumnResId, rightColumnResId);
	}


	/**
	 * 添加表达式（小于等于）
	 * @param and true:AND;false:OR;null:无条件
	 * @param columnResId 列资源ID
	 * @param param 参数
	 */
	public void lte(Boolean and, int columnResId, Object param) {
		checkWhere().lte(and, columnResId, param);
	}


	/**
	 * 添加表达式（小于等于）
	 * @param columnResId 列资源ID
	 * @param param 参数
	 */
	public void lte(int columnResId, Object param) {
		lte(true, columnResId, param);
	}


	/**
	 * 添加表达式（小于等于）
	 * @param and true:AND;false:OR;null:无条件。
	 * @param leftColumnResId 左边列资源ID
	 * @param rightColumnResId 右边列资源ID
	 */
	public void lte_(Boolean and, int leftColumnResId, int rightColumnResId) {
		checkWhere().lte_(and, leftColumnResId, rightColumnResId);
	}


	/**
	 * 添加表达式（小于等于）
	 * @param leftColumnResId 左边列资源ID
	 * @param rightColumnResId 右边列资源ID
	 */
	public void lte_(int leftColumnResId, int rightColumnResId) {
		lte_(true, leftColumnResId, rightColumnResId);
	}


	/**
	 * 添加表达式（IN）
	 * @param and true:AND;false:OR;null:无条件。
	 * @param columnResId 列资源ID
	 * @param paramsStr 参数。使用LKFrameworkStatics.SPLITOR作为分隔符。
	 */
	public void in(Boolean and, int columnResId, String paramsStr) {
		checkWhere().in(and, columnResId, paramsStr);
	}


	/**
	 * 添加表达式（IN）
	 * @param columnResId 列资源ID
	 * @param paramsStr 参数。使用LKFrameworkStatics.SPLITOR作为分隔符。
	 */
	public void in(int columnResId, String paramsStr) {
		in(true, columnResId, paramsStr);
	}


	/**
	 * 添加表达式（NOT IN）
	 * @param and true:AND;false:OR;null:无条件。
	 * @param columnResId 列资源ID
	 * @param paramsStr 参数。使用LKFrameworkStatics.SPLITOR作为分隔符。
	 */
	public void notIn(Boolean and, int columnResId, String paramsStr) {
		checkWhere().notIn(and, columnResId, paramsStr);
	}


	/**
	 * 添加表达式（NOT IN）
	 * @param columnResId 列资源ID
	 * @param paramsStr 参数。使用LKFrameworkStatics.SPLITOR作为分隔符。
	 */
	public void notIn(int columnResId, String paramsStr) {
		notIn(true, columnResId, paramsStr);
	}


	/**
	 * 添加表达式（LIKE）
	 * @param and true:AND;false:OR;null:无条件。
	 * @param columnResId 列资源ID
	 * @param likeType LIKE表达式类型
	 * @param param 参数
	 */
	public void like(Boolean and, int columnResId, LikeType likeType, String param) {
		checkWhere().like(and, columnResId, likeType, param);
	}


	/**
	 * 添加表达式（LIKE）
	 * @param columnResId 列资源ID
	 * @param likeType LIKE表达式类型
	 * @param param 参数
	 */
	public void like(int columnResId, LikeType likeType, String param) {
		like(true, columnResId, likeType, param);
	}


	/**
	 * 添加表达式（NOT LIKE）
	 * @param and true:AND;false:OR;null:无条件。
	 * @param columnResId 列资源ID
	 * @param likeType LIKE表达式类型
	 * @param param 参数
	 */
	public void notLike(Boolean and, int columnResId, LikeType likeType, String param) {
		checkWhere().notLike(and, columnResId, likeType, param);
	}


	/**
	 * 添加表达式（NOT LIKE）
	 * @param columnResId 列资源ID
	 * @param likeType LIKE表达式类型
	 * @param param 参数
	 */
	public void notLike(int columnResId, LikeType likeType, String param) {
		notLike(true, columnResId, likeType, param);
	}


	/**
	 * 添加表达式（IS NULL）
	 * @param and true:AND;false:OR;null:无条件。
	 * @param columnResId 列资源ID
	 */
	public void isNull(Boolean and, int columnResId) {
		checkWhere().isNull(and, columnResId);
	}


	/**
	 * 添加表达式（IS NULL）
	 * @param columnResId 列资源ID
	 */
	public void isNull(int columnResId) {
		isNull(true, columnResId);
	}


	/**
	 * 添加表达式（IS NOT NULL）
	 * @param and true:AND;false:OR;null:无条件。
	 * @param columnResId 列资源ID
	 */
	public void isNotNull(Boolean and, int columnResId) {
		checkWhere().isNotNull(and, columnResId);
	}


	/**
	 * 添加表达式（IS NOT NULL）
	 * @param columnResId 列资源ID
	 */
	public void isNotNull(int columnResId) {
		isNotNull(true, columnResId);
	}

}
