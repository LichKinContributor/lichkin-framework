package com.lichkin.framework.beans;

import com.lichkin.framework.defines.entities.I_Comp;
import com.lichkin.framework.defines.entities.I_Login;
import com.lichkin.framework.defines.entities.I_User;
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


	public void setClientType(LKClientTypeEnum clientType);


	public Byte getVersionX();


	public void setVersionX(Byte versionX);


	public Byte getVersionY();


	public void setVersionY(Byte versionY);


	public Short getVersionZ();


	public void setVersionZ(Short versionZ);


	public String getToken();


	public void setToken(String token);


	public I_Comp getComp();


	public void setComp(I_Comp comp);


	public String getCompId();


	public void setCompId(String compId);


	public I_Login getLogin();


	public void setLogin(I_Login login);


	public String getLoginId();


	public void setLoginId(String loginId);


	public I_User getUser();


	public void setUser(I_User user);


	public String getUserId();


	public void setUserId(String userId);


	public String getCompToken();


	public void setCompToken(String compToken);

}
