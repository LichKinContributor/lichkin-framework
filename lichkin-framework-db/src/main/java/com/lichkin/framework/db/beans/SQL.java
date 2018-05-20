package com.lichkin.framework.db.beans;

/**
 * SQL语句
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
class SQL extends __SQL {

	/** WHERE */
	final __WHERE where = new __WHERE();


	/**
	 * 添加条件表达式
	 * @param conditions 条件表达式
	 * @return 本对象
	 */
	public SQL where(Condition... conditions) {
		where.where(conditions);
		return this;
	}

}
