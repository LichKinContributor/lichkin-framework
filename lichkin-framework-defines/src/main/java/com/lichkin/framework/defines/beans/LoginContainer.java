package com.lichkin.framework.defines.beans;

import com.lichkin.framework.defines.entities.I_Login;

/**
 * 持有登录信息的容器
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public interface LoginContainer {

	/**
	 * 获取登录信息
	 */
	public I_Login getLogin();


	/**
	 * 设置登录信息
	 * @param login 设置登录信息
	 */
	public void setLogin(I_Login login);

}
