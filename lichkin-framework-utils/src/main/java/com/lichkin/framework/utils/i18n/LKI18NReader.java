package com.lichkin.framework.utils.i18n;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * 国际化文件读取工具类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LKI18NReader {

	/** 缓存 */
	private final static Map<Locale, Map<String, Map<String, String>>> locales = new HashMap<>();


	/**
	 * 获取值
	 * @param locale 国际化类型
	 * @param folderName 文件夹名
	 * @param key 键
	 * @return 值
	 */
	protected static String read(Locale locale, String folderName, String key) {
		Map<String, Map<String, String>> files = locales.get(locale);
		String value = null;
		if (files == null) {
			files = new HashMap<>();
			Map<String, String> props = new HashMap<>();

			value = LKI18NUtils.getString(locale, folderName, key);

			props.put(key, value);
			files.put(folderName, props);
			locales.put(locale, files);
		} else {
			Map<String, String> props = files.get(folderName);
			if (props == null) {
				props = new HashMap<>();

				value = LKI18NUtils.getString(locale, folderName, key);

				props.put(key, value);
				files.put(folderName, props);
			} else {
				value = props.get(key);
				if (value == null) {
					value = LKI18NUtils.getString(locale, folderName, key);

					props.put(key, value);
				}
			}
		}
		return value;
	}


	/**
	 * 获取值
	 * @param locale 国际化类型
	 * @param folderName 文件夹名
	 * @param key 键
	 * @return 值
	 */
	protected static String read(String locale, String folderName, String key) {
		return read(LKI18NUtils.getLocale(locale), folderName, key);
	}

}
