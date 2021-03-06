package com.lichkin.framework.db.beans;

import com.lichkin.framework.db.enums.LikeType;

/**
 * SQL语句 -&gt; NOT LIKE
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class notLike extends ExpLike {

	/**
	 * 构造方法
	 * @param columnResId 列资源ID
	 * @param likeType LIKE表达式类型
	 * @param param 参数
	 */
	public notLike(int columnResId, LikeType likeType, String param) {
		this(0, columnResId, likeType, param);
	}


	/**
	 * 构造方法
	 * @param tableIdx 表索引
	 * @param columnResId 列资源ID
	 * @param likeType LIKE表达式类型
	 * @param param 参数
	 */
	public notLike(int tableIdx, int columnResId, LikeType likeType, String param) {
		super(tableIdx, false, columnResId, likeType, param);
	}

}
