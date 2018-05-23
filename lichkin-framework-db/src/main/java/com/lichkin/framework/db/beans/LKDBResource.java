package com.lichkin.framework.db.beans;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import com.lichkin.framework.db.utils.LKDBUtils;

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
	 * 调用com.lichkin.framework.db.beans.RInitializer的public static void init()方法进行资源初始化
	 * @throws ClassNotFoundException ClassNotFoundException
	 * @throws SecurityException SecurityException
	 * @throws NoSuchMethodException NoSuchMethodException
	 * @throws InvocationTargetException InvocationTargetException
	 * @throws IllegalArgumentException IllegalArgumentException
	 * @throws IllegalAccessException IllegalAccessException
	 */
	public static void load() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
		Class.forName("com.lichkin.framework.db.beans.RInitializer").getMethod("init").invoke(null);
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
