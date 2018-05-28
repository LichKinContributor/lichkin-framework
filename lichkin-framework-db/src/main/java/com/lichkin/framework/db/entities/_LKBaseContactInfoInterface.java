package com.lichkin.framework.db.entities;

import com.lichkin.framework.db.entities.suppers._LKBaseSysInterface;

/**
 * 基本联系方式接口
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public interface _LKBaseContactInfoInterface extends _LKBaseSysInterface, LKExtendFields {

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
	 * 获取姓名
	 * @return 姓名
	 */
	public String getUserName();


	/**
	 * 设置姓名
	 * @param userName 姓名
	 */
	public void setUserName(String userName);


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
	 * 获取电话号码
	 * @return 电话号码
	 */
	public String getTelephone1();


	/**
	 * 设置电话号码
	 * @param telephone1 电话号码
	 */
	public void setTelephone1(String telephone1);


	/**
	 * 获取电话号码
	 * @return 电话号码
	 */
	public String getTelephone2();


	/**
	 * 设置电话号码
	 * @param telephone2 电话号码
	 */
	public void setTelephone2(String telephone2);


	/**
	 * 获取电话号码
	 * @return 电话号码
	 */
	public String getTelephone3();


	/**
	 * 设置电话号码
	 * @param telephone3 电话号码
	 */
	public void setTelephone3(String telephone3);


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
	 * 获取邮箱
	 * @return 邮箱
	 */
	public String getEmail1();


	/**
	 * 设置邮箱
	 * @param email1 邮箱
	 */
	public void setEmail1(String email1);


	/**
	 * 获取邮箱
	 * @return 邮箱
	 */
	public String getEmail2();


	/**
	 * 设置邮箱
	 * @param email2 邮箱
	 */
	public void setEmail2(String email2);


	/**
	 * 获取邮箱
	 * @return 邮箱
	 */
	public String getEmail3();


	/**
	 * 设置邮箱
	 * @param email3 邮箱
	 */
	public void setEmail3(String email3);

}
