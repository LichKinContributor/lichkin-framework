package com.lichkin.framework.db.utils;

import org.apache.commons.lang3.StringUtils;

import com.lichkin.framework.utils.LKStringUtils;

/**
 * 数据库工具类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class LKDBUtils {

	/** 表名前缀 */
	private static final String TABLE_PREFIX = "T_";

	/** 表名后缀 */
	private static final String TABLE_SUFFIX = "_ENTITY";


	/**
	 * 转换为表名称
	 * @param text 表名称文本
	 * @return 表名称
	 */
	public static String toPhysicalTableName(String text) {
		// 不符合框架约定的表，在Table注解中为表名增加冒号前缀。
		if (StringUtils.startsWith(text, ":")) {
			return text.substring(1);
		}

		// 先将文本转换为驼峰标识
		text = LKStringUtils.humpToUnderline(text);

		// 拼接约定前缀
		if (!text.startsWith(TABLE_PREFIX)) {
			text = TABLE_PREFIX + text;
		}

		// 去除约定后缀
		if (text.endsWith(TABLE_SUFFIX)) {
			text = text.substring(0, text.length() - TABLE_SUFFIX.length());
		}

		// 返回结果
		return text;
	}


	/**
	 * 转换为列名称
	 * @param text 列名称文本
	 * @return 列名称
	 */
	public static String toPhysicalColumnName(String text) {
		// 只做驼峰标识转换
		return LKStringUtils.humpToUnderline(text);
	}

}
