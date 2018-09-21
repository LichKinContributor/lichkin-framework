package com.lichkin.framework.beans.impl;

import javax.validation.constraints.NotBlank;

import com.lichkin.framework.constraints.MixIDs;
import com.lichkin.framework.constraints.UsingStatus;
import com.lichkin.framework.defines.entities.I_ID;
import com.lichkin.framework.defines.entities.I_UsingStatus;
import com.lichkin.framework.defines.enums.impl.LKUsingStatusEnum;

import lombok.Getter;
import lombok.Setter;

/**
 * 接口请求基本对象类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Getter
@Setter
public class LKRequestIDsUsingStatusBean extends LKRequestBean implements I_ID, I_UsingStatus {

	/** 单个或多个ID */
	@MixIDs
	@NotBlank
	private String id;

	/** 在用状态 */
	@UsingStatus
	private LKUsingStatusEnum usingStatus;

}
