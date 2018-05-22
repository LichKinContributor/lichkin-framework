package com.lichkin.framework.db.beans;

import static com.lichkin.framework.db.beans.__SQL_STATICS.LIKE;
import static com.lichkin.framework.db.beans.__SQL_STATICS.NOT_LIKE;
import static com.lichkin.framework.db.beans.__SQL_STATICS.PLACEHOLDER;
import static com.lichkin.framework.defines.LKStringStatics.BLANK;
import static com.lichkin.framework.defines.LKStringStatics.PERCENT;

import com.lichkin.framework.db.enums.LikeType;

/**
 * SQL语句 -> LIKE/NOT LIKE表达式
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
class ExpLike extends Exp {

	/** LIKE表达式类型 */
	private final LikeType likeType;

	/** 参数 */
	private final String param;


	/**
	 * 构造方法
	 * @param like true:LIKE; false:NOT LIKE
	 * @param columnResId 列资源ID
	 * @param likeType LIKE表达式类型
	 * @param param 参数
	 */
	protected ExpLike(boolean like, int columnResId, LikeType likeType, String param) {
		super(columnResId, like ? LIKE : NOT_LIKE);
		this.likeType = likeType;
		this.param = param;
	}


	@Override
	StringBuilder getSql(boolean useSQL) {
		StringBuilder sql = super.getSql(useSQL);
		sql.append(BLANK).append(PLACEHOLDER);
		return sql;
	}


	String getParam() {
		switch (likeType) {
			case LEFT:
				return PERCENT + param;
			case RIGHT:
				return param + PERCENT;
			case ALL:
				return PERCENT + param + PERCENT;
		}
		return null;
	}

}
