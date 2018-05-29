package com.lichkin.framework.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
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
	 * @param excludeStatics 是否排除static修饰的字段
	 * @param excludeFieldNames 排除字段名
	 * @return Field列表
	 */
	public static List<Field> getRealFieldList(final Class<?> clazz, boolean excludeStatics, String... excludeFieldNames) {
		List<Field> listFields = getRealFieldList(clazz, excludeFieldNames);
		if (excludeStatics) {
			for (int i = listFields.size() - 1; i >= 0; i--) {
				if (Modifier.isStatic(listFields.get(i).getModifiers())) {
					listFields.remove(i);
				}
			}
		}
		return listFields;
	}


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
				out: for (Field currentField : currentFields) {
					for (Field field : listFields) {
						if (field.getName().equals(currentField.getName()) && field.getType().equals(currentField.getType())) {
							continue out;
						}
					}
					listFields.add(currentField);
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
					for (Field field : listFields) {
						if (field.getName().equals(currentField.getName()) && field.getType().equals(currentField.getType())) {
							continue out;
						}
					}
					listFields.add(currentField);
				}
			}
		}
		return listFields;
	}

}
