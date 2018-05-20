package com.lichkin.framework.db.beans;

import static com.lichkin.framework.defines.LKStringStatics.BLANK;

/**
 * SQL语句 -> FROM
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
class __FROM extends __SQL {

	/**
	 * 构造方法
	 * @param tableResId 表资源ID
	 */
	__FROM(int tableResId) {
		super();
		sql.append(FROM).append(BLANK);
		appendTable(tableResId);
	}


	/**
	 * 添加关联表达式
	 * @param tableResId 表资源ID
	 * @param joinType 关联类型
	 * @param condition 条件表达式
	 * @param conditions 条件表达式
	 * @return 本对象
	 */
	private __FROM appendJoin(int tableResId, String joinType, Condition condition, Condition... conditions) {
		sql.append(BLANK).append(joinType).append(BLANK);
		appendTable(tableResId);

		// 添加第一个表达式需拼接ON
		sql.append(BLANK).append(ON);
		sql.append(BLANK).append(condition.sqlWithoutCondiiton);
		params.addAll(condition.params);

		// 添加其它表达式
		for (Condition c : conditions) {
			sql.append(BLANK).append(c.sql);
			params.addAll(c.params);
		}

		return this;
	}


	/**
	 * JOIN表
	 * @param tableResId 表资源ID
	 * @param condition 条件表达式
	 * @param conditions 条件表达式
	 * @return 本对象
	 */
	__FROM join(int tableResId, Condition condition, Condition... conditions) {
		return appendJoin(tableResId, JOIN, condition, conditions);
	}


	/**
	 * LEFT JOIN表
	 * @param tableResId 表资源ID
	 * @param condition 条件表达式
	 * @param conditions 条件表达式
	 * @return 本对象
	 */
	__FROM leftJoin(int tableResId, Condition condition, Condition... conditions) {
		return appendJoin(tableResId, LEFT_JOIN, condition, conditions);
	}


	/**
	 * RIGHT JOIN表
	 * @param tableResId 表资源ID
	 * @param condition 条件表达式
	 * @param conditions 条件表达式
	 * @return 本对象
	 */
	__FROM rightJoin(int tableResId, Condition condition, Condition... conditions) {
		return appendJoin(tableResId, RIGHT_JOIN, condition, conditions);
	}


	/**
	 * FULL JOIN表
	 * @param tableResId 表资源ID
	 * @param condition 条件表达式
	 * @param conditions 条件表达式
	 * @return 本对象
	 */
	__FROM fullJoin(int tableResId, Condition condition, Condition... conditions) {
		return appendJoin(tableResId, FULL_JOIN, condition, conditions);
	}


	/**
	 * INNER JOIN表
	 * @param tableResId 表资源ID
	 * @param condition 条件表达式
	 * @param conditions 条件表达式
	 * @return 本对象
	 */
	__FROM innerJoin(int tableResId, Condition condition, Condition... conditions) {
		return appendJoin(tableResId, INNER_JOIN, condition, conditions);
	}

}
