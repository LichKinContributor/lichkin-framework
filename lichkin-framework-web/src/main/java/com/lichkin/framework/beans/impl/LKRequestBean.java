package com.lichkin.framework.beans.impl;

import com.lichkin.framework.defines.beans.LKInvokeBean;

import lombok.Getter;
import lombok.Setter;

/**
 * 接口请求基本对象类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Getter
@Setter
public class LKRequestBean implements LKInvokeBean {

	/** 统一请求参数 */
	private Datas datas;

}
