package com.lichkin.framework.utils;

import java.lang.reflect.Field;
import java.util.List;

import com.lichkin.framework.defines.enums.impl.LKErrorCodesEnum;
import com.lichkin.framework.defines.exceptions.LKRuntimeException;

/**
 * Bean工具类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class LKBeanUtils {

	/**
	 * 复制属性
	 * @param <B> 返回值类型泛型
	 * @param source 源对象
	 * @param target 目标对象
	 * @param excludeFieldNames 排除字段名
	 * @return 目标对象
	 */
	public static <B> B copyProperties(Object source, B target, String... excludeFieldNames) {
		if ((source != null) && (target != null)) {
			Class<?> sourceClass = source.getClass();
			List<Field> sourceFields = LKFieldUtils.getRealFieldList(sourceClass, true, excludeFieldNames);
			Class<?> targetClass = target.getClass();
			List<Field> targetFields = LKFieldUtils.getRealFieldList(targetClass, true, excludeFieldNames);
			for (Field targetField : targetFields) {
				String targetFieldName = targetField.getName();
				for (Field sourceField : sourceFields) {
					if (sourceField.getName().equals(targetFieldName)) {
						try {
							if (!targetField.isAccessible()) {
								targetField.setAccessible(true);
							}
							if (!sourceField.isAccessible()) {
								sourceField.setAccessible(true);
							}
							Object value = sourceField.get(source);
							if (sourceField.getType().isEnum() && targetField.getType().equals(String.class)) {
								targetField.set(target, value == null ? null : value.toString());
							} else if (sourceField.getType().equals(String.class) && targetField.getType().isEnum()) {
								targetField.set(target, value == null ? null : LKEnumUtils.getEnum(targetField.getType(), (String) value));
							} else {
								targetField.set(target, value);
							}
						} catch (IllegalArgumentException | IllegalAccessException e) {
							e.printStackTrace();// ignore this
						}
					}
				}
			}
		}
		return target;
	}


	/**
	 * 创建对象
	 * @param <B> 目标对象类型泛型
	 * @param source 源对象
	 * @param targetClass 目标对象类型
	 * @param excludeFieldNames 排除字段名
	 * @return 目标对象
	 */
	public static <B> B newInstance(final Object source, final Class<B> targetClass, final String... excludeFieldNames) {
		try {
			return copyProperties(source, targetClass.newInstance(), excludeFieldNames);
		} catch (InstantiationException | IllegalAccessException e) {
			throw new LKRuntimeException(LKErrorCodesEnum.INTERNAL_SERVER_ERROR, e);
		}
	}

}
