package com.lichkin.framework.db.beans;

import static com.lichkin.framework.defines.LKStringStatics.BLANK;
import static com.lichkin.framework.defines.LKStringStatics.PERCENT;

import com.lichkin.framework.db.enums.LikeType;

/**
 * SQL语句 -> LIKE/NOT LIKE表达式
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
class ExpLike extends Exp {

	/**
	 * 构造方法
	 * @param like true:LIKE; false:NOT LIKE
	 * @param columnResId 列资源ID
	 * @param likeType LIKE表达式类型
	 * @param param 参数
	 */
	ExpLike(boolean like, int columnResId, LikeType likeType, String param) {
		super(columnResId, like ? LIKE : NOT_LIKE);
		sql.append(BLANK).append(PLACEHOLDER);
		switch (likeType) {
			case LEFT:
				params.add(PERCENT + param);
			break;
			case RIGHT:
				params.add(param + PERCENT);
			break;
			case ALL:
				params.add(PERCENT + param + PERCENT);
			break;
		}
	}

}
