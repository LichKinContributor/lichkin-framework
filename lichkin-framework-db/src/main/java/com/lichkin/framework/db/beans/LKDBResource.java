package com.lichkin.framework.db.beans;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lichkin.framework.db.utils.LKDBUtils;
import com.lichkin.framework.defines.enums.impl.LKErrorCodesEnum;
import com.lichkin.framework.defines.exceptions.LKRuntimeException;
import com.lichkin.framework.utils.LKClassScanner;
import com.lichkin.framework.utils.LKClassUtils;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 数据库资源
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class LKDBResource {

	/**
	 * 表资源
	 * @author SuZhou LichKin Information Technology Co., Ltd.
	 */
	@Getter
	@RequiredArgsConstructor
	static class TableResource {

		/** 类名/实体名 */
		private final String className;

		/** 表名 */
		private final String tableName;

		/** 表别名 */
		private final String tableAlias;

	}


	/** 表资源 */
	private static final Map<String, TableResource> tables = new HashMap<>();


	/**
	 * 获取表资源
	 * @param clazz 表资源类
	 * @return 表资源对象
	 */
	static TableResource getTableResource(Class<?> clazz) {
		return tables.get(clazz.getName());
	}


	/**
	 * 获取表名
	 * @param clazz 表资源类
	 * @return 表名
	 */
	public static String getTableName(Class<?> clazz) {
		return getTableResource(clazz).getTableName();
	}


	/**
	 * 列资源
	 * @author SuZhou LichKin Information Technology Co., Ltd.
	 */
	@Getter
	@RequiredArgsConstructor
	static class ColumnResource {

		/** 表别名 */
		private final String tableAlias;

		/** 列名 */
		private final String columnName;

		/** 字段名/列别名 */
		private final String fieldName;

	}


	/** 列资源 */
	private static final Map<Integer, ColumnResource> columns = new HashMap<>();


	/**
	 * 获取列资源
	 * @param columnResId 列资源ID
	 * @return 列资源对象
	 */
	static ColumnResource getColumnResource(Integer columnResId) {
		return columns.get(columnResId);
	}


	/**
	 * 加载数据库资源
	 */
	static void load() {
		try {
			List<Class<?>> classes = LKClassScanner.scanClasses();
			for (Class<?> clazz : classes) {
				if (LKClassUtils.checkImplementsInterface(clazz, LKRInitializer.class)) {
					clazz.getMethod("init").invoke(null);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new LKRuntimeException(LKErrorCodesEnum.CONFIG_ERROR, e);
		}

	}


	/**
	 * 增加表资源
	 * @param clazz 类型
	 * @param className 类名/实体名
	 * @param tableName 表名
	 * @param tableAlias 表别名
	 */
	static void addTable(String className, String tableName, String tableAlias) {
		tables.put(className, new TableResource(className, tableName, tableAlias));
	}


	/**
	 * 增加列资源
	 * @param columnKey 列键
	 * @param tableAlias 表别名
	 * @param fieldName 字段名/列别名
	 */
	static void addColumn(String columnKey, String tableAlias, String fieldName) {
		columns.put(Integer.parseInt(columnKey, 16), new ColumnResource(tableAlias, LKDBUtils.toPhysicalColumnName(fieldName), fieldName));
	}

}
