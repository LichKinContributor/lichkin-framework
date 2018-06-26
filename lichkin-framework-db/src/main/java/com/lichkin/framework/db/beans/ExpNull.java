package com.lichkin.framework.db.beans;

import static com.lichkin.framework.db.beans.__SQL_STATICS.IS_NOT_NULL;
import static com.lichkin.framework.db.beans.__SQL_STATICS.IS_NULL;

/**
 * SQL语句 -&gt; IS NULL/IS NOT NULL表达式
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
class ExpNull extends Exp {

	/**
	 * 构造方法
	 * @param tableIdx 表索引
	 * @param isNull true:IS NULL; false:IS NOT NULL
	 * @param columnResId 列资源ID
	 */
	ExpNull(int tableIdx, boolean isNull, int columnResId) {
		super(tableIdx, columnResId, isNull ? IS_NULL : IS_NOT_NULL);
	}

}
