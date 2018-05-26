package com.lichkin.framework.db.entities.suppers;

/**
 * ID接口
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public interface LKIDInterface extends _LKIDInterface {

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
