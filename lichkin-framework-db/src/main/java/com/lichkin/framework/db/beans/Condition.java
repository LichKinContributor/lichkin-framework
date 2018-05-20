package com.lichkin.framework.db.beans;

import static com.lichkin.framework.defines.LKStringStatics.BLANK;
import static com.lichkin.framework.defines.LKStringStatics.BRACKET_LEFT;
import static com.lichkin.framework.defines.LKStringStatics.BRACKET_RIGHT;

/**
 * SQL语句 -> 条件表达式语句
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class Condition extends __SQL {

	/** 不包含条件的SQL语句 */
	StringBuilder sqlWithoutCondiiton = new StringBuilder();


	/**
	 * 构造方法
	 * @param and true:AND;false:OR;null:无条件。
	 */
	private Condition(Boolean and) {
		super();
		if (and != null) {
			sql.append(and ? AND : OR).append(BLANK);
		}
	}


	/**
	 * 构造方法
	 * @param and true:AND;false:OR;null:无条件。
	 * @param expression 表达式
	 */
	public Condition(Boolean and, Exp expression) {
		this(and);
		sqlWithoutCondiiton.append(expression.sql);
		sql.append(sqlWithoutCondiiton);
		params.addAll(expression.params);
	}


	/**
	 * 构造方法
	 * @param and true:AND;false:OR。
	 * @param condition1 条件表达式
	 * @param condition2 条件表达式
	 * @param conditions 条件表达式
	 */
	public Condition(boolean and, Condition condition1, Condition condition2, Condition... conditions) {
		this(and);
		sqlWithoutCondiiton.append(BRACKET_LEFT);
		sqlWithoutCondiiton.append(condition1.sqlWithoutCondiiton);
		params.addAll(condition1.params);
		sqlWithoutCondiiton.append(BLANK).append(condition2.sql);
		params.addAll(condition2.params);
		for (Condition condition : conditions) {
			sqlWithoutCondiiton.append(BLANK).append(condition.sql);
			params.addAll(condition.params);
		}
		sqlWithoutCondiiton.append(BRACKET_RIGHT);
		sql.append(sqlWithoutCondiiton);
	}

}
