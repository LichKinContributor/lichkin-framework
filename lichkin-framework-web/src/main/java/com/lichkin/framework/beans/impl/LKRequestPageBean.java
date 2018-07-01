package com.lichkin.framework.beans.impl;

import javax.validation.constraints.PositiveOrZero;

import com.lichkin.framework.defines.beans.LKPageable;

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
public class LKRequestPageBean extends LKRequestBean implements LKPageable {

	/** 页码 */
	@PositiveOrZero
	private Integer pageNumber;

	/** 每页数据量 */
	@PositiveOrZero
	private Integer pageSize;

}
