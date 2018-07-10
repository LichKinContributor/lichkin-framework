package com.lichkin.framework.defines.entities;

/**
 * 用户登录接口
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public interface I_UserLogin extends I_Login {

	/**
	 * 获取登录名
	 * @return 登录名
	 */
	public String getLoginName();


	/**
	 * 设置登录名
	 * @param loginName 登录名
	 */
	public void setLoginName(String loginName);


	/**
	 * 获取手机号码
	 * @return 手机号码
	 */
	public String getCellphone();


	/**
	 * 设置手机号码
	 * @param cellphone 手机号码
	 */
	public void setCellphone(String cellphone);


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

}
