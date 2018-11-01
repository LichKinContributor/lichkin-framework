package com.lichkin.framework.db.beans;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.lichkin.framework.db.utils.LKDBUtils;
import com.lichkin.framework.defines.enums.impl.LKErrorCodesEnum;
import com.lichkin.framework.defines.exceptions.LKRuntimeException;
import com.lichkin.framework.log.LKLog;
import com.lichkin.framework.log.LKLogFactory;
import com.lichkin.framework.utils.LKClassScanner;
import com.lichkin.framework.utils.LKClassUtils;
import com.lichkin.framework.utils.LKFieldUtils;
import com.lichkin.framework.utils.LKStringUtils;

import lombok.Cleanup;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * 数据库资源文件构建器
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
class LKDBResourceCreater {

	/** 日志对象 */
	private static final LKLog LOGGER = LKLogFactory.getLog(LKDBResourceCreater.class);


	/**
	 * 构建资源文件
	 * @param fileName 文件名
	 * @param test true:test目录；false:main目录。
	 * @throws IOException IOException
	 */
	static void createRFiles(String fileName, boolean test) throws IOException {
		String classpath = Class.class.getClass().getResource("/").getPath();
		String path = classpath.substring(0, classpath.indexOf("/target")) + "/src/" + (test ? "test" : "main") + "/java";
		createRFiles(path, "Sys" + fileName + "R");
	}


	@Getter
	@Setter
	@RequiredArgsConstructor
	static class RI {

		private final String content;

		private final int value;

	}


	/**
	 * 构建资源文件
	 * @param classPath 类路径
	 * @param fileName 文件名
	 * @throws IOException IOException
	 */
	private static void createRFiles(String classPath, String fileName) throws IOException {
		List<Class<?>> classes = LKClassScanner.scanClasses(false,

				"org.hibernate.annotations.Table",

				"javax.persistence.Table",

				"com.lichkin.framework.db.annotations.Table",

				"org.hibernate.annotations.Entity",

				"javax.persistence.Entity"

		);

		List<RI> listRI = new ArrayList<>();

		StringBuilder RIContent = new StringBuilder("package com.lichkin.framework.db.beans;\n\n/**\n * 数据库资源初始化类\n * @author SuZhou LichKin Information Technology Co., Ltd.\n */\nclass ").append(fileName).append("Initializer implements LKRInitializer {\n\n\t/**\n\t * 初始化数据库资源\n\t */\n\tpublic static void init() {");

		if (!classes.isEmpty()) {
			File file = new File(classPath);
			if (!file.exists() || !file.isDirectory()) {
				throw new LKRuntimeException(LKErrorCodesEnum.CONFIG_ERROR);
			}

			for (Class<?> clazz : classes) {
				String className = clazz.getName();
				String tableAlias = clazz.getSimpleName();
				int intValue = LKFieldUtils.getSerialVersionUID(clazz).intValue();
				String tableKey = LKStringUtils.fillZero(intValue, 5);
				String RFileName = tableAlias.replace("Entity", "R");

				String tableName = null;
				try {
					tableName = LKClassUtils.getAnnotationStringValue(clazz, "org.hibernate.annotations.Table", "appliesTo");
					if (tableName == null) {
						tableName = LKClassUtils.getAnnotationStringValue(clazz, "javax.persistence.Table", "name");
						if (tableName == null) {
							tableName = LKClassUtils.getAnnotationStringValue(clazz, "com.lichkin.framework.db.annotations.Table", "name");
							if (tableName == null) {
								tableName = LKDBUtils.toPhysicalTableName(tableAlias);
							}
						}
					}
				} catch (NoSuchMethodException e) {
					LOGGER.error(LKErrorCodesEnum.CONFIG_ERROR, e);
				}

				StringBuilder r = new StringBuilder("package com.lichkin.framework.db.beans;\n\n/**\n * 数据库资源定义类\n * @author SuZhou LichKin Information Technology Co., Ltd.\n */\npublic ").append("interface").append(" ").append(RFileName).append(" {\n");
				StringBuilder ri = new StringBuilder("\n\t\tLKDBResource.addTable(\"").append(className).append("\", \"").append(tableName).append("\", \"").append(tableAlias).append("\");");

				int columnIdx = 0;
				List<Field> fields = LKFieldUtils.getRealFieldList(clazz, true);
				for (Field field : fields) {
					String columnKey = tableKey + LKStringUtils.fillZero(columnIdx++, 3);
					String fieldName = field.getName();

					r.append("\n\t").append("public static final int ").append(fieldName).append(" = 0x").append(columnKey).append(";\n");

					ri.append("\n\t\tLKDBResource.addColumn(\"").append(columnKey).append("\", \"").append(tableAlias).append("\", \"").append(fieldName).append("\");");
				}

				r.append("\n}");

				listRI.add(new RI(ri.toString(), intValue));

				writeFile(classPath + "/com/lichkin/framework/db/beans/" + RFileName + ".java", r.toString());
			}
		}

		Collections.sort(listRI, (o1, o2) -> o1.getValue() - o2.getValue());
		for (RI ri : listRI) {
			RIContent.append(ri.getContent());
		}
		RIContent.append("\n\t}\n\n}");

		writeFile(classPath + "/com/lichkin/framework/db/beans/" + fileName + "Initializer.java", RIContent.toString());
	}


	/**
	 * 写文件
	 * @param fileName 文件名
	 * @param text 文件内容
	 * @throws IOException IOException
	 */
	private static void writeFile(String fileName, String text) throws IOException {
		File rFile = new File(fileName);
		if (!rFile.exists()) {
			File pDir = rFile.getParentFile();
			if (!pDir.exists()) {
				pDir.mkdirs();
			}
			rFile.createNewFile();
		}
		@Cleanup
		FileOutputStream fos = new FileOutputStream(rFile);
		@Cleanup
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		bos.write(text.getBytes("UTF-8"));
		bos.flush();
	}

}
