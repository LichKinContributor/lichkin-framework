package com.lichkin.framework.defines;

import java.util.Locale;

import com.lichkin.framework.defines.enums.LKCodeEnum;
import com.lichkin.framework.defines.exceptions.LKRuntimeException;
import com.lichkin.framework.log.LKLog;
import com.lichkin.framework.log.LKLogFactory;

/**
 * 框架类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public abstract class LKFramework {

	/** 日志对象 */
	protected final LKLog logger = LKLogFactory.getLog(getClass());


	/**
	 * 验证字符串
	 * @param str 待验证字符串
	 * @param allowEmpty 允许空值
	 * @return 验证通过返回true，否则返回false。
	 */
	protected boolean validateString(String str, boolean allowEmpty) {
		if ((str == null) || (!allowEmpty && "".equals(str))) {
			return false;
		}
		return true;
	}


	/**
	 * 验证字符串
	 * @param str 待验证字符串
	 * @param allowEmpty 允许空值
	 * @param errorCode 错误编码
	 * @param locale 国际化类型
	 * @return 验证成功返回值
	 */
	protected String checkString(String str, boolean allowEmpty, LKCodeEnum errorCode, Locale locale) {
		if (!validateString(str, allowEmpty)) {
			throw new LKRuntimeException(errorCode, locale);
		}
		return str;
	}


	/**
	 * 验证数字
	 * @param num 待验证数字
	 * @return 验证通过返回true，否则返回false。
	 */
	protected boolean validateInteger(Integer num) {
		if (num == null) {
			return false;
		}
		return true;
	}


	/**
	 * 验证数字
	 * @param num 待验证数字
	 * @return 验证通过返回true，否则返回false。
	 */
	protected boolean validateInteger(String num) {
		if (num == null) {
			return false;
		}
		try {
			Integer.parseInt(num);
		} catch (Exception e) {
			return false;
		}
		return true;
	}


	/**
	 * 验证数字
	 * @param num 待验证数字
	 * @param errorCode 错误编码
	 * @param locale 国际化类型
	 * @return 验证成功返回值
	 */
	protected Integer checkInteger(Integer num, LKCodeEnum errorCode, Locale locale) {
		if (!validateInteger(num)) {
			throw new LKRuntimeException(errorCode, locale);
		}
		return num;
	}


	/**
	 * 验证数字
	 * @param num 待验证数字
	 * @param errorCode 错误编码
	 * @param locale 国际化类型
	 * @return 验证成功返回值
	 */
	protected Integer checkInteger(String num, LKCodeEnum errorCode, Locale locale) {
		if (!validateInteger(num)) {
			throw new LKRuntimeException(errorCode, locale);
		}
		try {
			return Integer.parseInt(num);
		} catch (Exception e) {
			throw new LKRuntimeException(errorCode, locale);
		}
	}

}
