package com.lichkin.framework.defines.entities;

/**
 * 登录接口
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public interface I_Login extends I_ID {

	/**
	 * 获取照片
	 * @return 照片
	 */
	public String getPhoto();


	/**
	 * 设置照片
	 * @param photo 照片
	 */
	public void setPhoto(String photo);


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
	 * 获取账号等级
	 * @return 账号等级
	 */
	public Byte getLevel();


	/**
	 * 设置账号等级
	 * @param level 账号等级
	 */
	public void setLevel(Byte level);


	/**
	 * 获取登录令牌
	 * @return 登录令牌
	 */
	public String getToken();


	/**
	 * 设置登录令牌
	 * @param token 登录令牌
	 */
	public void setToken(String token);


	/**
	 * 获取锁定时间
	 * @return 锁定时间
	 */
	public String getLockTime();


	/**
	 * 设置锁定时间
	 * @param lockTime 锁定时间
	 */
	public void setLockTime(String lockTime);

}
