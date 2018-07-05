package com.lichkin.framework.defines.entities;

/**
 * 系统表基础接口
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public interface I_Base_Sys {

	/**
	 * 获取新增操作系统编码
	 * @return 新增操作系统编码
	 */
	public String getInsertSystemTag();


	/**
	 * 设置新增操作系统编码
	 * @param insertSystemTag 新增操作系统编码
	 */
	public void setInsertSystemTag(final String insertSystemTag);


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
	 * 获取操作系统编码
	 * @return 操作系统编码
	 */
	public String getSystemTag();


	/**
	 * 设置操作系统编码
	 * @param systemTag 操作系统编码
	 */
	public void setSystemTag(final String systemTag);

}
