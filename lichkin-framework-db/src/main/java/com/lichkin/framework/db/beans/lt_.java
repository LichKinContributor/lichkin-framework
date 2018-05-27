package com.lichkin.framework.db.beans;

import static com.lichkin.framework.db.beans.__SQL_STATICS.LT;

/**
 * SQL语句 -&gt; 小于
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class lt_ extends ExpCompare {

	/**
	 * 构造方法
	 * @param leftColumnResId 左边列资源ID
	 * @param rightColumnResId 右边列资源ID
	 */
	public lt_(int leftColumnResId, int rightColumnResId) {
		super(leftColumnResId, LT, rightColumnResId);
	}

}
