package com.lichkin.framework.defines.entities;

import com.lichkin.framework.defines.enums.impl.LKGenderEnum;

/**
 * 用户接口
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public interface I_User extends I_ID {

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
	 * 获取生日
	 * @return 生日
	 */
	public String getBirthday();


	/**
	 * 设置生日
	 * @param birthday 生日
	 */
	public void setBirthday(String birthday);


	/**
	 * 获取性别
	 * @return 性别
	 */
	public LKGenderEnum getGender();


	/**
	 * 设置性别
	 * @param gender 性别
	 */
	public void setGender(LKGenderEnum gender);


	/**
	 * 获取出生地
	 * @return 出生地
	 */
	public String getBirthplace();


	/**
	 * 设置出生地
	 * @param birthplace 出生地
	 */
	public void setBirthplace(String birthplace);


	/**
	 * 获取学历
	 * @return 学历
	 */
	public String getDegree();


	/**
	 * 设置学历
	 * @param degree 学历
	 */
	public void setDegree(String degree);


	/**
	 * 获取学位
	 * @return 学位
	 */
	public String getEducation();


	/**
	 * 设置学位
	 * @param education 学位
	 */
	public void setEducation(String education);


	/**
	 * 获取婚姻状态
	 * @return 婚姻状态
	 */
	public String getMaritalStatus();


	/**
	 * 设置婚姻状态
	 * @param maritalStatus 婚姻状态
	 */
	public void setMaritalStatus(String maritalStatus);


	/**
	 * 获取民族
	 * @return 民族
	 */
	public String getNation();


	/**
	 * 设置民族
	 * @param nation 民族
	 */
	public void setNation(String nation);

}
