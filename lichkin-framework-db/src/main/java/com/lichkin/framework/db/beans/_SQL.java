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
	protected _SQL(boolean useSQL) {
		super();
		this.useSQL = useSQL;
	}


	/** WHERE */
	protected final __WHERE where = new __WHERE();


	/**
	 * 添加条件表达式
	 * @param conditions 条件表达式
	 * @return 本对象
	 */
	public _SQL where(Condition... conditions) {
		where.where(conditions);
		return this;
	}


	/**
	 * 获取SQL语句
	 * @return SQL语句
	 * @deprecated 框架内部使用
	 */
	@Deprecated
	public abstract String getSQL();


	/**
	 * 获取参数列表
	 * @return 参数列表
	 * @deprecated 框架内部使用
	 */
	@Deprecated
	public abstract Object[] getParams();

}
