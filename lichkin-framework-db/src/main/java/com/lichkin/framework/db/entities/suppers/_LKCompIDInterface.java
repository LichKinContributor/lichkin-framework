package com.lichkin.framework.db.entities.suppers;

import java.io.Serializable;

/**
 * ID接口
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public interface _LKCompIDInterface extends Serializable {

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
