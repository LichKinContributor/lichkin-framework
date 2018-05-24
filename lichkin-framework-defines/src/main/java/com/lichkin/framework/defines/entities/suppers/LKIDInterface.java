package com.lichkin.framework.defines.entities.suppers;

import java.io.Serializable;

/**
 * ID接口
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public interface LKIDInterface extends Serializable {

	/**
	 * 获取主键
	 * @return 主键
	 */
	public String getId();


	/**
	 * 设置主键
	 * @param id 主键
	 */
	public void setId(String id);


	/**
	 * 获取公司ID
	 * @return 公司ID
	 */
	public String getCompId();


	/**
	 * 设置公司ID
	 * @param id 公司ID
	 */
	public void setCompId(String id);

}
