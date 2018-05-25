package com.lichkin.framework.db.beans;

import static com.lichkin.framework.db.beans.__SQL_STATICS.FROM;
import static com.lichkin.framework.db.beans.__SQL_STATICS.FULL_JOIN;
import static com.lichkin.framework.db.beans.__SQL_STATICS.INNER_JOIN;
import static com.lichkin.framework.db.beans.__SQL_STATICS.JOIN;
import static com.lichkin.framework.db.beans.__SQL_STATICS.LEFT_JOIN;
import static com.lichkin.framework.db.beans.__SQL_STATICS.ON;
import static com.lichkin.framework.db.beans.__SQL_STATICS.RIGHT_JOIN;
import static com.lichkin.framework.defines.LKStringStatics.BLANK;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lombok.RequiredArgsConstructor;

/**
 * SQL语句 -&gt; FROM
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
class __FROM extends __SQL {

	/** 表映射类型 */
	private final Class<?> tableClazz;

	/** 关联表 */
	private final List<JoinTable> joinTables = new ArrayList<>();

	/** 参数列表 */
	List<Object> params = new ArrayList<>();


	/**
	 * 构造方法
	 * @param tableClazz 表映射类型
	 */
	__FROM(Class<?> tableClazz) {
		this.tableClazz = tableClazz;
	}


	/**
	 * 关联表
	 * @author SuZhou LichKin Information Technology Co., Ltd.
	 */
	@RequiredArgsConstructor
	private static class JoinTable {

		/** 表映射类型 */
		final Class<?> tableClazz;

		/** 关联类型 */
		final String joinType;

		/** 条件表达式 */
		List<Condition> conditions = new ArrayList<>();
	}


	/**
	 * 添加关联表达式
	 * @param tableClazz 表映射类型
	 * @param joinType 关联类型
	 * @param condition 条件表达式
	 * @param conditions 条件表达式
	 * @return 本对象
	 */
	private __FROM appendJoin(Class<?> tableClazz, String joinType, Condition condition, Condition... conditions) {
		JoinTable joinTable = new JoinTable(tableClazz, joinType);
		joinTable.conditions.add(condition);
		params.addAll(condition.getParams());
		joinTable.conditions.addAll(Arrays.asList(conditions));
		for (Condition c : conditions) {
			params.addAll(c.getParams());
		}
		joinTables.add(joinTable);
		return this;
	}


	/**
	 * JOIN表
	 * @param tableClazz 表映射类型
	 * @param condition 条件表达式
	 * @param conditions 条件表达式
	 * @return 本对象
	 */
	__FROM join(Class<?> tableClazz, Condition condition, Condition... conditions) {
		return appendJoin(tableClazz, JOIN, condition, conditions);
	}


	/**
	 * LEFT JOIN表
	 * @param tableClazz 表映射类型
	 * @param condition 条件表达式
	 * @param conditions 条件表达式
	 * @return 本对象
	 */
	__FROM leftJoin(Class<?> tableClazz, Condition condition, Condition... conditions) {
		return appendJoin(tableClazz, LEFT_JOIN, condition, conditions);
	}


	/**
	 * RIGHT JOIN表
	 * @param tableClazz 表映射类型
	 * @param condition 条件表达式
	 * @param conditions 条件表达式
	 * @return 本对象
	 */
	__FROM rightJoin(Class<?> tableClazz, Condition condition, Condition... conditions) {
		return appendJoin(tableClazz, RIGHT_JOIN, condition, conditions);
	}


	/**
	 * FULL JOIN表
	 * @param tableClazz 表映射类型
	 * @param condition 条件表达式
	 * @param conditions 条件表达式
	 * @return 本对象
	 */
	__FROM fullJoin(Class<?> tableClazz, Condition condition, Condition... conditions) {
		return appendJoin(tableClazz, FULL_JOIN, condition, conditions);
	}


	/**
	 * INNER JOIN表
	 * @param tableClazz 表映射类型
	 * @param condition 条件表达式
	 * @param conditions 条件表达式
	 * @return 本对象
	 */
	__FROM innerJoin(Class<?> tableClazz, Condition condition, Condition... conditions) {
		return appendJoin(tableClazz, INNER_JOIN, condition, conditions);
	}


	@Override
	StringBuilder getSQL(boolean useSQL) {
		StringBuilder sql = new StringBuilder();
		sql.append(FROM).append(BLANK);
		sql.append(getTableSQL(useSQL, tableClazz));

		for (JoinTable joinTable : joinTables) {
			sql.append(BLANK).append(joinTable.joinType).append(BLANK);
			sql.append(getTableSQL(useSQL, joinTable.tableClazz));

			List<Condition> conditions = joinTable.conditions;
			for (int j = 0; j < conditions.size(); j++) {
				Condition condition = conditions.get(j);
				if (j == 0) {
					sql.append(BLANK).append(ON);
					sql.append(BLANK).append(condition.getSQLWithoutCondition(useSQL));
				} else {
					sql.append(BLANK).append(condition.getSQL(useSQL));
				}
			}
		}
		return sql;
	}


	/**
	 * 获取主表别名
	 * @return 主表别名
	 */
	String getMainTableAlias() {
		return LKDBResource.getTableResource(tableClazz).getTableAlias();
	}

}
