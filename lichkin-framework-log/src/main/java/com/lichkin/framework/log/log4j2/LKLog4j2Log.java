package com.lichkin.framework.log.log4j2;

import com.lichkin.framework.log.LKLog;

/**
 * log4j2日志接口定义
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public interface LKLog4j2Log extends LKLog {

	/** 日志标识配置项 */
	public static final String KEY_LOG_TAG = "log_tag";

	/** 日志标识配置值 */
	public static final String VALUE_LOG_TAG = "LichKin";

	/** 日志标识配置项(MainArgs) */
	public static final String MAIN_ARG_LOG_TAG = "--log.tag=";

	/** 系统日志级别配置项 */
	public static final String KEY_LOG_LEVEL_SYSTEM = "log_level_system";

	/** 系统日志级别配置值 */
	public static final String VALUE_LOG_LEVEL_SYSTEM = "debug";

	/** 系统日志级别配置项(MainArgs) */
	public static final String MAIN_ARG_LOG_LEVEL_SYSTEM = "--log.level.system=";

	/** org包日志级别配置项 */
	public static final String KEY_LOG_LEVEL_ORG = "log_level_org";

	/** org包日志级别配置值 */
	public static final String VALUE_LOG_LEVEL_ORG = "info";

	/** org包日志级别配置项(MainArgs) */
	public static final String MAIN_ARG_LOG_LEVEL_ORG = "--log.level.org=";

	/** net包日志级别配置项 */
	public static final String KEY_LOG_LEVEL_NET = "log_level_net";

	/** net包日志级别配置值 */
	public static final String VALUE_LOG_LEVEL_NET = "info";

	/** net包日志级别配置项(MainArgs) */
	public static final String MAIN_ARG_LOG_LEVEL_NET = "--log.level.net=";

	/** io包日志级别配置项 */
	public static final String KEY_LOG_LEVEL_IO = "log_level_io";

	/** io包日志级别配置值 */
	public static final String VALUE_LOG_LEVEL_IO = "info";

	/** io包日志级别配置项(MainArgs) */
	public static final String MAIN_ARG_LOG_LEVEL_IO = "--log.level.io=";

}
