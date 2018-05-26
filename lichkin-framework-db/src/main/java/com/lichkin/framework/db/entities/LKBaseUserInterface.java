package com.lichkin.framework.db.entities;

import com.lichkin.framework.defines.enums.impl.LKGenderEnum;

/**
 * 基本用户接口
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public interface LKBaseUserInterface extends LKBaseContactInfoInterface {

	/**
	 * 获取性别
	 * @return 性别
	 */
	public LKGenderEnum getGender();


	/**
	 * 设置性别
	 * @param gender 性别
	 */
	public void setGender(final LKGenderEnum gender);

}
