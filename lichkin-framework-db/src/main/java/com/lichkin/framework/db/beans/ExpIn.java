package com.lichkin.framework.db.beans;

import static com.lichkin.framework.defines.LKFrameworkStatics.SPLITOR;
import static com.lichkin.framework.defines.LKStringStatics.BRACKET_LEFT;
import static com.lichkin.framework.defines.LKStringStatics.BRACKET_RIGHT;
import static com.lichkin.framework.defines.LKStringStatics.COMMA;

import java.util.Arrays;
import java.util.List;

/**
 * SQL语句 -> IN/NOT IN表达式
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
class ExpIn extends Exp {

	/**
	 * 构造方法
	 * @param in true:IN; false:NOT IN
	 * @param columnResId 列资源ID
	 * @param paramsStr 参数。使用#@#作为分隔符。
	 */
	ExpIn(boolean in, int columnResId, String paramsStr) {
		super(columnResId, in ? IN : NOT_IN);
		sql.append(BRACKET_LEFT);
		List<String> params = Arrays.asList(paramsStr.split(SPLITOR));
		for (int i = params.size() - 1; i >= 0; i--) {
			sql.append(PLACEHOLDER);
			if (i == 0) {
				sql.append(BRACKET_RIGHT);
			} else {
				sql.append(COMMA);
			}
		}
		this.params.addAll(params);
	}

}
