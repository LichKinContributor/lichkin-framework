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
		this(0, leftColumnResId, 0, rightColumnResId);
	}


	/**
	 * 构造方法
	 * @param leftTableIdx 左边表索引
	 * @param leftColumnResId 左边列资源ID
	 * @param rightColumnResId 右边列资源ID
	 */
	public lt_(int leftTableIdx, int leftColumnResId, int rightColumnResId) {
		this(leftTableIdx, leftColumnResId, 0, rightColumnResId);
	}


	/**
	 * 构造方法
	 * @param leftTableIdx 左边表索引
	 * @param leftColumnResId 左边列资源ID
	 * @param rightTableIdx 右边表索引
	 * @param rightColumnResId 右边列资源ID
	 */
	public lt_(int leftTableIdx, int leftColumnResId, int rightTableIdx, int rightColumnResId) {
		super(leftTableIdx, leftColumnResId, LT, rightTableIdx, rightColumnResId);
	}

}
