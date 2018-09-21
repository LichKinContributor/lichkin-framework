package com.lichkin.framework.beans.impl;

import javax.validation.constraints.NotBlank;

import com.lichkin.framework.constraints.MixID;
import com.lichkin.framework.defines.entities.I_ID;

import lombok.Getter;
import lombok.Setter;

/**
 * 接口请求基本对象类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Getter
@Setter
public class LKRequestIDBean extends LKRequestBean implements I_ID {

	/** 单个ID */
	@MixID
	@NotBlank
	private String id;

}
