package com.lichkin.framework.beans.impl;

import com.lichkin.framework.beans.LKRequestPageInterface;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 带分页的接口请求基本对象类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
public class LKBeforeLoginRequestPageBean extends LKBeforeLoginRequestBean implements LKRequestPageInterface {

	/** 页码 */
	private int pageNumber;

	/** 每页数据量 */
	private int pageSize;

}
