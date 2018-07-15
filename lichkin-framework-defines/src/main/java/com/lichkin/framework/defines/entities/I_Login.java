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
