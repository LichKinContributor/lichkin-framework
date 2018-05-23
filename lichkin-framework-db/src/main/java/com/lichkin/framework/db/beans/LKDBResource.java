package com.lichkin.framework.db.beans;

import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lichkin.framework.db.annotations.Table;
import com.lichkin.framework.defines.enums.impl.LKErrorCodesEnum;
import com.lichkin.framework.defines.exceptions.LKRuntimeException;
import com.lichkin.framework.log.LKLog;
import com.lichkin.framework.log.LKLogFactory;
import com.lichkin.framework.utils.LKClassScanner;
import com.lichkin.framework.utils.LKFieldUtils;
import com.lichkin.framework.utils.LKStringUtils;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 数据库资源
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class LKDBResource {

	/** 日志对象 */
	private static final LKLog LOGGER = LKLogFactory.getLog(LKClassScanner.class);


	/**
	 * 表资源
	 * @author SuZhou LichKin Information Technology Co., Ltd.
	 */
	@Getter
	@RequiredArgsConstructor
	static class __TableResource {

		/** 类名/实体名 */
		private final String className;

		/** 表名 */
		private final String tableName;

		/** 表别名 */
		private final String tableAlias;

	}

	/**
	 * 列资源
	 * @author SuZhou LichKin Information Technology Co., Ltd.
	 */
	@Getter
	@RequiredArgsConstructor
	static class __ColumnResource {

		/** 表资源 */
		private final __TableResource table;

		/** 列名 */
		private final String columnName;

		/** 字段名/列别名 */
		private final String fieldName;

	}


	/** 表资源 */
	static final Map<Class<?>, __TableResource> tables = new HashMap<>();

	/** 列资源 */
	static final Map<Integer, __ColumnResource> columns = new HashMap<>();

	/** R文件字符串 */
	private static StringBuilder RFileStr = new StringBuilder();

	/** 列资源字符串 */
	private static List<StringBuilder> columnsStrList = new ArrayList<>();


	/**
	 * 初始化数据库资源
	 * @throws ClassNotFoundException ClassNotFoundException
	 * @throws IOException IOException
	 * @throws URISyntaxException URISyntaxException
	 */
	public static void init() throws ClassNotFoundException, IOException, URISyntaxException {
		@SuppressWarnings("unchecked")
		List<Class<?>> classes = LKClassScanner.scanClasses(Table.class);// 扫描所有带Table注解的类
		for (Class<?> clazz : classes) {
			addTable(clazz);
		}
		LOGGER.info(tables);
		LOGGER.info(columns);
		LOGGER.info(getRFileStr());
	}


	static int columnIdx = 0;


	/**
	 * 增加表资源
	 * @param clazz 资源类
	 */
	public static void addTable(Class<?> clazz) {
		Table tableAnnotation = clazz.getAnnotation(Table.class);
		if (tableAnnotation == null) {
			throw new LKRuntimeException(LKErrorCodesEnum.CONFIG_ERROR);
		}
		// 添加表资源
		String className = clazz.getName();
		String tableName = tableAnnotation.name();
		String tableAlias = clazz.getSimpleName();
		__TableResource tableResource = new __TableResource(className, tableName, tableAlias);
		tables.put(clazz, tableResource);

		// 添加列资源
		StringBuilder columnsStr = new StringBuilder();
		columnsStr.append("\n").append("\t").append("public static final class ").append(tableAlias).append(" {").append("\n");
		List<Field> fields = LKFieldUtils.getRealFieldList(clazz, "serialVersionUID");
		for (Field field : fields) {
			String columnKey = LKStringUtils.fillZero(++columnIdx, 8);
			String fieldName = field.getName();
			columns.put(Integer.parseInt(columnKey, 16), new __ColumnResource(tableResource, LKStringUtils.humpToUnderline(fieldName), fieldName));
			columnsStr.append("\n").append("\t").append("\t").append("public static final int ").append(fieldName).append(" = 0x").append(columnKey).append(";").append("\n");
		}
		columnsStr.append("\n").append("\t").append("}");
		columnsStrList.add(columnsStr);
	}


	/**
	 * 获取R文件字符串
	 * @return R文件字符串
	 */
	private static String getRFileStr() {
		RFileStr.append("\n").append("package com.lichkin.framework.db.beans;").append("\n").append("\n");
		RFileStr.append("public class R {").append("\n");

		for (StringBuilder columnsStr : columnsStrList) {
			RFileStr.append(columnsStr).append("\n");
		}

		RFileStr.append("\n").append("}").append("\n");

		return RFileStr.toString();
	}

}
