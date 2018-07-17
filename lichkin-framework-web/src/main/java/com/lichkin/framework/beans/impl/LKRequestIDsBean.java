package com.lichkin.framework.beans.impl;

import javax.validation.constraints.NotBlank;

import com.lichkin.framework.constraints.MixIDs;
import com.lichkin.framework.defines.entities.I_ID;

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
public class LKRequestIDsBean extends LKRequestBean implements I_ID {

	@MixIDs
	@NotBlank
	private String id;

}
