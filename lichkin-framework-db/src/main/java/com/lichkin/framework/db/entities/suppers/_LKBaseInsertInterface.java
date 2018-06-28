package com.lichkin.framework.db.entities.suppers;

/**
 * 一般业务接口
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public interface _LKBaseInsertInterface extends _LKNormalInterface {

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
	 * 获取新增操作时间
	 * @return 新增操作时间
	 */
	public String getInsertTime();


	/**
	 * 设置新增操作时间
	 * @param insertTime 新增操作时间
	 */
	public void setInsertTime(final String insertTime);


	/**
	 * 获取新增操作人登录ID
	 * @return 新增操作人登录ID
	 */
	public String getInsertLoginId();


	/**
	 * 设置新增操作人登录ID
	 * @param insertLoginId 新增操作人登录ID
	 */
	public void setInsertLoginId(final String insertLoginId);

}
