package com.lichkin.framework.defines.entities;

import com.lichkin.framework.defines.entities.suppers.LKBaseSysInterface;
import com.lichkin.framework.defines.enums.impl.LKAuthenticationEnum;
import com.lichkin.framework.defines.enums.impl.LKGenderEnum;

/**
 * 用户接口
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public interface LKUserInterface extends LKBaseSysInterface {

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
	 * 获取身份证号
	 * @return 身份证号
	 */
	public String getUserCard();


	/**
	 * 设置身份证号
	 * @param userCard 身份证号
	 */
	public void setUserCard(final String userCard);


	/**
	 * 获取性别
	 * @return 性别
	 */
	public LKGenderEnum getGender();


	/**
	 * 设置性别
	 * @param gender 性别
	 */
	public void setGender(final LKGenderEnum gender);


	/**
	 * 获取出生日期
	 * @return 出生日期
	 */
	public String getBirthday();


	/**
	 * 设置出生日期
	 * @param birthday 出生日期
	 */
	public void setBirthday(final String birthday);


	/**
	 * 获取出生地
	 * @return 出生地
	 */
	public String getBirthplace();


	/**
	 * 设置出生地
	 * @param birthplace 出生地
	 */
	public void setBirthplace(final String birthplace);


	/**
	 * 获取学位
	 * @return 学位
	 */
	public String getDegree();


	/**
	 * 设置学位
	 * @param degree 学位
	 */
	public void setDegree(final String degree);


	/**
	 * 获取学历
	 * @return 学历
	 */
	public String getEducation();


	/**
	 * 设置学历
	 * @param education 学历
	 */
	public void setEducation(final String education);


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
	public void setNation(final String nation);


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


	@Override
	public String getCheckCode();


	@Override
	public void setCheckCode(String checkCode);


	public LKAuthenticationEnum getAuthentication();


	public void setAuthentication(LKAuthenticationEnum authentication);


	/**
	 * 获取备用字段1
	 * @return 备用字段1
	 */
	public String getField1();


	/**
	 * 设置备用字段1
	 * @param field1 备用字段1
	 */
	public void setField1(String field1);


	/**
	 * 获取备用字段2
	 * @return 备用字段2
	 */
	public String getField2();


	/**
	 * 设置备用字段2
	 * @param field2 备用字段2
	 */
	public void setField2(String field2);


	/**
	 * 获取备用字段3
	 * @return 备用字段3
	 */
	public String getField3();


	/**
	 * 设置备用字段3
	 * @param field3 备用字段3
	 */
	public void setField3(String field3);

}
