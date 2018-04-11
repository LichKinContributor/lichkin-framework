package com.lichkin.framework.log.log4j2;

import static com.lichkin.framework.log.log4j2.LKLog4j2Log.KEY_LOG_LEVEL_NET;
import static com.lichkin.framework.log.log4j2.LKLog4j2Log.KEY_LOG_LEVEL_ORG;
import static com.lichkin.framework.log.log4j2.LKLog4j2Log.KEY_LOG_LEVEL_SYSTEM;
import static com.lichkin.framework.log.log4j2.LKLog4j2Log.KEY_LOG_TAG;
import static com.lichkin.framework.log.log4j2.LKLog4j2Log.VALUE_LOG_LEVEL_NET;
import static com.lichkin.framework.log.log4j2.LKLog4j2Log.VALUE_LOG_LEVEL_ORG;
import static com.lichkin.framework.log.log4j2.LKLog4j2Log.VALUE_LOG_LEVEL_SYSTEM;
import static com.lichkin.framework.log.log4j2.LKLog4j2Log.VALUE_LOG_TAG;

import org.apache.logging.log4j.core.lookup.MainMapLookup;

/**
 * log4j2日志初始化工具类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class LKLog4j2Initializer {

	/**
	 * 初始化
	 */
	public static void init() {
		// 配置log4j2的参数
		setMainArguments(VALUE_LOG_TAG, VALUE_LOG_LEVEL_SYSTEM, VALUE_LOG_LEVEL_ORG, VALUE_LOG_LEVEL_NET);
	}


	/**
	 * 配置log4j2的参数
	 * @param logTag 日志标识
	 * @param logLevelSystem 系统日志级别
	 * @param logLevelOrg org包日志级别
	 * @param logLevelNet net包日志级别
	 */
	public static void setMainArguments(String logTag, String logLevelSystem, String logLevelOrg, String logLevelNet) {
		MainMapLookup.setMainArguments(new String[] {

				KEY_LOG_TAG, logTag,

				KEY_LOG_LEVEL_SYSTEM, logLevelSystem,

				KEY_LOG_LEVEL_ORG, logLevelOrg,

				KEY_LOG_LEVEL_NET, logLevelNet

		});
	}

}
