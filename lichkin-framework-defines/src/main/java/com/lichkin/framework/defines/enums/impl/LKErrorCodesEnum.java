package com.lichkin.framework.defines.enums.impl;

import com.lichkin.framework.defines.enums.LKCodeEnum;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 错误编码枚举
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Getter
@RequiredArgsConstructor
public enum LKErrorCodesEnum implements LKCodeEnum {

	/** 服务器异常 */
	INTERNAL_SERVER_ERROR(-1),

	/** 未找到页面 */
	NOT_FOUND(-2),

	/** 成功 */
	SUCCESS(0),

	/** 配置错误 */
	CONFIG_ERROR(1);

	/** 编码 */
	private final Integer code;

}
