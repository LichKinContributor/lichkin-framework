package com.lichkin.framework.beans;

import com.lichkin.framework.defines.enums.impl.LKClientTypeEnum;

/**
 * 接口请求基本对象类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public interface LKRequestInterface {

	public String getLocale();


	public void setLocale(String locale);


	public String getAppKey();


	public void setAppKey(String appKey);


	public LKClientTypeEnum getClientType();


	public void setClientType(String clientType);


	public byte getVersionX();


	public void setVersionX(String versionX);


	public byte getVersionY();


	public void setVersionY(String versionY);


	public short getVersionZ();


	public void setVersionZ(String versionZ);


	public String getToken();


	public void setToken(String token);

}
