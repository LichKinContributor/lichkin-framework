package com.lichkin.framework.defines;

/**
 * 框架基本类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class LKFrameworkStatics {

	/** 系统默认配置值：API数据请求映射。 */
	public static final String WEB_MAPPING_API = "/API";

	/** 系统默认配置值：API数据请求映射（仅应用于客户端请求）。 */
	public static final String WEB_MAPPING_API_APP = "/API/App";

	/** 系统默认配置值：API数据请求映射（仅应用于页面请求）。 */
	public static final String WEB_MAPPING_API_WEB = "/API/Web";

	/** 系统默认配置值：页面请求映射。 */
	public static final String WEB_MAPPING_PAGES = ".dhtml";

	/** 多字段分隔符 */
	public static final String SPLITOR_FIELDS = "@#@";

	/** 标准分隔符 */
	public static final String SPLITOR = "#@#";

	/** 自定义业务错误编码最小值 */
	public static final int MIN_BUS_ERROR_CODE = 10000;

	/** 业务通用顶层编码 */
	public static final String ROOT = "ROOT";

}
