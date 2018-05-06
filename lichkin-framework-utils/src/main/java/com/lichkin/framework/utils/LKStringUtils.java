package com.lichkin.framework.utils;

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
			return "/";
		}
		path = path.replaceAll("\\\\", "/");
		if (!path.startsWith("/")) {
			path = "/" + path;
		}
		if (path.endsWith("/")) {
			path = path.substring(0, path.lastIndexOf("/"));
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
		if (path == "/") {
			return toStandardPath(subPath);
		}
		return path + toStandardPath(subPath);
	}

}
