package com.lichkin.framework.db.beans;

import static com.lichkin.framework.defines.LKStringStatics.BLANK;

import java.util.ArrayList;
import java.util.List;

/**
 * SQL语句 -> 查询语句
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class QuerySQL extends _SQL {

	/**
	 * 构造方法
	 * @param tableResId 表资源ID
	 * @param distinct 是否使用DISTINCT
	 */
	public QuerySQL(int tableResId, boolean distinct) {
		this(true, tableResId, distinct);
	}


	/**
	 * 构造方法
	 * @param useSQL true:SQL;false:HQL.
	 * @param tableResId 表资源ID
	 * @param distinct 是否使用DISTINCT
	 */
	public QuerySQL(boolean useSQL, int tableResId, boolean distinct) {
		super(useSQL);
		select = new __SELECT(distinct);
		from = new __FROM(tableResId);
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


	@Deprecated
	@Override
	public String getSQL() {
		return getSQL(isUseSQL()).toString();
	}


	@Override
	StringBuilder getSQL(boolean useSQL) {
		StringBuilder sql = new StringBuilder();
		sql.append(select.getSQL(useSQL));
		sql.append(BLANK);
		sql.append(from.getSQL(useSQL));
		sql.append(BLANK);
		sql.append(where.getSQL(useSQL));
		return sql;
	}


	@Deprecated
	@Override
	public Object[] getParams() {
		List<Object> params = new ArrayList<>();
		params.addAll(select.getParams());
		params.addAll(from.getParams());
		params.addAll(where.getParams());
		return params.toArray();
	}

}
