package com.lichkin.framework.defines.entities;

import com.lichkin.framework.defines.enums.impl.LKUsingStatusEnum;

/**
 * 基础表接口
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public interface I_Base {

	/**
	 * 获取在用状态
	 * @return 在用状态
	 */
	public LKUsingStatusEnum getUsingStatus();


	/**
	 * 设置在用状态
	 * @param usingStatus 在用状态
	 */
	public void setUsingStatus(final LKUsingStatusEnum usingStatus);


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

}
