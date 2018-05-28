package com.lichkin.framework.db.entities;

import com.lichkin.framework.db.entities.suppers.LKBaseSysInterface;

/**
 * 用户登录接口
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public interface LKUserLoginInterface extends LKBaseSysInterface, LKExtendFields {

	/**
	 * 获取头像
	 * @return 头像
	 */
	public String getPhoto();


	/**
	 * 设置头像
	 * @param photo 头像
	 */
	public void setPhoto(final String photo);


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
	public void setCellphone(final String cellphone);


	/**
	 * 获取邮箱
	 * @return 邮箱
	 */
	public String getEmail();


	/**
	 * 设置邮箱
	 * @param email 邮箱
	 */
	public void setEmail(final String email);


	/**
	 * 获取密码
	 * @return 密码
	 */
	public String getPwd();


	/**
	 * 设置密码
	 * @param pwd 密码
	 */
	public void setPwd(String pwd);


	/**
	 * 获取验证码
	 * @return 验证码
	 */
	public String getSecurityCode();


	/**
	 * 设置验证码
	 * @param securityCode 验证码
	 */
	public void setSecurityCode(String securityCode);


	/**
	 * 获取密码错误次数
	 * @return 密码错误次数
	 */
	public Byte getErrorTimes();


	/**
	 * 设置密码错误次数
	 * @param errorTimes 密码错误次数
	 */
	public void setErrorTimes(Byte errorTimes);


	/**
	 * 获取Token
	 * @return Token
	 */
	public String getToken();


	/**
	 * 设置Token
	 * @param token Token
	 */
	public void setToken(String token);


	/**
	 * 获取微信ID
	 * @return 微信ID
	 */
	public String getWechatId();


	/**
	 * 设置微信ID
	 * @param wechatId 微信ID
	 */
	public void setWechatId(String wechatId);

}
