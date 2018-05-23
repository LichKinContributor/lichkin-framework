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
	 * @param tableClazz 表映射类型
	 */
	public QuerySQL(Class<?> tableClazz) {
		this(true, tableClazz, false);
	}


	/**
	 * 构造方法（useSQL:true）
	 * @param tableClazz 表映射类型
	 * @param distinct 是否使用DISTINCT
	 */
	public QuerySQL(Class<?> tableClazz, boolean distinct) {
		this(true, tableClazz, distinct);
	}


	/**
	 * 构造方法
	 * @param useSQL true:SQL;false:HQL.
	 * @param tableClazz 表映射类型
	 * @param distinct 是否使用DISTINCT
	 */
	public QuerySQL(boolean useSQL, Class<?> tableClazz, boolean distinct) {
		this.useSQL = useSQL;
		select = new __SELECT(distinct);
		from = new __FROM(tableClazz);
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
	 * @param tableClazz 表映射类型
	 * @param condition 条件表达式
	 * @param conditions 条件表达式
	 * @return 本对象
	 */
	public QuerySQL join(Class<?> tableClazz, Condition condition, Condition... conditions) {
		from.join(tableClazz, condition, conditions);
		return this;
	}


	/**
	 * LEFT JOIN表
	 * @param tableClazz 表映射类型
	 * @param condition 条件表达式
	 * @param conditions 条件表达式
	 * @return 本对象
	 */
	public QuerySQL leftJoin(Class<?> tableClazz, Condition condition, Condition... conditions) {
		from.leftJoin(tableClazz, condition, conditions);
		return this;
	}


	/**
	 * RIGHT JOIN表
	 * @param tableClazz 表映射类型
	 * @param condition 条件表达式
	 * @param conditions 条件表达式
	 * @return 本对象
	 */
	public QuerySQL rightJoin(Class<?> tableClazz, Condition condition, Condition... conditions) {
		from.rightJoin(tableClazz, condition, conditions);
		return this;
	}


	/**
	 * FULL JOIN表
	 * @param tableClazz 表映射类型
	 * @param condition 条件表达式
	 * @param conditions 条件表达式
	 * @return 本对象
	 */
	public QuerySQL fullJoin(Class<?> tableClazz, Condition condition, Condition... conditions) {
		from.fullJoin(tableClazz, condition, conditions);
		return this;
	}


	/**
	 * INNER JOIN表
	 * @param tableClazz 表映射类型
	 * @param condition 条件表达式
	 * @param conditions 条件表达式
	 * @return 本对象
	 */
	public QuerySQL innerJoin(Class<?> tableClazz, Condition condition, Condition... conditions) {
		from.innerJoin(tableClazz, condition, conditions);
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
