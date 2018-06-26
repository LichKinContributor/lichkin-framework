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


	public Byte getVersionX();


	public void setVersionX(Byte versionX);


	public Byte getVersionY();


	public void setVersionY(Byte versionY);


	public Short getVersionZ();


	public void setVersionZ(Short versionZ);


	public String getToken();


	public void setToken(String token);

}
