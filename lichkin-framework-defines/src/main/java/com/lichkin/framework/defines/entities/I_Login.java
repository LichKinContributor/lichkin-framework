package com.lichkin.framework.defines.entities;

/**
 * 登录接口
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public interface I_Login extends I_ID {

	public String getPhoto();


	public void setPhoto(String photo);


	public String getUserId();


	public void setUserId(String userId);


	public String getLoginName();


	public void setLoginName(String loginName);


	public String getCellphone();


	public void setCellphone(String cellphone);


	public String getEmail();


	public void setEmail(String email);


	public String getUserCard();


	public void setUserCard(String userCard);


	public String getPwd();


	public void setPwd(String pwd);


	public String getSecurityCode();


	public void setSecurityCode(String securityCode);


	public Byte getErrorTimes();


	public void setErrorTimes(Byte errorTimes);


	public Byte getLevel();


	public void setLevel(Byte level);


	public String getToken();


	public void setToken(String token);

}
