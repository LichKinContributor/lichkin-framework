package com.lichkin.framework.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * 匹配工具类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LKMatcherUtils {

	/**
	 * 获取匹配对象
	 * @param regex 正则表达式
	 * @param input 待匹配字符串
	 * @return 匹配对象
	 */
	public static Matcher getMatcher(final String regex, final String input) {
		return Pattern.compile(regex).matcher(input);
	}


	/**
	 * 匹配字符串
	 * @param regex 正则表达式
	 * @param input 待匹配字符串
	 * @return 匹配成功返回true，否则返回false。
	 */
	public static boolean matches(final String regex, final String input) {
		return getMatcher(regex, input).matches();
	}

}
