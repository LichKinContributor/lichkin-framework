package com.lichkin.framework.log.test;

import org.junit.Test;

import com.lichkin.framework.log.LKLog;
import com.lichkin.framework.log.LKLogFactory;
import com.lichkin.framework.log.log4j2.LKLog4j2Initializer;
import com.lichkin.framework.log.log4j2.LKLog4j2Log;

public class Tester {

	private final LKLog logger = LKLogFactory.getLog(getClass());

	static {
		LKLog4j2Initializer.init();
	}


	@Test
	public void test() {
		logger.debug("hello, my name is %s, this is a %s demo. use it just like java.lang.String.format(String format, Object... args)", "zhuangxuxin", "LKLog4j2Log");
		logger.info("you can also use full methods defined by org.apache.commons.logging.Log.");
		logger.warn("it's runs correct.");
		logger.error("here log a error with exception", new RuntimeException("some exception description you want to log"));

		logger.trace("file logs will save as /lichkin-logs/%s.debug.log that log level aboard debug.", LKLog4j2Log.VALUE_LOG_TAG);
		logger.trace("file logs will save as /lichkin-logs/%s.debug.log that log level aboard warn.", LKLog4j2Log.VALUE_LOG_TAG);

		logger.trace("rolling files will save as /lichkin-logs/%s/yyyy/yyyy-MM/yyyy-MM-dd/yyyy-MM-dd-HH-debug-x.log.gz", LKLog4j2Log.VALUE_LOG_TAG);

		logger.trace("we supply some main args to change %s by your own directory use %s%s.", LKLog4j2Log.VALUE_LOG_TAG, LKLog4j2Log.MAIN_ARG_LOG_TAG, "someDirectoryName");

		logger.trace("system log level set %s by default, you can use %s%s to replace it to %s, and any log level can also be set.", LKLog4j2Log.VALUE_LOG_LEVEL_SYSTEM, LKLog4j2Log.MAIN_ARG_LOG_LEVEL_SYSTEM, "debug", "debug");
		logger.trace("org log level set %s by default, you can use %s%s to replace it to %s, and any log level can also be set.", LKLog4j2Log.VALUE_LOG_LEVEL_ORG, LKLog4j2Log.MAIN_ARG_LOG_LEVEL_ORG, "debug", "debug");
		logger.trace("net log level set %s by default, you can use %s%s to replace it to %s, and any log level can also be set.", LKLog4j2Log.VALUE_LOG_LEVEL_NET, LKLog4j2Log.MAIN_ARG_LOG_LEVEL_NET, "debug", "debug");

		logger.warn("if you don't like save this files, just config your own log4j2.xml in the classpath to replace our default configs.");
	}

}
