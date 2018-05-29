package com.lichkin.framework.db.beans;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
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

/**
 * 数据库资源文件构建器
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class LKDBResourceCreater {

	/** 日志对象 */
	private static final LKLog LOGGER = LKLogFactory.getLog(LKDBResourceCreater.class);


	/**
	 * 构建资源文件
	 * @param classPath 类路径
	 * @throws IOException IOException
	 * @throws NoSuchMethodException NoSuchMethodException
	 */
	static void createRFiles(String classPath) throws IOException, NoSuchMethodException {
		List<Class<?>> classes = LKClassScanner.scanClasses(

				"org.hibernate.annotations.Table",

				"javax.persistence.Table",

				"com.lichkin.framework.db.annotations.Table",

				"org.hibernate.annotations.Entity",

				"javax.persistence.Entity"

		);

		StringBuilder r = new StringBuilder("package com.lichkin.framework.db.beans;\n\n/**\n * 数据库资源定义类\n * @author SuZhou LichKin Information Technology Co., Ltd.\n */\npublic class R {\n");

		StringBuilder ri = new StringBuilder("package com.lichkin.framework.db.beans;\n\n/**\n * 数据库资源初始化类\n * @author SuZhou LichKin Information Technology Co., Ltd.\n */\npublic class RInitializer {\n\n\t/**\n\t * 初始化数据库资源\n\t */\n\tpublic static void init() {");

		if (!classes.isEmpty()) {
			int tableIdx = 0;
			for (Class<?> clazz : classes) {
				String tableKey = LKStringUtils.fillZero(++tableIdx, 4);
				String className = clazz.getName();
				String tableAlias = clazz.getSimpleName();

				String tableName = LKClassUtils.getAnnotationStringValue(clazz, "org.hibernate.annotations.Table", "appliesTo");
				if (tableName == null) {
					tableName = LKClassUtils.getAnnotationStringValue(clazz, "javax.persistence.Table", "name");
					if (tableName == null) {
						tableName = LKClassUtils.getAnnotationStringValue(clazz, "com.lichkin.framework.db.annotations.Table", "name");
						if (tableName == null) {
							tableName = LKDBUtils.toPhysicalTableName(tableAlias);
						}
					}
				}

				r.append("\n\tpublic interface ").append(tableAlias).append(" {\n");

				ri.append("\n\t\tLKDBResource.addTable(\"").append(className).append("\", \"").append(tableName).append("\", \"").append(tableAlias).append("\");");

				List<Field> fields = LKFieldUtils.getRealFieldList(clazz, true, "serialVersionUID");

				int columnIdx = 0;
				for (Field field : fields) {
					String columnKey = tableKey + LKStringUtils.fillZero(++columnIdx, 4);
					String fieldName = field.getName();

					r.append("\n\t\tpublic static final int ").append(fieldName).append(" = 0x").append(columnKey).append(";\n");

					ri.append("\n\t\tLKDBResource.addColumn(\"").append(columnKey).append("\", \"").append(tableAlias).append("\", \"").append(fieldName).append("\");");
				}

				r.append("\n\t}\n");
			}
		}

		r.append("\n}");

		ri.append("\n\t}\n\n}");

		if (LOGGER.isTraceEnabled()) {
			LOGGER.trace("\n" + r.toString() + "\n");
			LOGGER.trace("\n" + ri.toString() + "\n");
		}

		File file = new File(classPath);
		if (!file.exists() || !file.isDirectory()) {
			throw new LKRuntimeException(LKErrorCodesEnum.CONFIG_ERROR);
		}

		writeFile(classPath + "/com/lichkin/framework/db/beans/R.java", r.toString());
		writeFile(classPath + "/com/lichkin/framework/db/beans/RInitializer.java", ri.toString());
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
		bos.write(text.getBytes());
		bos.flush();
	}

}
