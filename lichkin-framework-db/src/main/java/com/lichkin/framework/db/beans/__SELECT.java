package com.lichkin.framework.db.beans;

import static com.lichkin.framework.defines.LKStringStatics.BLANK;
import static com.lichkin.framework.defines.LKStringStatics.COMMA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * SQL语句 -> SELECT
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
class __SELECT extends __SQL {

	/** 是否使用DISTINCT */
	private final boolean distinct;

	/** 列 */
	final List<Column> columns = new ArrayList<>();


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
	 * @param columns 列
	 * @return 本对象
	 */
	__SELECT select(Column... columns) {
		this.columns.addAll(Arrays.asList(columns));
		return this;
	}


	@Override
	StringBuilder getSql(boolean useSQL) {
		StringBuilder sql = new StringBuilder();
		for (int i = 0; i < columns.size(); i++) {
			Column column = columns.get(i);
			if (i == 0) {
				sql.append(SELECT);
				if (distinct) {
					sql.append(BLANK).append(DISTINCT);
				}
			} else {
				sql.append(COMMA);
			}
			sql.append(BLANK).append(column.getSql(useSQL));
		}
		return sql;
	}


	public List<Object> getParams() {
		return new ArrayList<>();
	}

}
