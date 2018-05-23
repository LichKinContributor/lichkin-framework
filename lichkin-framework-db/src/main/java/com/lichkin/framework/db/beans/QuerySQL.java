package com.lichkin.framework.db.beans;

import static com.lichkin.framework.defines.LKStringStatics.BLANK;

import java.util.ArrayList;
import java.util.List;

/**
 * SQL语句 -> 查询语句
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class QuerySQL extends __SQL {

	/** 是否使用SQL语句 */
	private final boolean useSQL;


	/**
	 * 是否使用SQL
	 * @return true:SQL;falseHQL.
	 * @deprecated 框架内部使用
	 */
	@Deprecated
	public boolean isUseSQL() {
		return useSQL;
	}


	/**
	 * 构造方法（useSQL:true,distinct:false）
	 * @param tableResId 表资源ID
	 */
	public QuerySQL(int tableResId) {
		this(true, tableResId, false);
	}


	/**
	 * 构造方法（useSQL:true）
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
		this.useSQL = useSQL;
		select = new __SELECT(distinct);
		from = new __FROM(tableResId);
	}


	/** SELECT */
	private final __SELECT select;


	/**
	 * 添加列
	 * @param columnResIds 列资源ID
	 * @return 本对象
	 */
	public QuerySQL select(int... columnResIds) {
		select.select(columnResIds);
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


	/** WHERE */
	protected final __WHERE where = new __WHERE();


	/**
	 * 添加条件表达式
	 * @param conditions 条件表达式
	 * @return 本对象
	 */
	public QuerySQL where(Condition... conditions) {
		where.where(conditions);
		return this;
	}


	/**
	 * 添加AND条件表达式
	 * @param expression 表达式
	 * @return 本对象
	 */
	public QuerySQL where(Exp expression) {
		where.where(expression);
		return this;
	}


	/**
	 * 获取SQL语句
	 * @return SQL语句
	 * @deprecated 框架内部使用
	 */
	@Deprecated
	public String getSQL() {
		return getSQL(useSQL).toString();
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


	/**
	 * 获取参数列表
	 * @return 参数列表
	 * @deprecated 框架内部使用
	 */
	@Deprecated
	public Object[] getParams() {
		List<Object> params = new ArrayList<>();
		params.addAll(select.getParams());
		params.addAll(from.getParams());
		params.addAll(where.getParams());
		return params.toArray();
	}

}
