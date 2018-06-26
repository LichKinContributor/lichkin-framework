package com.lichkin.framework.db.entities;

import com.lichkin.framework.defines.enums.impl.LKAuthenticationEnum;

/**
 * 用户接口
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public interface _LKUserInterface extends _LKBaseUserInterface {

	/**
	 * 获取身份证号
	 * @return 身份证号
	 */
	public String getUserCard();


	/**
	 * 设置身份证号
	 * @param userCard 身份证号
	 */
	public void setUserCard(final String userCard);


	/**
	 * 获取出生日期
	 * @return 出生日期
	 */
	public String getBirthday();


	/**
	 * 设置出生日期
	 * @param birthday 出生日期
	 */
	public void setBirthday(final String birthday);


	/**
	 * 获取出生地
	 * @return 出生地
	 */
	public String getBirthplace();


	/**
	 * 设置出生地
	 * @param birthplace 出生地
	 */
	public void setBirthplace(final String birthplace);


	/**
	 * 获取学位
	 * @return 学位
	 */
	public String getDegree();


	/**
	 * 设置学位
	 * @param degree 学位
	 */
	public void setDegree(final String degree);


	/**
	 * 获取学历
	 * @return 学历
	 */
	public String getEducation();


	/**
	 * 设置学历
	 * @param education 学历
	 */
	public void setEducation(final String education);


	/**
	 * 获取婚姻状态
	 * @return 婚姻状态
	 */
	public String getMaritalStatus();


	/**
	 * 设置婚姻状态
	 * @param maritalStatus 婚姻状态
	 */
	public void setMaritalStatus(String maritalStatus);


	/**
	 * 获取民族
	 * @return 民族
	 */
	public String getNation();


	/**
	 * 设置民族
	 * @param nation 民族
	 */
	public void setNation(final String nation);


	/**
	 * 获取实名认证等级
	 * @return 实名认证等级
	 */
	public LKAuthenticationEnum getAuthentication();


	/**
	 * 设置实名认证等级
	 * @param authentication 实名认证等级
	 */
	public void setAuthentication(LKAuthenticationEnum authentication);

}
