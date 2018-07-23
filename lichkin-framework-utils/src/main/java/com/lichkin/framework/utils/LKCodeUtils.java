package com.lichkin.framework.utils;

import static com.lichkin.framework.defines.LKFrameworkStatics.ROOT;

import org.apache.commons.lang3.StringUtils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * 编码工具类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LKCodeUtils {

	/** 编码长度 */
	private static int LENGHT = 7;

	/** 层级编码 */
	private static final String[] strs = new String[] { "A", "B", "C", "D", "E", "F", "G", "H" };


	/**
	 * 补全编码
	 * @param code 编码
	 * @return 编码
	 */
	public static String fillCode(String code) {
		if (code.equalsIgnoreCase(ROOT)) {
			return ROOT;
		}

		final int len = code.length() / (LENGHT + 1);
		for (int i = len; i < strs.length; i++) {
			code += strs[i] + LKStringUtils.fillZero(0, LENGHT);
		}
		return code;
	}


	/**
	 * 当前级别
	 * @param currentCode 编码
	 * @return 级别
	 */
	public static int currentLevel(String currentCode) {
		if (currentCode.equalsIgnoreCase(ROOT)) {
			return 0;
		}

		for (int i = strs.length - 1; i >= 0; i--) {
			final int x = Integer.parseInt(currentCode.substring((i * (LENGHT + 1)) + 1, (i + 1) * (LENGHT + 1)));
			if (x != 0) {
				return i + 1;
			}
		}
		return 1;
	}


	/**
	 * 真实编码
	 * @param currentCode 当前编码
	 * @return 编码
	 */
	public static String realCode(String currentCode) {
		if ((currentCode == null) || currentCode.equalsIgnoreCase(ROOT)) {
			return ROOT;
		}
		for (int i = strs.length - 1; i >= 0; i--) {
			final int x = Integer.parseInt(currentCode.substring((i * (LENGHT + 1)) + 1, (i + 1) * (LENGHT + 1)));
			if (x != 0) {
				return currentCode.substring(0, ((i + 1) * (LENGHT + 1)));
			}
		}
		return null;
	}


	/**
	 * 下一个编码
	 * @param currentCode 当前编码
	 * @return 编码
	 */
	public static String nextCode(String currentCode) {
		int current = 0;
		int level = 0;
		for (int i = strs.length - 1; i >= 0; i--) {
			final int x = Integer.parseInt(currentCode.substring((i * (LENGHT + 1)) + 1, (i + 1) * (LENGHT + 1)));
			if (x != 0) {
				current = x + 1;
				level = i;
				break;
			}
		}
		return fillCode(currentCode.substring(0, (level * (LENGHT + 1)) + 1) + LKStringUtils.fillZero(current, LENGHT));
	}


	/**
	 * 创建编码
	 * @param parentCode 上级编码
	 * @return 编码
	 */
	public static String createCode(String parentCode) {
		if (StringUtils.isBlank(parentCode)) {
			parentCode = ROOT;
		}
		String realCode = realCode(parentCode);
		if (parentCode.equalsIgnoreCase(ROOT)) {
			realCode = "";
		}
		final int len = realCode.length() / (LENGHT + 1);
		realCode += strs[len] + LKStringUtils.fillZero(1, LENGHT);
		for (int i = len + 1; i < strs.length; i++) {
			realCode += strs[i] + LKStringUtils.fillZero(0, LENGHT);
		}
		return realCode;
	}


	/**
	 * 创建编码
	 * @param parentCode 上级编码
	 * @param orderId 排序号
	 * @return 编码
	 */
	public static String createCode(String parentCode, int orderId) {
		if (StringUtils.isBlank(parentCode)) {
			parentCode = ROOT;
		}
		String menuCode = createCode(parentCode);
		for (int i = 1; i <= orderId; i++) {
			menuCode = nextCode(menuCode);
		}
		return menuCode;
	}

}
