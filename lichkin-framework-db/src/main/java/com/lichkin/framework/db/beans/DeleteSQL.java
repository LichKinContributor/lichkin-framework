package com.lichkin.framework.db.beans;

import static com.lichkin.framework.db.beans.__SQL_STATICS.AS;
import static com.lichkin.framework.db.beans.__SQL_STATICS.DELETE;
import static com.lichkin.framework.db.beans.__SQL_STATICS.FROM;
import static com.lichkin.framework.defines.LKStringStatics.BLANK;

/**
 * SQL语句 -&gt; 删除语句
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class DeleteSQL extends _SQL_WITH_WHERE {

	/** 表映射类型 */
	private final Class<?> tableClazz;


	/**
	 * 构造方法（useSQL:true）
	 * @param tableClazz 表映射类型
	 */
	public DeleteSQL(Class<?> tableClazz) {
		super(true);
		this.tableClazz = tableClazz;
	}


	@Override
	StringBuilder getSQL(boolean useSQL) {
		StringBuilder sql = new StringBuilder();
		String[] tableSQLs = getTableSQL(useSQL, tableClazz).toString().split(BLANK + AS + BLANK);
		sql.append(DELETE).append(BLANK).append(FROM).append(BLANK).append(tableSQLs[0].trim());
		if (where != null) {
			sql.append(where.getSQL(useSQL).toString().replaceAll(tableSQLs[1].trim() + ".", ""));
		}
		return sql;
	}


	/**
	 * 获取参数列表
	 * @return 参数列表
	 * @deprecated 框架内部使用
	 */
	@Override
	@Deprecated
	public Object[] getParams() {
		if (where != null) {
			return where.params.toArray();
		}
		return null;
	}

}
