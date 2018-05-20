package com.lichkin.framework.db.beans;

/**
 * SQL语句 -> 等于
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class eq$ extends ExpCompare {

	/**
	 * 构造方法
	 * @param leftColumnResId 左边列资源ID
	 * @param rightColumnResId 右边列资源ID
	 */
	public eq$(int leftColumnResId, int rightColumnResId) {
		super(leftColumnResId, EQ, rightColumnResId);
	}

}
