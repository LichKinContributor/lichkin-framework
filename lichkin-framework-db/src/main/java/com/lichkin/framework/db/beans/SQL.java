package com.lichkin.framework.db.beans;

import java.util.List;

/**
 * SQL语句
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
abstract class SQL extends __SQL {

	/** 是否使用SQL语句 */
	public final boolean useSQL;


	/**
	 * 构造方法
	 * @param useSQL true:SQL;false:HQL.
	 */
	protected SQL(boolean useSQL) {
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
	public SQL where(Condition... conditions) {
		where.where(conditions);
		return this;
	}


	@Override
	StringBuilder getSql(boolean useSQL) {
		return null;
	}


	/**
	 * 获取SQL语句
	 * @return SQL语句
	 */
	public abstract String getSql();


	/**
	 * 获取参数列表
	 * @return 参数列表
	 */
	public abstract List<Object> getParams();

}
