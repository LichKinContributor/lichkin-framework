package com.lichkin;

import static com.lichkin.framework.log.log4j2.LKLog4j2Log.VALUE_LOG_LEVEL_NET;
import static com.lichkin.framework.log.log4j2.LKLog4j2Log.VALUE_LOG_LEVEL_ORG;
import static com.lichkin.framework.log.log4j2.LKLog4j2Log.VALUE_LOG_LEVEL_SYSTEM;

import java.util.Arrays;
import java.util.Properties;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import com.lichkin.framework.log.LKLog;
import com.lichkin.framework.log.LKLogFactory;
import com.lichkin.framework.log.log4j2.LKLog4j2Initializer;
import com.lichkin.framework.utils.security.properties.LKPropertiesReader;

/**
 * 启动类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class LKMain {

	static {
		LKLog4j2Initializer.setMainArguments("CLOUD_CONNECTOR", VALUE_LOG_LEVEL_SYSTEM, VALUE_LOG_LEVEL_ORG, VALUE_LOG_LEVEL_NET);
	}

	/** 日志对象 */
	private static final LKLog LOGGER = LKLogFactory.getLog(LKMain.class);

	/** 接口服务器根地址 */
	private static final String apisBaseUrl;

	/** 接口地址 */
	private static final String apiUrl;

	static {
		// 读取配置信息
		Properties properties = null;
		try {
			properties = LKPropertiesReader.read("/opt/security/connector.properties");
		} catch (Exception e) {
		}

		// 解析配置信息
		if (properties != null) {
			apisBaseUrl = properties.getProperty("apis.baseUrl");
			apiUrl = apisBaseUrl + "/API/App/ConnectorDatas";
		} else {
			apisBaseUrl = null;
			apiUrl = null;
		}

		// 记录日志
		if (StringUtils.isBlank(apisBaseUrl)) {
			LOGGER.info("cloud API URL -> null");
		} else {
			LOGGER.info("cloud API URL -> " + apiUrl);
		}
	}

	/** 设备类型前缀 */
	private static final String PREFIX_TYPE = "--T=";

	/** 设备厂商前缀 */
	private static final String PREFIX_MANUFACTURER = "--M=";

	/** 设备唯一标识前缀 */
	private static final String PREFIX_ID = "--I=";

	/** 数据前缀 */
	private static final String PREFIX_DATAS = "--DATAS=";


	/**
	 * 主方法
	 * @param args 参数
	 */
	public static void main(String[] args) {
		// 输出入参
		LOGGER.debug("input args -> " + Arrays.toString(args));

		// 参数非空判断
		if (ArrayUtils.isEmpty(args)) {
			LOGGER.error("no input args. example: " + PREFIX_TYPE + "thermometer " + PREFIX_MANUFACTURER + "LichKin " + PREFIX_ID + "1234567890 " + PREFIX_DATAS + "A01234567890");
			return;
		}

		// 提取所需参数
		String type = null;
		String manufacturer = null;
		String id = null;
		String datas = null;
		for (String arg : args) {
			if (StringUtils.startsWithIgnoreCase(arg, PREFIX_TYPE)) {
				type = arg.substring(PREFIX_TYPE.length());
			} else if (StringUtils.startsWithIgnoreCase(arg, PREFIX_MANUFACTURER)) {
				manufacturer = arg.substring(PREFIX_MANUFACTURER.length());
			} else if (StringUtils.startsWithIgnoreCase(arg, PREFIX_ID)) {
				id = arg.substring(PREFIX_ID.length());
			} else if (StringUtils.startsWithIgnoreCase(arg, PREFIX_DATAS)) {
				datas = arg.substring(PREFIX_DATAS.length());
			}
		}

		// 验证设备类型
		if (StringUtils.isBlank(type)) {
			LOGGER.error("input args not contains TYPE. example: " + PREFIX_TYPE + "thermometer");
			return;
		}

		// 验证设备厂商
		if (StringUtils.isBlank(manufacturer)) {
			LOGGER.error("input args not contains MANUFACTURER. example: " + PREFIX_MANUFACTURER + "LichKin");
			return;
		}

		// 验证设备唯一标识
		if (StringUtils.isBlank(id)) {
			LOGGER.error("input args not contains ID. example: " + PREFIX_ID + "1234567890");
			return;
		}

		// 验证数据
		if (StringUtils.isBlank(datas)) {
			LOGGER.error("input args not contains DATAS. example: " + PREFIX_DATAS + "A01234567890");
			return;
		}
		LOGGER.info(String.format("\nanalysed input args ->\nTYPE:[%s]\nMANUFACTURER:[%s]\nID:[%s]\nDATAS:[%s]", type, manufacturer, id, datas));

		LOGGER.debug("ready to request cloud");

		// 验证接口地址
		if (StringUtils.isBlank(apisBaseUrl)) {
			LOGGER.error("cloud API URL must be configed.");
			return;
		}
		if (!StringUtils.startsWithIgnoreCase(apiUrl, "http://") && !StringUtils.startsWithIgnoreCase(apiUrl, "https://")) {
			LOGGER.error("cloud API URL config error.");
			return;
		}

		// TODO 请求接口

		LOGGER.info("finished.");
	}

}
