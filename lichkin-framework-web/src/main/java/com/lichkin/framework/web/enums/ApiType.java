package com.lichkin.framework.web.enums;

/**
 * 接口类型
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public enum ApiType {

	/**
	 * 开放接口
	 *
	 * <pre>
	 * 不做任何校验。（谨慎使用）
	 * </pre>
	 */
	OPEN,

	/**
	 * ROOT查询接口
	 *
	 * <pre>
	 * 开放接口，框架内部将入参中的compId强制设置为ROOT。（谨慎使用）TODO 接口地址必须为查询定义。
	 * </pre>
	 */
	ROOT_QUERY,

	/**
	 * 登录前可用接口
	 *
	 * <pre>
	 * token无值时不查询登录信息
	 * token有值时将查询登录信息，如果登录信息有误将报错。
	 * </pre>
	 */
	BEFORE_LOGIN,

	/**
	 * 个人业务接口
	 *
	 * <pre>
	 * token不能为空，且使用token查询登录信息不能为空。
	 * </pre>
	 */
	PERSONAL_BUSINESS,

	/**
	 * 公司业务接口
	 *
	 * <pre>
	 * token不能为空，且使用token查询登录信息不能为空。
	 * compId不能为空，且使用compId查询公司信息不能为空。
	 * </pre>
	 */
	COMPANY_BUSINESS;

}
