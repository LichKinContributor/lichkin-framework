package com.lichkin.framework.db.beans;

import static com.lichkin.framework.db.beans.__SQL_STATICS.GT;

/**
 * SQL语句 -&gt; 大于
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class gt_ extends ExpCompare {

	/**
	 * 构造方法
	 * @param leftColumnResId 左边列资源ID
	 * @param rightColumnResId 右边列资源ID
	 */
	public gt_(int leftColumnResId, int rightColumnResId) {
		super(leftColumnResId, GT, rightColumnResId);
	}

}
