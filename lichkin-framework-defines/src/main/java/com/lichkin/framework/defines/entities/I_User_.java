package com.lichkin.framework.defines.entities;

/**
 * 用户接口
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public interface I_User_ extends I_User {

	/**
	 * 获取身份证号
	 * @return 身份证号
	 */
	public String getUserCard();


	/**
	 * 设置身份证号
	 * @param userCard 身份证号
	 */
	public void setUserCard(String userCard);


	/**
	 * 获取生日
	 * @return 生日
	 */
	public String getBirthday();


	/**
	 * 设置生日
	 * @param birthday 生日
	 */
	public void setBirthday(String birthday);

}
