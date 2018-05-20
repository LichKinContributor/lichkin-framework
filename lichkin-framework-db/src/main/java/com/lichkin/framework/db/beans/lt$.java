package com.lichkin.framework.db.beans;

/**
 * SQL语句 -> 小于
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class lt$ extends ExpCompare {

	/**
	 * 构造方法
	 * @param leftColumnResId 左边列资源ID
	 * @param rightColumnResId 右边列资源ID
	 */
	public lt$(int leftColumnResId, int rightColumnResId) {
		super(leftColumnResId, LT, rightColumnResId);
	}

}
