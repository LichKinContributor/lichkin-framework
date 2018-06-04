package com.lichkin.framework.db.entities;

import com.lichkin.framework.db.entities.suppers._LKNormalInterface;

/**
 * 类目接口
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public interface LKCategoryInterface extends _LKNormalInterface {

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
	 * 获取类目名称
	 * @return 类目名称
	 */
	public String getCategoryName();


	/**
	 * 设置类目名称
	 * @param categoryName 类目名称
	 */
	public void setCategoryName(String categoryName);

}
