package com.lichkin.framework.db.beans;

import static com.lichkin.framework.db.beans.__SQL_STATICS.WHERE;
import static com.lichkin.framework.defines.LKStringStatics.BLANK;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * SQL语句 -> WHERE
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
class __WHERE extends __SQL {

	/** 条件表达式 */
	final List<Condition> conditions = new ArrayList<>();


	/**
	 * 添加条件表达式
	 * @param conditions 条件表达式
	 * @return 本对象
	 */
	__WHERE where(Condition... conditions) {
		// 不做非空判断，即无参数时就应该报错。
		this.conditions.addAll(Arrays.asList(conditions));
		return this;
	}


	/**
	 * 添加表达式
	 * @param expression 表达式
	 * @return 本对象
	 */
	__WHERE where(Exp expression) {
		// 不做非空判断，即无参数时就应该报错。
		conditions.add(new Condition(true, expression));
		return this;
	}


	@Override
	StringBuilder getSQL(boolean useSQL) {
		StringBuilder sql = new StringBuilder();
		for (int i = 0; i < conditions.size(); i++) {
			Condition condition = conditions.get(i);
			if (i == 0) {
				sql.append(WHERE).append(BLANK).append(condition.getSQLWithoutCondition(useSQL));
			} else {
				sql.append(BLANK).append(condition.getSQL(useSQL));
			}
		}
		return sql;
	}


	/**
	 * 获取参数列表
	 * @return 参数列表
	 */
	List<Object> getParams() {
		List<Object> params = new ArrayList<>();
		for (Condition condition : conditions) {
			params.addAll(condition.getParams());
		}
		return params;
	}

}
