package com.lichkin.framework.db.beans;

import static com.lichkin.framework.db.beans.__SQL_STATICS.AS;
import static com.lichkin.framework.defines.LKStringStatics.BLANK;

/**
 * SQL语句 -&gt; 列
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
class __COLUMN extends __SQL {

	/** 列资源ID */
	private final int columnResId;

	/** 列别名 */
	private String columnAlias;


	/**
	 * 构造方法
	 * @param columnResId 列资源ID
	 */
	__COLUMN(int columnResId) {
		this(columnResId, null);
	}


	/**
	 * 构造方法
	 * @param columnResId 列资源ID
	 * @param columnAlias 列别名
	 */
	__COLUMN(int columnResId, String columnAlias) {
		this.columnResId = columnResId;
		this.columnAlias = columnAlias;
	}


	@Override
	StringBuilder getSQL(boolean useSQL) {
		StringBuilder sql = getColumnSQL(useSQL, columnResId);
		if (columnAlias != null) {
			sql.append(BLANK).append(AS).append(BLANK).append(columnAlias);
		}
		return sql;
	}

}
