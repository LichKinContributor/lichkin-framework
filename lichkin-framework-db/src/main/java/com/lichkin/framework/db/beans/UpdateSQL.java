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
public class UpdateSQL extends __SQL {

	/** UPDATE */
	private static final String UPDATE = "UPDATE";

	/** SET */
	private static final String SET = "SET";

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
		this.tableResId = tableResId;
	}


	/**
	 * 添加列
	 * @param eq 更新条件表达式
	 * @return 本对象
	 */
	public UpdateSQL update(eq... eqs) {
		// 不做非空判断，即无参数时就应该报错。
		this.eqs.addAll(Arrays.asList(eqs));
		return this;
	}


	/** WHERE */
	protected final __WHERE where = new __WHERE();


	/**
	 * 添加条件表达式
	 * @param conditions 条件表达式
	 * @return 本对象
	 */
	public UpdateSQL where(Condition... conditions) {
		where.where(conditions);
		return this;
	}


	/**
	 * 添加AND条件表达式
	 * @param expression 表达式
	 * @return 本对象
	 */
	public UpdateSQL where(Exp expression) {
		where.where(expression);
		return this;
	}


	/**
	 * 获取SQL语句
	 * @return SQL语句
	 * @deprecated 框架内部使用
	 */
	@Deprecated
	public String getSQL() {
		return getSQL(true).toString();
	}


	@Override
	StringBuilder getSQL(boolean useSQL) {
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
			sql.append(BLANK).append(eq.getSQL(useSQL));
		}

		sql.append(BLANK);
		sql.append(where.getSQL(useSQL));
		return sql;
	}


	/**
	 * 获取参数列表
	 * @return 参数列表
	 * @deprecated 框架内部使用
	 */
	@Deprecated
	public Object[] getParams() {
		List<Object> params = new ArrayList<>();
		for (eq eq : eqs) {
			params.add(eq.getParam());
		}
		params.addAll(where.getParams());
		return params.toArray();
	}

}
