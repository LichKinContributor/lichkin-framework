package com.lichkin.framework.defines.entities;

/**
 * 管理员登录接口
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public interface I_AdminLogin extends I_Login {

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

}
