package com.lichkin.framework.beans.impl;

import com.lichkin.framework.beans.LKRequestWithCompIdInterface;
import com.lichkin.framework.constraints.MixID;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 带分页和公司ID的接口请求基本对象类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
public class LKAfterLoginWithCompIdRequestPageBean extends LKAfterLoginRequestPageBean implements LKRequestWithCompIdInterface {

	/** 公司ID */
	@MixID
	private String compId;

}
