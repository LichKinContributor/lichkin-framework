package com.lichkin.framework.db.beans;

import static com.lichkin.framework.defines.LKStringStatics.BLANK;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.List;

/**
 * SQL语句 -> 查询语句
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class QuerySQL extends SQL {

	/**
	 * 构造方法
	 * @param tableResId 表资源ID
	 * @param distinct 是否使用DISTINCT
	 */
	public QuerySQL(int tableResId, boolean distinct) {
		super();
		select = new __SELECT(distinct);
		from = new __FROM(tableResId);
	}


	@Override
	public StringBuilder getSql() {
		assertFalse(select.columns.size() == 0);
		assertFalse(where.conditions.size() == 0);
		StringBuilder sql = new StringBuilder();
		sql.append(select.sql);
		sql.append(BLANK);
		sql.append(from.sql);
		sql.append(BLANK);
		sql.append(where.sql);
		return sql;
	}


	@Override
	public List<Object> getParams() {
		List<Object> params = new ArrayList<>();
		params.addAll(select.params);
		params.addAll(from.params);
		params.addAll(where.params);
		return params;
	}


	/** SELECT */
	private final __SELECT select;


	/**
	 * 添加列
	 * @param columns 列
	 * @return 本对象
	 */
	public QuerySQL select(Column... columns) {
		select.select(columns);
		return this;
	}


	/** FROM */
	private final __FROM from;


	/**
	 * JOIN表
	 * @param tableResId 表资源ID
	 * @param condition 条件表达式
	 * @param conditions 条件表达式
	 * @return 本对象
	 */
	public QuerySQL join(int tableResId, Condition condition, Condition... conditions) {
		from.join(tableResId, condition, conditions);
		return this;
	}


	/**
	 * LEFT JOIN表
	 * @param tableResId 表资源ID
	 * @param condition 条件表达式
	 * @param conditions 条件表达式
	 * @return 本对象
	 */
	public QuerySQL leftJoin(int tableResId, Condition condition, Condition... conditions) {
		from.leftJoin(tableResId, condition, conditions);
		return this;
	}


	/**
	 * RIGHT JOIN表
	 * @param tableResId 表资源ID
	 * @param condition 条件表达式
	 * @param conditions 条件表达式
	 * @return 本对象
	 */
	public QuerySQL rightJoin(int tableResId, Condition condition, Condition... conditions) {
		from.rightJoin(tableResId, condition, conditions);
		return this;
	}


	/**
	 * FULL JOIN表
	 * @param tableResId 表资源ID
	 * @param condition 条件表达式
	 * @param conditions 条件表达式
	 * @return 本对象
	 */
	public QuerySQL fullJoin(int tableResId, Condition condition, Condition... conditions) {
		from.fullJoin(tableResId, condition, conditions);
		return this;
	}


	/**
	 * INNER JOIN表
	 * @param tableResId 表资源ID
	 * @param condition 条件表达式
	 * @param conditions 条件表达式
	 * @return 本对象
	 */
	public QuerySQL innerJoin(int tableResId, Condition condition, Condition... conditions) {
		from.innerJoin(tableResId, condition, conditions);
		return this;
	}


	@Override
	public QuerySQL where(Condition... conditions) {
		super.where(conditions);
		return this;
	}

}
