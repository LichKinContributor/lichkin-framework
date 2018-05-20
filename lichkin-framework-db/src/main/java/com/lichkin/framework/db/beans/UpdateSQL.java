package com.lichkin.framework.db.beans;

import static com.lichkin.framework.defines.LKStringStatics.BLANK;
import static com.lichkin.framework.defines.LKStringStatics.COMMA;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;

/**
 * SQL语句 -> 更新语句
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class UpdateSQL extends SQL {

	/**
	 * 构造方法
	 * @param tableResId 表资源ID
	 * @param eqs 更新条件表达式
	 */
	public UpdateSQL(int tableResId) {
		super();
		sql.append(UPDATE).append(BLANK);
		appendTable(tableResId);
	}


	@Override
	public StringBuilder getSql() {
		assertFalse(where.conditions.size() == 0);
		StringBuilder sql = new StringBuilder();
		sql.append(this.sql);
		sql.append(BLANK);
		sql.append(where.sql);
		return sql;
	}


	@Override
	public List<Object> getParams() {
		List<Object> params = new ArrayList<>();
		params.addAll(this.params);
		params.addAll(where.params);
		return params;
	}


	/** 是否为第一个更新条件表达式 */
	private boolean first = true;


	/**
	 * 添加列
	 * @param eq 更新条件表达式
	 * @return 本对象
	 */
	public UpdateSQL update(eq... eqs) {
		assertFalse(ArrayUtils.isEmpty(eqs));
		for (eq eq : eqs) {
			if (first) {
				first = false;
				sql.append(BLANK).append(SET);
			} else {
				sql.append(COMMA);
			}
			sql.append(BLANK).append(eq.sql);
			params.addAll(eq.params);
		}
		return this;
	}


	@Override
	public UpdateSQL where(Condition... conditions) {
		super.where(conditions);
		return this;
	}

}
