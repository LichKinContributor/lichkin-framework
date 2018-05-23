package com.lichkin.framework.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;

/**
 * Field工具类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class LKFieldUtils {

	/**
	 * 获取真实的Field列表。即子类定义了与父类相同的Field时，只返回子类定义的Field。
	 * @param clazz 类型
	 * @param excludeFieldNames 排除字段名
	 * @return Field列表
	 */
	public static List<Field> getRealFieldList(final Class<?> clazz, String... excludeFieldNames) {
		final List<Field> listFields = new ArrayList<>();
		if (ArrayUtils.isEmpty(excludeFieldNames)) {
			for (Class<?> currentClass = clazz; currentClass != null; currentClass = currentClass.getSuperclass()) {
				final Field[] currentFields = currentClass.getDeclaredFields();
				if (currentClass == clazz) {
					Collections.addAll(listFields, currentFields);
					continue;
				}
				for (Field currentField : currentFields) {
					boolean contains = false;
					for (Field field : listFields) {
						if (field.getName().equals(currentField.getName()) && field.getType().equals(currentField.getType())) {
							contains = true;
							break;
						}
					}
					if (!contains) {
						listFields.add(currentField);
					}
				}
			}
		} else {
			for (Class<?> currentClass = clazz; currentClass != null; currentClass = currentClass.getSuperclass()) {
				final Field[] currentFields = currentClass.getDeclaredFields();
				out: for (Field currentField : currentFields) {
					for (String excludeFieldName : excludeFieldNames) {
						if (excludeFieldName.equals(currentField.getName())) {
							continue out;
						}
					}
					boolean contains = false;
					for (Field field : listFields) {
						if (field.getName().equals(currentField.getName()) && field.getType().equals(currentField.getType())) {
							contains = true;
							break;
						}
					}
					if (!contains) {
						listFields.add(currentField);
					}
				}
			}
		}
		return listFields;
	}

}
