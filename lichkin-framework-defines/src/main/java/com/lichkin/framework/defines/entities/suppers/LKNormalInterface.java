package com.lichkin.framework.defines.entities.suppers;

import com.lichkin.framework.defines.enums.impl.LKUsingStatusEnum;

/**
 * 一般业务接口
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public interface LKNormalInterface extends LKIDInterface {

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

}
