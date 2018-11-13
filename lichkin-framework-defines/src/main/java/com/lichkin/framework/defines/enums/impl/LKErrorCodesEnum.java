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
	CONFIG_ERROR(1),

	/** 请求参数错误 */
	PARAM_ERROR(2),

	/** 数据库验证错误 */
	DB_VALIDATE_ERROR(3),

	/** SQL语句错误 */
	SQL_ERROR(4),

	/** 数据已存在 */
	EXIST(5),

	/** 数据不存在 */
	INEXIST(6),

	/** 登录信息已失效 */
	INVALIDED_TOKEN(7),

	/** 公司信息有误 */
	INVALIDED_COMP_ID(8),

	/** 公司信息有误 */
	INVALIDED_COMP_TOKEN(9),

	/** 登录信息有误 */
	INVALIDED_USER_LOGIN(10),

	/** 账号不存在 */
	ACCOUNT_INEXIST(11),

	/** 公司不存在 */
	COMP_INEXIST(12),

	/** 部门不存在 */
	DEPT_INEXIST(13);

	/** 编码 */
	private final Integer code;

}
