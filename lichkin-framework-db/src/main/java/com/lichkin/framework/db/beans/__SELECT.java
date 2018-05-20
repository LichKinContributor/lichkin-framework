package com.lichkin.framework.db.beans;

import static com.lichkin.framework.defines.LKStringStatics.BLANK;
import static com.lichkin.framework.defines.LKStringStatics.COMMA;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;

/**
 * SQL语句 -> SELECT
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
class __SELECT extends __SQL {

	/** 是否使用DISTINCT */
	final boolean distinct;

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


	/** 是否为第一个列 */
	private boolean first = true;


	/**
	 * 添加列
	 * @param columns 列
	 * @return 本对象
	 */
	__SELECT select(Column... columns) {
		assertFalse(ArrayUtils.isEmpty(columns));
		this.columns.addAll(Arrays.asList(columns));
		for (Column column : columns) {
			if (first) {
				first = false;
				sql.append(SELECT);
				if (distinct) {
					sql.append(BLANK).append(DISTINCT);
				}
			} else {
				sql.append(COMMA);
			}
			sql.append(BLANK).append(column.sql);
		}
		return this;
	}

}
