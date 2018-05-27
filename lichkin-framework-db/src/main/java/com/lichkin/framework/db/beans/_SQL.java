package com.lichkin.framework.db.beans;

/**
 * SQL语句
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
abstract class _SQL extends __SQL {

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
	 * 构造方法
	 * @param useSQL true:SQL;false:HQL.
	 */
	_SQL(boolean useSQL) {
		this.useSQL = useSQL;
	}


	/** SQL语句 */
	private String sql;


	/**
	 * 获取SQL语句
	 * @return SQL语句
	 * @deprecated 框架内部使用
	 */
	@Deprecated
	public String getSQL() {
		if (sql == null) {
			sql = getSQL(isUseSQL()).toString();
		}
		return sql;
	}


	/**
	 * 获取参数列表
	 * @return 参数列表
	 * @deprecated 框架内部使用
	 */
	@Deprecated
	public abstract Object[] getParams();

}
