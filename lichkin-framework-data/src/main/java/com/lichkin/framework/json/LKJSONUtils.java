package com.lichkin.framework.json;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lichkin.framework.log.LKLog;
import com.lichkin.framework.log.LKLogFactory;
import com.lichkin.framework.xml.LKXMLUtils;

/**
 * JSON工具类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public final class LKJSONUtils {

	/** 日志对象 */
	private static final LKLog LOGGER = LKLogFactory.getLog(LKJSONUtils.class);


	/**
	 * 构造方法
	 */
	private LKJSONUtils() {
	}


	/** JSON处理对象 */
	static ObjectMapper mapper = new ObjectMapper();


	/**
	 * 对象转JSON字符串
	 * @param obj 对象
	 * @param isArray 是否为数组，当obj为null时决定返回形式的区别。
	 * @return JSON字符串
	 */
	public static String toJSON(Object obj, boolean isArray) {
		if (obj == null) {
			if (isArray) {
				return "[]";
			}
			return "{}";
		}
		return toJSON(obj);
	}


	/**
	 * 对象转JSON字符串
	 * @param obj 对象
	 * @return JSON字符串
	 */
	public static String toJSON(Object obj) {
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
	 * JSON字符串转对象
	 * @param <T> 对象泛型
	 * @param json JSON字符串
	 * @param clazz 对象类型
	 * @return 对象
	 */
	public static <T> T toObj(String json, Class<T> clazz) {
		if (StringUtils.isNotBlank(json)) {
			try {
				return mapper.readValue(json, clazz);
			} catch (final Exception e) {
				// ignore this
				LOGGER.error(e);
			}
		}
		return null;
	}


	/**
	 * JSON字符串转List对象
	 * @param <T> 对象泛型
	 * @param json JSON字符串
	 * @param clazz List泛型对象类型
	 * @return List对象
	 */
	public static <T> List<T> toList(String json, Class<T> clazz) {
		if (StringUtils.isNotBlank(json)) {
			List<?> list = null;
			try {
				list = mapper.readValue(json, List.class);
			} catch (final IOException e) {
				// ignore this
				LOGGER.error(e);
				return null;
			}
			if (CollectionUtils.isNotEmpty(list)) {
				final List<T> listT = new ArrayList<>(list.size());

				for (final Object obj : list) {
					listT.add(toObj(toJSON(obj), clazz));
				}

				return listT;
			}
		}
		return null;
	}


	/**
	 * JSON字符串转Map对象
	 * @param json JSON字符串
	 * @return Map对象
	 */
	public static Map<?, ?> toMap(String json) {
		if (StringUtils.isNotBlank(json)) {
			try {
				return mapper.readValue(json, Map.class);
			} catch (final Exception e) {
				// ignore this
				LOGGER.error(e);
			}
		}
		return null;
	}


	/**
	 * JSON字符串转XML字符串
	 * @param json JSON字符串
	 * @return XML字符串
	 */
	public static String toXml(String json) {
		if (StringUtils.isNotBlank(json)) {
			return LKXMLUtils.toXML(toJsonNode(json));
		}
		return null;
	}


	/**
	 * 转换成JsonNode对象
	 * @param json JSON字符串
	 * @return JsonNode对象
	 */
	public static JsonNode toJsonNode(String json) {
		try {
			return mapper.readTree(json);
		} catch (final IOException e) {
			// ignore this
			LOGGER.error(e);
		}
		return null;
	}


	/**
	 * 获取子JSON
	 * @param json JSON字符串
	 * @param keys 键
	 * @return 子JSON
	 */
	public static JsonNode deepGet(String json, String... keys) {
		JsonNode jsonNode = toJsonNode(json);

		if (ArrayUtils.isNotEmpty(keys)) {
			for (final String key : keys) {
				jsonNode = jsonNode.get(key);
			}
		}

		return jsonNode;
	}

}
