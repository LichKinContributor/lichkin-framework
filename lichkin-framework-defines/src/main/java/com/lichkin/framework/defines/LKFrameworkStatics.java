package com.lichkin.framework.defines;

import java.util.Locale;

/**
 * 框架基本类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class LKFrameworkStatics {

	/** 默认国际化类型 */
	public static Locale DEFAULT_LOCALE = Locale.SIMPLIFIED_CHINESE;

	/** 已经实现的国际化类型列表，没有实现的国际化类型都将采用英文作为国际化类型。 */
	public static Locale[] IMPLEMENTED_LOCALE_ARR = { Locale.SIMPLIFIED_CHINESE };

	/** 系统默认配置值：系统标识。 */
	public static String SYSTEM_TAG = "LichKin";

	/** 系统默认配置值：系统名称。 */
	public static String SYSTEM_NAME = "苏州鑫宏利业信息科技有限公司";

	/** 系统默认配置值：是否启用调试功能。 */
	public static boolean SYSTEM_DEBUG = false;

	/** 系统默认配置值：是否启用页面调试功能。 */
	public static boolean WEB_DEBUG = false;

	/** 系统默认配置值：是否启用页面调试功能。 */
	public static boolean WEB_ADMIN_DEBUG = false;

	/** 系统默认配置值：数据请求映射。 */
	public static final String WEB_MAPPING_DATAS = ".do";

	/** 系统默认配置值：API数据请求映射。 */
	public static final String WEB_MAPPING_API = "/API";

	/** 系统默认配置值：页面请求映射。 */
	public static final String WEB_MAPPING_PAGES = ".html";

	/** 系统默认配置值：控制器类所在包名。 */
	public static final String CONTROLLER_PACKAGES = "com.lichkin.**.controllers.impl";

	/** 系统默认配置值：服务类所在包名。 */
	public static final String SERVICE_PACKAGES = "com.lichkin.**.services.impl";

	/** 系统默认配置值：数据库主库DAO类所在包名。 */
	public static final String DB_PRIMARY_DAO_PACKAGES = "com.lichkin.**.daos.impl";

	/** 系统默认配置值：数据库主库ENTITY类所在包名。 */
	public static final String DB_PRIMARY_ENTITY_PACKAGES = "com.lichkin.**.entities.impl";

	/** 系统默认配置值：数据库从库DAO类所在包名。 */
	public static final String DB_SECONDARY_DAO_PACKAGES = "com.lichkin.**.dao.impl";

	/** 系统默认配置值：数据库从库ENTITY类所在包名。 */
	public static final String DB_SECONDARY_ENTITY_PACKAGES = "com.lichkin.**.entity.impl";

	/** 自定义业务错误编码最小值 */
	public static final int MIN_BUS_ERROR_CODE = 10000;

}
