package com.lichkin.framework.defines.entities;

/**
 * 登录接口
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public interface I_Login extends I_ID {

	/**
	 * 获取登录令牌
	 * @return 登录令牌
	 */
	public String getToken();

}
