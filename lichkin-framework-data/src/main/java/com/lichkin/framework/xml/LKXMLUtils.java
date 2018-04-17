package com.lichkin.framework.xml;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.lichkin.framework.json.LKJSONUtils;
import com.lichkin.framework.log.LKLog;
import com.lichkin.framework.log.LKLogFactory;

/**
 * XML工具类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public final class LKXMLUtils {

	/** 日志对象 */
	private static final LKLog LOGGER = LKLogFactory.getLog(LKXMLUtils.class);


	/**
	 * 构造方法
	 */
	private LKXMLUtils() {
	}


	/** XML处理对象 */
	static XmlMapper mapper = new XmlMapper();


	/**
	 * 对象转XML字符串
	 * @param obj 对象
	 * @return XML字符串
	 */
	public static String toXML(Object obj) {
		if (obj != null) {
			try {
				return mapper.writeValueAsString(obj);
			} catch (final Exception e) {
				// ignore this
				LOGGER.error(e);
			}
		}
		return null;
	}


	/**
	 * XML字符串转对象
	 * @param <T> 对象泛型
	 * @param xml XML字符串
	 * @param clazz 对象类型
	 * @return 对象
	 */
	public static <T> T toObj(String xml, Class<T> clazz) {
		if (StringUtils.isNotBlank(xml)) {
			try {
				return mapper.readValue(xml, clazz);
			} catch (final Exception e) {
				// ignore this
				LOGGER.error(e);
			}
		}
		return null;
	}


	/**
	 * XML字符串转List对象
	 * @param <T> 对象泛型
	 * @param xml XML字符串
	 * @param clazz List泛型对象类型
	 * @return List对象
	 */
	public static <T> List<T> toList(String xml, Class<T> clazz) {
		if (StringUtils.isNotBlank(xml)) {
			List<?> list = null;
			try {
				list = mapper.readValue(xml, List.class);
			} catch (final IOException e) {
				// ignore this
				LOGGER.error(e);
				return null;
			}
			if (CollectionUtils.isNotEmpty(list)) {
				final List<T> listT = new ArrayList<>(list.size());
				for (final Object obj : list) {
					listT.add(toObj(toXML(obj), clazz));
				}
				return listT;
			}
		}
		return null;
	}


	/**
	 * XML字符串转Map对象
	 * @param xml XML字符串
	 * @return Map对象
	 */
	public static Map<?, ?> toMap(String xml) {
		if (StringUtils.isNotBlank(xml)) {
			try {
				return mapper.readValue(xml, Map.class);
			} catch (final Exception e) {
				// ignore this
				LOGGER.error(e);
			}
		}
		return null;
	}


	/**
	 * XML字符串转JSON字符串
	 * @param xml XML字符串
	 * @return JSON字符串
	 */
	public static String toJson(String xml) {
		if (StringUtils.isNotBlank(xml)) {
			try {
				return LKJSONUtils.toJSON(mapper.readTree(xml));
			} catch (final IOException e) {
				// ignore this
				LOGGER.error(e);
			}
		}
		return null;
	}

}
