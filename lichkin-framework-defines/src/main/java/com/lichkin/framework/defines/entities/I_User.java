package com.lichkin.framework.defines.entities;

import com.lichkin.framework.defines.enums.impl.LKGenderEnum;

/**
 * 用户接口
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public interface I_User extends I_ID {

	/**
	 * 获取姓名
	 * @return 姓名
	 */
	public String getUserName();


	/**
	 * 设置姓名
	 * @param userName 姓名
	 */
	public void setUserName(String userName);


	/**
	 * 获取性别
	 * @return 性别
	 */
	public LKGenderEnum getGender();


	/**
	 * 设置性别
	 * @param gender 性别
	 */
	public void setGender(LKGenderEnum gender);

}
