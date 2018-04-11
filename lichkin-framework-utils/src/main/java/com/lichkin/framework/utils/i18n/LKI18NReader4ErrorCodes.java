package com.lichkin.framework.utils.i18n;

import java.util.Locale;

import com.lichkin.framework.defines.enums.LKCodeEnum;

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
		return read(locale, "errorCodes", errorCode.toString());
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
	 * 读取配置值
	 * @param locale 国际化类型
	 * @param errorCode 错误编码
	 * @return 配置值
	 */
	public static String read(String locale, LKCodeEnum errorCode) {
		return read(LKI18NUtils.getLocale(locale), errorCode);
	}

}
