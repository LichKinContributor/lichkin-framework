package com.lichkin.framework.db.beans;

import static com.lichkin.framework.defines.LKStringStatics.BLANK;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lombok.RequiredArgsConstructor;

/**
 * SQL语句 -> FROM
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
class __FROM extends __SQL {

	/** 表资源ID */
	private final int tableResId;

	/** 关联表 */
	private final List<JoinTable> joinTables = new ArrayList<>();


	/**
	 * 构造方法
	 * @param tableResId 表资源ID
	 */
	__FROM(int tableResId) {
		super();
		this.tableResId = tableResId;
	}


	/**
	 * 关联表
	 * @author SuZhou LichKin Information Technology Co., Ltd.
	 */
	@RequiredArgsConstructor
	private static class JoinTable {

		/** 表资源ID */
		final int tableResId;

		/** 关联类型 */
		final String joinType;

		/** 条件表达式 */
		List<Condition> conditions = new ArrayList<>();
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
		JoinTable joinTable = new JoinTable(tableResId, joinType);
		joinTable.conditions.add(condition);
		joinTable.conditions.addAll(Arrays.asList(conditions));
		joinTables.add(joinTable);
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


	@Override
	StringBuilder getSql(boolean useSQL) {
		StringBuilder sql = new StringBuilder();
		sql.append(FROM).append(BLANK);
		sql.append(getTableSQL(useSQL, tableResId));

		for (JoinTable joinTable : joinTables) {
			sql.append(BLANK).append(joinTable.joinType).append(BLANK);
			sql.append(getTableSQL(useSQL, joinTable.tableResId));

			List<Condition> conditions = joinTable.conditions;
			for (int j = 0; j < conditions.size(); j++) {
				Condition condition = conditions.get(j);
				if (j == 0) {
					sql.append(BLANK).append(ON);
					sql.append(BLANK).append(condition.getSqlWithoutCondition(useSQL));
				} else {
					sql.append(BLANK).append(condition.getSql(useSQL));
				}
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

		for (JoinTable joinTable : joinTables) {
			List<Condition> conditions = joinTable.conditions;
			for (Condition condition : conditions) {
				params.addAll(condition.getParams());
			}
		}

		return params;
	}

}
