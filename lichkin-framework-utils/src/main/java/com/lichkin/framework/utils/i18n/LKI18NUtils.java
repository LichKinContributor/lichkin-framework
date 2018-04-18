package com.lichkin.framework.utils.i18n;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import com.lichkin.framework.defines.LKFrameworkStatics;
import com.lichkin.framework.defines.exceptions.LKFrameworkException;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * 国际化工具类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LKI18NUtils {

	/**
	 * 获取国际化类型
	 * @param locale 国际化类型字符串
	 * @return 国际化类型
	 */
	public static Locale getLocale(String locale) {
		return getLocale(locale, LKFrameworkStatics.DEFAULT_LOCALE);
	}


	/**
	 * 获取国际化类型
	 * @param locale 国际化类型字符串
	 * @param defaultValue 默认值
	 * @return 国际化类型
	 */
	public static Locale getLocale(String locale, Locale defaultValue) {
		if ((locale != null) && !"".equals(locale) && ((locale.length() == 2) || (locale.length() == 5))) {
			String[] strs = locale.split("_");
			switch (strs.length) {
				case 1:
					if (strs[0].length() == 2) {
						return new Locale(strs[0], "");
					}
				case 2:
					if ((strs[0].length() == 2) && (strs[1].length() == 2)) {
						return new Locale(strs[0], strs[1]);
					}
			}
		}
		return defaultValue;
	}


	/**
	 * 获取属性值，将会从classpath:i18n/forderName/locale.properties中读取属性值
	 * @param locale 国际化类型。en_GB;en_US;en_CA可使用en.properties。
	 * @param folderName 文件夹名
	 * @param key 键
	 * @return 值
	 */
	public static String getString(Locale locale, String folderName, String key) {
		String fileName = "i18n/" + folderName + "/" + locale.toString();
		ResourceBundle file = null;
		try {
			file = ResourceBundle.getBundle(fileName, locale);
		} catch (MissingResourceException e) {
			if (locale.equals(Locale.UK) || locale.equals(Locale.US) || locale.equals(Locale.CANADA)) {
				locale = Locale.ENGLISH;
				file = ResourceBundle.getBundle("i18n/" + folderName + "/" + locale.toString(), locale);
			} else {
				throw new LKFrameworkException(String.format("%s can not be found.", fileName));
			}
		}
		return file.getString(key);
	}

}
