package com.lichkin.framework.json;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.ArrayUtils;

import com.fasterxml.jackson.databind.JsonNode;
import com.lichkin.framework.defines.enums.impl.LKErrorCodesEnum;
import com.lichkin.framework.defines.exceptions.LKRuntimeException;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * JSON文件读取工具类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LKJSONFileReader {

	/** 内置缓存对象 */
	private static final Map<String, JsonNode> cache = new HashMap<>();

	/** 文件后缀名 */
	public static final String SUFFIX = ".json";


	/**
	 * 读取JSON文件
	 * @param fileName 文件名
	 * @return JSON
	 */
	public static JsonNode read(String fileName) {
		if (cache.containsKey(fileName)) {
			return cache.get(fileName);
		}
		try {
			JsonNode json = LKJsonUtils.newObjectMapper().readTree(new File(fileName));
			cache.put(fileName, json);
			return json;
		} catch (IOException e) {
			e.printStackTrace();
			throw new LKRuntimeException(LKErrorCodesEnum.CONFIG_ERROR);
		}
	}


	/**
	 * 读取多个JSON文件
	 * @param directoryName 文件路径
	 */
	public static void readFiles(String directoryName) {
		File directory = new File(directoryName);
		if (!directory.exists()) {
			throw new LKRuntimeException(LKErrorCodesEnum.CONFIG_ERROR);
		}

		File[] files = directory.listFiles();
		if (ArrayUtils.isEmpty(files)) {
			return;
		}

		for (File file : files) {
			if (file.isFile()) {
				String fileName = file.getName();
				if (fileName.endsWith(SUFFIX)) {
					read(directoryName + "/" + fileName);
				}
			}
		}
	}


	/**
	 * 获取缓存列表
	 * @return 列表
	 */
	public static List<JsonNode> getCacheList() {
		return new ArrayList<>(cache.values());
	}

}
