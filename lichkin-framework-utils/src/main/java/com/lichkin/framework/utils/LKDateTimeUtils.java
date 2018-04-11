package com.lichkin.framework.utils;

import java.util.Locale;

import org.joda.time.DateTime;

import com.lichkin.framework.defines.enums.impl.LKDateTimeTypeEnum;
import com.lichkin.framework.utils.i18n.LKI18NReader4DateTimeType;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * 日期时间工具类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LKDateTimeUtils {

	/**
	 * 获取当前时间字符串
	 * @param locale 国际化类型
	 * @param dateTimeType 日期时间类型
	 * @return 字符串
	 */
	public static String now(Locale locale, LKDateTimeTypeEnum dateTimeType) {
		return DateTime.now().toString(LKI18NReader4DateTimeType.read(locale, dateTimeType));
	}


	/**
	 * 获取当前时间字符串
	 * @param dateTimeType 日期时间类型
	 * @return 字符串
	 */
	public static String now(LKDateTimeTypeEnum dateTimeType) {
		return now(Locale.ENGLISH, dateTimeType);
	}


	/**
	 * 获取当前时间字符串
	 * @param locale 国际化类型
	 * @return 字符串
	 */
	public static String now(Locale locale) {
		return now(locale, LKDateTimeTypeEnum.TIMESTAMP);
	}


	/**
	 * 获取当前时间字符串
	 * @return 字符串
	 */
	public static String now() {
		return now(Locale.ENGLISH, LKDateTimeTypeEnum.TIMESTAMP);
	}


	/**
	 * 获取时间字符串
	 * @param dateTime 日期时间
	 * @param locale 国际化类型
	 * @param dateTimeType 日期时间类型
	 * @return 字符串
	 */
	public static String toString(DateTime dateTime, Locale locale, LKDateTimeTypeEnum dateTimeType) {
		return dateTime.toString(LKI18NReader4DateTimeType.read(locale, dateTimeType));
	}


	/**
	 * 获取时间字符串
	 * @param dateTime 日期时间
	 * @param dateTimeType 日期时间类型
	 * @return 字符串
	 */
	public static String toString(DateTime dateTime, LKDateTimeTypeEnum dateTimeType) {
		return toString(dateTime, Locale.ENGLISH, dateTimeType);
	}


	/**
	 * 获取时间字符串
	 * @param dateTime 日期时间
	 * @param locale 国际化类型
	 * @return 字符串
	 */
	public static String toString(DateTime dateTime, Locale locale) {
		return toString(dateTime, locale, LKDateTimeTypeEnum.TIMESTAMP);
	}


	/**
	 * 获取时间字符串
	 * @param dateTime 日期时间
	 * @return 字符串
	 */
	public static String toString(DateTime dateTime) {
		return toString(dateTime, Locale.ENGLISH, LKDateTimeTypeEnum.TIMESTAMP);
	}

}
