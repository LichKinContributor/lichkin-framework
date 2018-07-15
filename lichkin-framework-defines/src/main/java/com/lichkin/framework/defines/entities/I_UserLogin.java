package com.lichkin.framework.defines.entities;

/**
 * 用户登录接口
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public interface I_UserLogin extends I_Login {

	/**
	 * 获取用户ID
	 * @return 用户ID
	 */
	public String getUserId();


	/**
	 * 设置用户ID
	 * @param userId 用户ID
	 */
	public void setUserId(String userId);


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
	 * 获取邮箱
	 * @return 邮箱
	 */
	public String getEmail();


	/**
	 * 设置邮箱
	 * @param email 邮箱
	 */
	public void setEmail(String email);


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
