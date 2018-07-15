package com.lichkin.framework.db.beans;

import static com.lichkin.framework.db.beans.__SQL_STATICS.AND;
import static com.lichkin.framework.db.beans.__SQL_STATICS.OR;
import static com.lichkin.framework.defines.LKStringStatics.BLANK;
import static com.lichkin.framework.defines.LKStringStatics.BRACKET_LEFT;
import static com.lichkin.framework.defines.LKStringStatics.BRACKET_RIGHT;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * SQL语句 -&gt; 条件表达式语句
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
			if (((ExpCompare) expression).withParam) {
				params.add(((ExpCompare) expression).param);
			}
		} else if (expression instanceof ExpIn) {
			params.addAll(Arrays.asList(((ExpIn) expression).params));
		} else if (expression instanceof ExpLike) {
			params.add(((ExpLike) expression).param);
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
	 * 构造方法
	 * @param expression 表达式
	 */
	public Condition(Exp expression) {
		this(null, expression);
	}


	/**
	 * 构造方法
	 * @param condition1 条件表达式
	 * @param condition2 条件表达式
	 * @param conditions 条件表达式
	 */
	public Condition(Condition condition1, Condition condition2, Condition... conditions) {
		and = null;
		this.conditions.add(condition1);
		this.conditions.add(condition2);
		this.conditions.addAll(Arrays.asList(conditions));
	}


	/**
	 * 构造方法
	 * @param and true:AND;false:OR;null:无条件。
	 * @param leftColumnResId 左边列资源ID
	 * @param rightColumnResId 右边列资源ID
	 */
	public Condition(Boolean and, int leftColumnResId, int rightColumnResId) {
		this(and, new eq_(leftColumnResId, rightColumnResId));
	}


	/**
	 * 构造方法
	 * @param and true:AND;false:OR;null:无条件。
	 * @param leftTableIdx 左边表索引
	 * @param leftColumnResId 左边列资源ID
	 * @param rightColumnResId 右边列资源ID
	 */
	public Condition(Boolean and, int leftTableIdx, int leftColumnResId, int rightColumnResId) {
		this(and, new eq_(leftTableIdx, leftColumnResId, rightColumnResId));
	}


	/**
	 * 构造方法
	 * @param and true:AND;false:OR;null:无条件。
	 * @param leftTableIdx 左边表索引
	 * @param leftColumnResId 左边列资源ID
	 * @param rightTableIdx 右边表索引
	 * @param rightColumnResId 右边列资源ID
	 */
	public Condition(Boolean and, int leftTableIdx, int leftColumnResId, int rightTableIdx, int rightColumnResId) {
		this(and, new eq_(leftTableIdx, leftColumnResId, rightTableIdx, rightColumnResId));
	}


	/**
	 * 构造方法
	 * @param leftColumnResId 左边列资源ID
	 * @param rightColumnResId 右边列资源ID
	 */
	public Condition(int leftColumnResId, int rightColumnResId) {
		this(null, new eq_(leftColumnResId, rightColumnResId));
	}


	/**
	 * 构造方法
	 * @param leftTableIdx 左边表索引
	 * @param leftColumnResId 左边列资源ID
	 * @param rightColumnResId 右边列资源ID
	 */
	public Condition(int leftTableIdx, int leftColumnResId, int rightColumnResId) {
		this(null, new eq_(leftTableIdx, leftColumnResId, rightColumnResId));
	}


	/**
	 * 构造方法
	 * @param leftTableIdx 左边表索引
	 * @param leftColumnResId 左边列资源ID
	 * @param rightTableIdx 右边表索引
	 * @param rightColumnResId 右边列资源ID
	 */
	public Condition(int leftTableIdx, int leftColumnResId, int rightTableIdx, int rightColumnResId) {
		this(null, new eq_(leftTableIdx, leftColumnResId, rightTableIdx, rightColumnResId));
	}


	/**
	 * 获取不包含条件的SQL语句
	 * @param useSQL true:SQL;false:HQL.
	 * @return SQL语句
	 */
	StringBuilder getSQLWithoutCondition(boolean useSQL) {
		StringBuilder sql = new StringBuilder();
		if (expression == null) {
			sql.append(BRACKET_LEFT);
			for (int i = 0; i < conditions.size(); i++) {
				Condition condition = conditions.get(i);
				if (i == 0) {
					sql.append(condition.getSQLWithoutCondition(useSQL));
				} else {
					sql.append(BLANK).append(condition.getSQL(useSQL));
				}
			}
			sql.append(BRACKET_RIGHT);
		} else {
			sql.append(expression.getSQL(useSQL));
		}
		return sql;
	}


	@Override
	StringBuilder getSQL(boolean useSQL) {
		StringBuilder sql = new StringBuilder();
		if (and != null) {
			sql.append(and ? AND : OR).append(BLANK);
		}
		sql.append(getSQLWithoutCondition(useSQL));
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
