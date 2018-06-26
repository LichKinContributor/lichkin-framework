package com.lichkin.framework.db.beans;

import com.lichkin.framework.db.enums.LikeType;

/**
 * SQL语句 -&gt; LIKE
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class like extends ExpLike {

	/**
	 * 构造方法
	 * @param columnResId 列资源ID
	 * @param likeType LIKE表达式类型
	 * @param param 参数
	 */
	public like(int columnResId, LikeType likeType, String param) {
		this(0, columnResId, likeType, param);
	}


	/**
	 * 构造方法
	 * @param tableIdx 表索引
	 * @param columnResId 列资源ID
	 * @param likeType LIKE表达式类型
	 * @param param 参数
	 */
	public like(int tableIdx, int columnResId, LikeType likeType, String param) {
		super(tableIdx, true, columnResId, likeType, param);
	}

}
