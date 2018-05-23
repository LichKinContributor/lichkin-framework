package com.lichkin.framework.db.beans;

import static com.lichkin.framework.defines.LKStringStatics.BLANK;

/**
 * SQL语句 -> 删除语句
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class DeleteSQL extends __SQL {

	/** DELETE FROM */
	private static final String DELETE_FROM = "DELETE FROM";

	/** 表映射类型 */
	private final Class<?> tableClazz;


	/**
	 * 构造方法
	 * @param tableClazz 表映射类型
	 */
	public DeleteSQL(Class<?> tableClazz) {
		this.tableClazz = tableClazz;
	}


	/** WHERE */
	protected final __WHERE where = new __WHERE();


	/**
	 * 添加条件表达式
	 * @param conditions 条件表达式
	 * @return 本对象
	 */
	public DeleteSQL where(Condition... conditions) {
		where.where(conditions);
		return this;
	}


	/**
	 * 添加AND条件表达式
	 * @param expression 表达式
	 * @return 本对象
	 */
	public DeleteSQL where(Exp expression) {
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
		return getSQL(true).toString();
	}


	@Override
	StringBuilder getSQL(boolean useSQL) {
		StringBuilder sql = new StringBuilder();
		sql.append(DELETE_FROM);
		sql.append(BLANK);
		sql.append(getTableSQL(useSQL, tableClazz));
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
		return where.getParams().toArray();
	}

}
