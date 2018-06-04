package com.lichkin.framework.db.entities;

import com.lichkin.framework.db.entities.suppers.LKNormalInterface;

/**
 * 字典接口
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public interface LKDictionaryInterface extends LKNormalInterface {

	/**
	 * 获取类目编号
	 * @return 类目编号
	 */
	public String getCategoryCode();


	/**
	 * 设置类目编号
	 * @param categoryCode 类目编号
	 */
	public void setCategoryCode(String categoryCode);


	/**
	 * 获取字典编号
	 * @return 字典编号
	 */
	public String getDictCode();


	/**
	 * 设置字典编号
	 * @param dictCode 字典编号
	 */
	public void setDictCode(String dictCode);


	/**
	 * 获取字典名称
	 * @return 字典名称
	 */
	public String getDictName();


	/**
	 * 设置字典名称
	 * @param dictName 字典名称
	 */
	public void setDictName(String dictName);

}
