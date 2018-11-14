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
	 * 开放接口，框架内部将入参中的compId强制设置为ROOT。（谨慎使用）
	 * </pre>
	 */
	ROOT_QUERY,

	/**
	 * 登录前可用接口
	 *
	 * <pre>
	 * token无值时不查询登录信息
	 * token有值时将查询登录信息，如果登录信息有误将报错。
	 * 只设置登录信息，不设置用户信息。
	 * </pre>
	 */
	BEFORE_LOGIN,

	/**
	 * 个人业务接口
	 *
	 * <pre>
	 * token不能为空，且使用token查询登录信息不能为空。
	 * 只设置登录信息，不设置用户信息。
	 * </pre>
	 */
	PERSONAL_BUSINESS,

	/**
	 * 公司业务接口
	 *
	 * <pre>
	 * token不能为空，且使用token查询登录信息不能为空。
	 * compToken不能为空，且使用compToken查询公司信息不能为空。
	 * 管理员：登录和用户同样
	 * 用户：代表是员工，将按照员工处理。
	 * 员工：登录信息为用户；用户信息为员工。注：登录ID将设置为员工ID。
	 * </pre>
	 */
	COMPANY_BUSINESS,

	/**
	 * 公司查询接口
	 *
	 * <pre>
	 * compToken不能为空，且使用compToken查询公司信息不能为空。
	 * </pre>
	 */
	COMPANY_QUERY,

	/**
	 * 公司/ROOT查询接口
	 *
	 * <pre>
	 * compToken不能为空，如compToken为ROOT权限时，使用ROOT公司信息；其它情况时使用compToken查询公司信息不能为空。
	 * </pre>
	 */
	COMPANY_ROOT_QUERY;

}
