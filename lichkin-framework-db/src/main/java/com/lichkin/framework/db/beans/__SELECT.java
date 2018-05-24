package com.lichkin.framework.db.beans;

import static com.lichkin.framework.db.beans.__SQL_STATICS.DISTINCT;
import static com.lichkin.framework.db.beans.__SQL_STATICS.SELECT;
import static com.lichkin.framework.defines.LKStringStatics.BLANK;
import static com.lichkin.framework.defines.LKStringStatics.COMMA;

import java.util.ArrayList;
import java.util.List;

/**
 * SQL语句 -&gt; SELECT
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
class __SELECT extends __SQL {

	/** 是否使用DISTINCT */
	private final boolean distinct;

	/** 列 */
	final List<__COLUMN> columns = new ArrayList<>();


	/**
	 * 构造方法
	 * @param distinct 是否使用DISTINCT
	 */
	__SELECT(boolean distinct) {
		super();
		this.distinct = distinct;
	}


	/**
	 * 添加列
	 * @param columnResIds 列资源ID
	 * @return 本对象
	 */
	__SELECT select(int... columnResIds) {
		// 不做非空判断，即无参数时就应该报错。
		for (int resId : columnResIds) {
			columns.add(new __COLUMN(resId));
		}
		return this;
	}


	@Override
	StringBuilder getSQL(boolean useSQL) {
		StringBuilder sql = new StringBuilder();
		for (int i = 0; i < columns.size(); i++) {
			__COLUMN column = columns.get(i);
			if (i == 0) {
				sql.append(SELECT);
				if (distinct) {
					sql.append(BLANK).append(DISTINCT);
				}
			} else {
				sql.append(COMMA);
			}
			sql.append(BLANK).append(column.getSQL(useSQL));
		}
		return sql;
	}

}
