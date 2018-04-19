package com.lichkin.framework.utils.i18n;

import java.util.Locale;

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
	 * @return 配置值
	 */
	private static String read(LKCodeEnum errorCode, Locale locale) {
		if (errorCode.getCode() == null) {
			return read(LKErrorCodesEnum.PARAM_ERROR, locale) + " [" + errorCode.toString() + "]";
		}
		if (errorCode.getCode() < 10000) {
			return read(locale, "errorCodes", errorCode.toString());
		}
		return read(locale, "app-errorCodes", errorCode.toString());
	}


	/**
	 * 读取配置值
	 * @param locale 国际化类型
	 * @param errorCode 错误编码
	 * @return 配置值
	 */
	public static String read(Locale locale, LKCodeEnum errorCode) {
		return read(errorCode, locale);
	}


	/**
	 * 获取值
	 * @param locale 国际化类型
	 * @param key 键
	 * @return 值
	 */
	public static Object read(Locale locale, String key) {
		return read(locale, "app-errorCodes", key);
	}

}
