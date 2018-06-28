package com.lichkin.framework.db.entities.suppers;

/**
 * 一般业务接口
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public interface _LKBaseInterface extends _LKBaseInsertInterface {

	/**
	 * 获取更新操作系统编码
	 * @return 更新操作系统编码
	 */
	public String getUpdateSystemTag();


	/**
	 * 设置更新操作系统编码
	 * @param updateSystemTag 更新操作系统编码
	 */
	public void setUpdateSystemTag(final String updateSystemTag);


	/**
	 * 获取更新操作时间
	 * @return 更新操作时间
	 */
	public String getUpdateTime();


	/**
	 * 设置更新操作时间
	 * @param updateTime 更新操作时间
	 */
	public void setUpdateTime(final String updateTime);


	/**
	 * 获取更新操作人登录ID
	 * @return 更新操作人登录ID
	 */
	public String getUpdateLoginId();


	/**
	 * 设置更新操作人登录ID
	 * @param updateLoginId 更新操作人登录ID
	 */
	public void setUpdateLoginId(final String updateLoginId);

}
