package com.lichkin.framework.db.beans;

import static com.lichkin.framework.db.beans.__SQL_STATICS.IN;
import static com.lichkin.framework.db.beans.__SQL_STATICS.NOT_IN;
import static com.lichkin.framework.db.beans.__SQL_STATICS.PLACEHOLDER;
import static com.lichkin.framework.defines.LKFrameworkStatics.SPLITOR;
import static com.lichkin.framework.defines.LKStringStatics.BRACKET_LEFT;
import static com.lichkin.framework.defines.LKStringStatics.BRACKET_RIGHT;
import static com.lichkin.framework.defines.LKStringStatics.COMMA;

/**
 * SQL语句 -&gt; IN/NOT IN表达式
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
class ExpIn extends Exp {

	/** 参数列表 */
	final String[] params;


	/**
	 * 构造方法
	 * @param in true:IN; false:NOT IN
	 * @param columnResId 列资源ID
	 * @param paramsStr 参数。使用LKFrameworkStatics.SPLITOR作为分隔符。
	 */
	protected ExpIn(boolean in, int columnResId, String paramsStr) {
		super(columnResId, in ? IN : NOT_IN);
		params = paramsStr.split(SPLITOR);
	}


	@Override
	StringBuilder getSQL(boolean useSQL) {
		StringBuilder sql = super.getSQL(useSQL);
		sql.append(BRACKET_LEFT);
		for (int i = params.length - 1; i >= 0; i--) {
			sql.append(PLACEHOLDER);
			if (i == 0) {
				sql.append(BRACKET_RIGHT);
			} else {
				sql.append(COMMA);
			}
		}
		return sql;
	}

}
