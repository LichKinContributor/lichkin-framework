package com.lichkin.framework.utils;

import javax.servlet.http.HttpServletRequest;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * IP地址工具类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LKIpUtils {

	/**
	 * 获取IP地址
	 * @param request HttpServletRequest
	 * @return IP地址
	 */
	public static String getIp(final HttpServletRequest request) {
		String ip = request.getHeader("X-Forwarded-For");

		if (notIp(ip)) {
			if (notIp(ip)) {
				ip = request.getHeader("Proxy-Client-IP");
			}
			if (notIp(ip)) {
				ip = request.getHeader("WL-Proxy-Client-IP");
			}
			if (notIp(ip)) {
				ip = request.getHeader("HTTP_CLIENT_IP");
			}
			if (notIp(ip)) {
				ip = request.getHeader("HTTP_X_FORWARDED_FOR");
			}
			if (notIp(ip)) {
				ip = request.getRemoteAddr();
			}
		} else if (ip.length() > 15) {
			final String[] ipArr = ip.split(",");
			for (final String ipAddress : ipArr) {
				if (!notIp(ipAddress)) {
					return ipAddress;
				}
			}
		}
		return ip;
	}


	/**
	 * 判断是否不为IP
	 * @param ip IP地址
	 * @return 是IP地址返回false，否则返回true。
	 */
	private static boolean notIp(String ip) {
		return (ip == null) || "".equals(ip) || "unknown".equalsIgnoreCase(ip);
	}

}
