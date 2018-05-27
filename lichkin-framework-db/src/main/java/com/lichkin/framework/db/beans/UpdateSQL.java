package com.lichkin.framework.db.beans;

import static com.lichkin.framework.db.beans.__SQL_STATICS.SET;
import static com.lichkin.framework.db.beans.__SQL_STATICS.UPDATE;
import static com.lichkin.framework.defines.LKStringStatics.BLANK;
import static com.lichkin.framework.defines.LKStringStatics.COMMA;

import java.util.ArrayList;
import java.util.List;

/**
 * SQL语句 -&gt; 更新语句
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class UpdateSQL extends _SQL_WITH_WHERE {

	/** 表映射类型 */
	public final Class<?> tableClazz;

	/** 更新条件表达式 */
	private final List<eq> eqs = new ArrayList<>();


	/**
	 * 构造方法（useSQL:true）
	 * @param tableClazz 表映射类型
	 */
	public UpdateSQL(Class<?> tableClazz) {
		this(true, tableClazz);
	}


	/**
	 * 构造方法
	 * @param useSQL true:SQL;false:HQL.
	 * @param tableClazz 表映射类型
	 */
	public UpdateSQL(boolean useSQL, Class<?> tableClazz) {
		super(useSQL);
		this.tableClazz = tableClazz;
	}


	/**
	 * 增加SET值
	 * @param columnResId 列资源ID
	 * @param param 参数
	 * @return 本对象
	 */
	public UpdateSQL set(int columnResId, Object param) {
		eqs.add(new eq(columnResId, param));
		return this;
	}


	@Override
	StringBuilder getSQL(boolean useSQL) {
		StringBuilder sql = new StringBuilder();

		sql.append(UPDATE).append(BLANK).append(getTableSQL(useSQL, tableClazz));
		sql.append(BLANK).append(SET);

		for (int i = 0; i < eqs.size(); i++) {
			eq eq = eqs.get(i);
			if (i != 0) {
				sql.append(COMMA);
			}
			sql.append(BLANK).append(eq.getSQL(useSQL));
		}

		if (where != null) {
			sql.append(where.getSQL(useSQL));
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
		List<Object> params = new ArrayList<>();

		for (eq eq : eqs) {
			params.add(eq.param);
		}

		if (where != null) {
			params.addAll(where.params);
		}

		return params.toArray();
	}

}
