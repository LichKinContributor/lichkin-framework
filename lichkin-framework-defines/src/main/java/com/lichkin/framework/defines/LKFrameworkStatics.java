package com.lichkin.framework.defines;

/**
 * 框架基本类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class LKFrameworkStatics {

	/** 系统默认配置值：API数据请求映射。 */
	public static final String WEB_MAPPING_API = "/API";

	/** 系统默认配置值：API数据请求映射（仅应用于客户端请求）。 */
	public static final String WEB_MAPPING_API_APP = WEB_MAPPING_API + "/App";

	/** 系统默认配置值：API数据请求映射（管理客户端）。 */
	public static final String WEB_MAPPING_API_APP_ADMIN = WEB_MAPPING_API_APP + "/Admin";

	/** 系统默认配置值：API数据请求映射（用户客户端）。 */
	public static final String WEB_MAPPING_API_APP_USER = WEB_MAPPING_API_APP + "/User";

	/** 系统默认配置值：API数据请求映射（用户员工客户端）。 */
	public static final String WEB_MAPPING_API_APP_USEREMPLOYEE = WEB_MAPPING_API_APP_USER + "Employee";

	/** 系统默认配置值：API数据请求映射（员工客户端）。 */
	public static final String WEB_MAPPING_API_APP_EMPLOYEE = WEB_MAPPING_API_APP + "/Employee";

	/** 系统默认配置值：API数据请求映射（仅应用于页面请求）。 */
	public static final String WEB_MAPPING_API_WEB = WEB_MAPPING_API + "/Web";

	/** 系统默认配置值：API数据请求映射（管理平台）。 */
	public static final String WEB_MAPPING_API_WEB_ADMIN = WEB_MAPPING_API_WEB + "/Admin";

	/** 系统默认配置值：API数据请求映射（用户平台）。 */
	public static final String WEB_MAPPING_API_WEB_USER = WEB_MAPPING_API_WEB + "/User";

	/** 系统默认配置值：API数据请求映射（用户员工平台）。 */
	public static final String WEB_MAPPING_API_WEB_USEREMPLOYEE = WEB_MAPPING_API_WEB_USER + "Employee";

	/** 系统默认配置值：API数据请求映射（员工平台）。 */
	public static final String WEB_MAPPING_API_WEB_EMPLOYEE = WEB_MAPPING_API_WEB + "/Employee";

	/** 系统默认配置值：页面请求映射。 */
	public static final String WEB_MAPPING_PAGES = ".dhtml";

	/** 多字段分隔符 */
	public static final String SPLITOR_FIELDS = "@#@";

	/** 标准分隔符 */
	public static final String SPLITOR = "#@#";

	/** 自定义业务错误编码最小值 */
	public static final int MIN_BUS_ERROR_CODE = 10000;

	/** 顶级权限定义 */
	public static final String LichKin = "LichKin";

}
