package com.lichkin.framework.beans.impl;

import com.lichkin.framework.constraints.UsingStatus;
import com.lichkin.framework.defines.entities.I_UsingStatus;
import com.lichkin.framework.defines.enums.impl.LKUsingStatusEnum;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 接口请求基本对象类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
public class LKRequestIDsUsingStatusBean extends LKRequestIDsBean implements I_UsingStatus {

	@UsingStatus
	private LKUsingStatusEnum usingStatus;

}
