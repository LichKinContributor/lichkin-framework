package com.lichkin.framework.defines;

import java.util.Locale;

/**
 * 配置类静态常量，基于代码配置，减少配置文件配置。
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class LKConfigStatics {

	/** 激活配置文件 */
	public static String PROFILES_ACTIVE = "development,localhost";

	/** 默认国际化类型 */
	public static Locale DEFAULT_LOCALE = Locale.SIMPLIFIED_CHINESE;

	/** 已经实现的国际化类型列表，没有实现的国际化类型都将采用英文作为国际化类型。 */
	public static Locale[] IMPLEMENTED_LOCALE_ARR = { Locale.SIMPLIFIED_CHINESE };

	/** 系统默认配置值：系统标识 */
	public static String SYSTEM_TAG = "LichKin";

	/** 系统默认配置值：系统名称 */
	public static String SYSTEM_NAME = "苏州鑫宏利业信息科技有限公司";

	/** 系统默认配置值：是否启用调试功能 */
	public static boolean SYSTEM_DEBUG = true;

	/** 系统默认配置值：是否启用页面调试功能 */
	public static boolean WEB_DEBUG = true;

	/** 系统默认配置值：JS/CSS使用压缩 */
	public static boolean WEB_COMPRESS = false;

	/** 系统默认配置值：环境上下文路径 */
	public static String WEB_CONTEXT_PATH = "/";

	/** 系统默认配置值：端口号 */
	public static String WEB_SERVER_PORT = "33333";

	/** 系统默认配置值：是否启用页面调试功能 */
	public static boolean WEB_ADMIN_DEBUG = true;

	/** 系统默认配置值：Scoket服务端配置文件索引值 */
	public static int SOCKET_SERVER_CONFIG_IDX = 0;

}
