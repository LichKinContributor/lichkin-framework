package com.lichkin.framework.db.beans;

import static com.lichkin.framework.defines.LKStringStatics.BLANK;
import static com.lichkin.framework.defines.LKStringStatics.BRACKET_LEFT;
import static com.lichkin.framework.defines.LKStringStatics.BRACKET_RIGHT;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * SQL语句 -> 条件表达式语句
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class Condition extends __SQL {

	/** 参数列表 */
	private final List<Object> params = new ArrayList<>();

	/** 条件表达式 */
	private final List<Condition> conditions = new ArrayList<>();

	/** true:AND;false:OR;null:无条件。 */
	private final Boolean and;

	/** 表达式 */
	private Exp expression;


	/**
	 * 构造方法
	 * @param and true:AND;false:OR;null:无条件。
	 */
	private Condition(Boolean and) {
		this.and = and;
	}


	/**
	 * 构造方法
	 * @param and true:AND;false:OR;null:无条件。
	 * @param expression 表达式
	 */
	public Condition(Boolean and, Exp expression) {
		this(and);
		this.expression = expression;
		if (expression instanceof ExpCompare) {
			if (((ExpCompare) expression).isWithParam()) {
				params.add(((ExpCompare) expression).getParam());
			}
		} else if (expression instanceof ExpIn) {
			params.addAll(((ExpIn) expression).getParams());
		} else if (expression instanceof ExpLike) {
			params.add(((ExpLike) expression).getParam());
		}
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
		this.conditions.add(condition1);
		this.conditions.add(condition2);
		this.conditions.addAll(Arrays.asList(conditions));
	}


	/**
	 * 获取不包含条件的SQL语句
	 * @param useSQL true:SQL;false:HQL.
	 * @return SQL语句
	 */
	StringBuilder getSqlWithoutCondition(boolean useSQL) {
		StringBuilder sql = new StringBuilder();
		if (expression == null) {
			sql.append(BRACKET_LEFT);
			for (int i = 0; i < conditions.size(); i++) {
				Condition condition = conditions.get(0);
				if (i == 0) {
					sql.append(condition.getSqlWithoutCondition(useSQL));
				} else {
					sql.append(BLANK).append(condition.getSql(useSQL));
				}
			}
			sql.append(BRACKET_RIGHT);
		} else {
			sql.append(expression.getSql(useSQL));
		}
		return sql;
	}


	@Override
	StringBuilder getSql(boolean useSQL) {
		StringBuilder sql = new StringBuilder();
		if (and != null) {
			sql.append(and ? AND : OR).append(BLANK);
		}
		sql.append(getSqlWithoutCondition(useSQL));
		return sql;
	}


	/**
	 * 获取参数列表
	 * @return 参数列表
	 */
	List<Object> getParams() {
		List<Object> params = new ArrayList<>();
		if (expression == null) {
			for (Condition condition : conditions) {
				params.addAll(condition.getParams());
			}
		} else {
			params.addAll(this.params);
		}
		return params;
	}

}
