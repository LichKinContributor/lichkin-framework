package com.lichkin.framework.db.beans;

/**
 * SQL语句 -> 不等于
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class neq$ extends ExpCompare {

	/**
	 * 构造方法
	 * @param leftColumnResId 左边列资源ID
	 * @param rightColumnResId 右边列资源ID
	 */
	public neq$(int leftColumnResId, int rightColumnResId) {
		super(leftColumnResId, NEQ, rightColumnResId);
	}

}
