package com.lichkin.framework.db.beans;

import static com.lichkin.framework.db.beans.__SQL_STATICS.GTE;

/**
 * SQL语句 -> 大于等于
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class gte$ extends ExpCompare {

	/**
	 * 构造方法
	 * @param leftColumnResId 左边列资源ID
	 * @param rightColumnResId 右边列资源ID
	 */
	public gte$(int leftColumnResId, int rightColumnResId) {
		super(leftColumnResId, GTE, rightColumnResId);
	}

}
