package com.lichkin.framework.utils;

import static com.lichkin.framework.defines.LKStringStatics.SEPARATOR;
import static com.lichkin.framework.defines.LKStringStatics.UNDERLINE;

import org.apache.commons.lang3.StringUtils;

/**
 * 字符串工具类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class LKStringUtils {

	/**
	 * 转换为标准路径，即使用/作为分隔符，并以/开头，不以/结尾。
	 * @param path 路径
	 * @return 标准路径
	 */
	public static String toStandardPath(String path) {
		if (StringUtils.isBlank(path)) {
			return SEPARATOR;
		}
		path = path.replaceAll("\\\\", SEPARATOR);
		if (!path.startsWith(SEPARATOR)) {
			path = SEPARATOR + path;
		}
		if (path.endsWith(SEPARATOR)) {
			path = path.substring(0, path.lastIndexOf(SEPARATOR));
		}
		return path;
	}


	/**
	 * 拼接路径
	 * @param path 被拼接路径
	 * @param subPath 拼接路径
	 * @return 拼接后的路径
	 */
	public static String joinPath(String path, String subPath) {
		path = toStandardPath(path);
		if (path == SEPARATOR) {
			return toStandardPath(subPath);
		}
		return path + toStandardPath(subPath);
	}


	/**
	 * 驼峰转下划线
	 *
	 * <pre>
	 * assertEquals(LKStringUtils.humpToUnderline("abcdefghijk"), "ABCDEFGHIJK");
	 * assertEquals(LKStringUtils.humpToUnderline("Abcdefghijk"), "ABCDEFGHIJK");
	 * assertEquals(LKStringUtils.humpToUnderline("abcdefghijK"), "ABCDEFGHIJK");
	 * assertEquals(LKStringUtils.humpToUnderline("abcdeFghijk"), "ABCDE_FGHIJK");
	 * assertEquals(LKStringUtils.humpToUnderline("AbcdeFghijK"), "ABCDE_FGHIJK");
	 * assertEquals(LKStringUtils.humpToUnderline("1abcdefghijk"), "1ABCDEFGHIJK");
	 * assertEquals(LKStringUtils.humpToUnderline("abcdefghijk1"), "ABCDEFGHIJK1");
	 * assertEquals(LKStringUtils.humpToUnderline("abcde1fghijk"), "ABCDE1FGHIJK");
	 * assertEquals(LKStringUtils.humpToUnderline("1abcde1fghijk1"), "1ABCDE1FGHIJK1");
	 * assertEquals(LKStringUtils.humpToUnderline("1abcde1Fghijk1"), "1ABCDE1_FGHIJK1");
	 * assertEquals(LKStringUtils.humpToUnderline("1abcde1FGhijk1"), "1ABCDE1_FGHIJK1");
	 * assertEquals(LKStringUtils.humpToUnderline("1abCde1FGhijk1"), "1AB_CDE1_FGHIJK1");
	 * assertEquals(LKStringUtils.humpToUnderline("usingStatus"), "USING_STATUS");
	 * </pre>
	 *
	 * @param str 驼峰
	 * @return 下划线
	 */
	public static String humpToUnderline(final String str) {
		if (LKMatcherUtils.getMatcher("[0-9_A-Z]*", str).matches()) {// 全部都是大写字母，数字，下划线，直接返回。
			return str;
		}
		if (LKMatcherUtils.getMatcher("[0-9_a-z]*", str).matches()) {// 全部都是小写字母，数字，下划线，返回转大写。
			return str.toUpperCase();
		}

		final StringBuilder sb = new StringBuilder(str);
		for (int i = 1; i < (sb.length() - 1); i++) {
			if (Character.isUpperCase(sb.charAt(i))) {// 当前字符是大写字母
				final char pre = sb.charAt(i - 1);
				if (Character.isLowerCase(pre) || Character.isDigit(pre)) {// 前一字符是小写字母或数字
					sb.insert(i++, UNDERLINE);
				}
			}
		}
		return sb.toString().toUpperCase();// 转换为大写
	}


	/**
	 * 补零
	 *
	 * <pre>
	 * assertEquals(LKStringUtils.fillZero("3", 1, true), "3");
	 * assertEquals(LKStringUtils.fillZero("3", 2, true), "03");
	 * assertEquals(LKStringUtils.fillZero("33", 1, true), "33");
	 * assertEquals(LKStringUtils.fillZero("33", 2, true), "33");
	 * assertEquals(LKStringUtils.fillZero("33", 3, true), "033");
	 * assertEquals(LKStringUtils.fillZero("3", 1, false), "3");
	 * assertEquals(LKStringUtils.fillZero("3", 2, false), "30");
	 * assertEquals(LKStringUtils.fillZero("33", 1, false), "33");
	 * assertEquals(LKStringUtils.fillZero("33", 2, false), "33");
	 * assertEquals(LKStringUtils.fillZero("33", 3, false), "330");
	 * </pre>
	 *
	 * @param number 当前数字
	 * @param digit 显示位数
	 * @param before true：在前面补零；false：在后面补零。
	 * @return 补零后的结果
	 */
	public static String fillZero(final String number, final int digit, final boolean before) {
		final char[] cs = number.toCharArray();
		if (digit <= cs.length) {
			return String.valueOf(cs);
		} else {
			final char[] ncs = new char[digit];
			for (int i = 0; i < ncs.length; i++) {
				ncs[i] = '0';
			}
			if (before) {
				for (int i = ncs.length - 1; i > (digit - number.length() - 1); i--) {
					ncs[i] = cs[i - (digit - number.length())];
				}
			} else {
				for (int i = 0; i < cs.length; i++) {
					ncs[i] = cs[i];
				}
			}
			return String.valueOf(ncs);
		}
	}


	/**
	 * 补零
	 * @param number 当前数字
	 * @param digit 显示位数
	 * @return 补零后的结果
	 * @see LKStringUtils#fillZero(String, int, boolean)
	 */
	public static String fillZero(final String number, final int digit) {
		return fillZero(number, digit, true);
	}


	/**
	 * 补零
	 * @param number 当前数字
	 * @param digit 显示位数
	 * @return 补零后的结果
	 * @see LKStringUtils#fillZero(String, int, boolean)
	 */
	public static String fillZero(final int number, final int digit) {
		return fillZero(String.valueOf(number), digit, true);
	}

}
