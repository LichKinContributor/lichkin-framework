package com.lichkin.framework.utils.i18n;

import java.util.Locale;
import java.util.Map;

import com.lichkin.framework.defines.enums.LKCodeEnum;
import com.lichkin.framework.defines.enums.impl.LKErrorCodesEnum;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * 错误编码读取工具类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LKI18NReader4ErrorCodes extends LKI18NReader {

	/**
	 * 读取配置值
	 * @param errorCode 错误编码
	 * @param locale 国际化类型
	 * @param params 替换参数
	 * @return 配置值
	 */
	private static String read(LKCodeEnum errorCode, Locale locale, Map<String, Object> params) {
		Integer code = errorCode.getCode();
		if (code == null) {
			return read(LKErrorCodesEnum.PARAM_ERROR, locale, params) + " [" + errorCode.toString() + "]";
		}
		if (code < 1000) {
			return read(locale, "errorCodes", errorCode.toString(), params);
		}
		if (code < 2000) {
			return read(locale, "app-bus-errorCodes", errorCode.toString(), params);
		}
		return read(locale, "app-errorCodes", errorCode.toString(), params);
	}


	/**
	 * 读取配置值
	 * @param locale 国际化类型
	 * @param errorCode 错误编码
	 * @param params 替换参数
	 * @return 配置值
	 */
	public static String read(Locale locale, LKCodeEnum errorCode, Map<String, Object> params) {
		return read(errorCode, locale, params);
	}


	/**
	 * 读取配置值
	 * @param locale 国际化类型
	 * @param errorCode 错误编码
	 * @return 配置值
	 */
	public static String read(Locale locale, LKCodeEnum errorCode) {
		return read(errorCode, locale, null);
	}


	/**
	 * 获取值
	 * @param locale 国际化类型
	 * @param key 键
	 * @param params 替换参数
	 * @return 值
	 */
	public static Object read(Locale locale, String key, Map<String, Object> params) {
		return read(locale, "app-errorCodes", key, params);
	}


	/**
	 * 获取值
	 * @param locale 国际化类型
	 * @param key 键
	 * @return 值
	 */
	public static Object read(Locale locale, String key) {
		return read(locale, "app-errorCodes", key, null);
	}

}
