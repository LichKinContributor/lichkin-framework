package com.lichkin.framework.db.beans;

import static com.lichkin.framework.defines.LKStringStatics.BLANK;
import static com.lichkin.framework.defines.LKStringStatics.COMMA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * SQL语句 -> 更新语句
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class UpdateSQL extends SQL {

	/** UPDATE */
	static final String UPDATE = "UPDATE";

	/** 表资源ID */
	private final int tableResId;

	/** 更新条件表达式 */
	private List<eq> eqs = new ArrayList<>();


	/**
	 * 构造方法
	 * @param tableResId 表资源ID
	 * @param eqs 更新条件表达式
	 */
	public UpdateSQL(int tableResId) {
		this(true, tableResId);
	}


	/**
	 * 构造方法
	 * @param useSQL true:SQL;false:HQL.
	 * @param tableResId 表资源ID
	 * @param eqs 更新条件表达式
	 */
	public UpdateSQL(boolean useSQL, int tableResId) {
		super(useSQL);
		this.tableResId = tableResId;
	}


	@Override
	public String getSql() {
		StringBuilder sql = new StringBuilder();
		sql.append(UPDATE).append(BLANK);
		sql.append(getTableSQL(useSQL, tableResId));

		for (int i = 0; i < eqs.size(); i++) {
			eq eq = eqs.get(i);
			if (i == 0) {
				sql.append(BLANK).append(SET);
			} else {
				sql.append(COMMA);
			}
			sql.append(BLANK).append(eq.getSql(useSQL));
		}

		sql.append(BLANK);
		sql.append(where.getSql(useSQL));
		return sql.toString();
	}


	@Override
	public List<Object> getParams() {
		List<Object> params = new ArrayList<>();
		for (eq eq : eqs) {
			params.add(eq.getParam());
		}
		params.addAll(where.getParams());
		return params;
	}


	/**
	 * 添加列
	 * @param eq 更新条件表达式
	 * @return 本对象
	 */
	public UpdateSQL update(eq... eqs) {
		this.eqs.addAll(Arrays.asList(eqs));
		return this;
	}


	@Override
	public UpdateSQL where(Condition... conditions) {
		super.where(conditions);
		return this;
	}

}
