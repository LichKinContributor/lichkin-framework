package com.lichkin.framework.db.beans;

import static com.lichkin.framework.db.beans.__SQL_STATICS.LTE;

/**
 * SQL语句 -&gt; 小于等于
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class lte$ extends ExpCompare {

	/**
	 * 构造方法
	 * @param leftColumnResId 左边列资源ID
	 * @param rightColumnResId 右边列资源ID
	 */
	public lte$(int leftColumnResId, int rightColumnResId) {
		super(leftColumnResId, LTE, rightColumnResId);
	}

}
