package com.lichkin.framework.utils;

import java.lang.reflect.Field;
import java.util.List;

import org.joda.time.DateTime;

import com.lichkin.framework.defines.annotations.DefaultBooleanValue;
import com.lichkin.framework.defines.annotations.DefaultByteValue;
import com.lichkin.framework.defines.annotations.DefaultDoubleValue;
import com.lichkin.framework.defines.annotations.DefaultFloatValue;
import com.lichkin.framework.defines.annotations.DefaultIntegerValue;
import com.lichkin.framework.defines.annotations.DefaultLongValue;
import com.lichkin.framework.defines.annotations.DefaultShortValue;
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
		if ((source == null) || (target == null)) {
			return target;
		}

		List<Field> sourceFields = LKFieldUtils.getRealFieldList(source.getClass(), true, excludeFieldNames);
		List<Field> targetFields = LKFieldUtils.getRealFieldList(target.getClass(), true, excludeFieldNames);

		try {
			for (Field sourceField : sourceFields) {
				// 获取名称
				String sourceName = sourceField.getName();

				for (Field targetField : targetFields) {
					// 获取名称
					String targetName = targetField.getName();

					// 不是同一字段跳过
					if (!sourceName.equals(targetName)) {
						continue;
					}

					// 开启访问权限
					if (!sourceField.isAccessible()) {
						sourceField.setAccessible(true);
					}
					if (!targetField.isAccessible()) {
						targetField.setAccessible(true);
					}

					// 获取值
					Object sourceValue = sourceField.get(source);

					// 空值直接设置
					if (sourceValue == null) {
						Class<?> targetType = targetField.getType();
						if (targetType.equals(Byte.class)) {
							DefaultByteValue annotation = targetType.getAnnotation(DefaultByteValue.class);
							if (annotation != null) {
								sourceValue = annotation.value();
							}
						} else if (targetType.equals(Short.class)) {
							DefaultShortValue annotation = targetType.getAnnotation(DefaultShortValue.class);
							if (annotation != null) {
								sourceValue = annotation.value();
							}
						} else if (targetType.equals(Integer.class)) {
							DefaultIntegerValue annotation = targetType.getAnnotation(DefaultIntegerValue.class);
							if (annotation != null) {
								sourceValue = annotation.value();
							}
						} else if (targetType.equals(Long.class)) {
							DefaultLongValue annotation = targetType.getAnnotation(DefaultLongValue.class);
							if (annotation != null) {
								sourceValue = annotation.value();
							}
						} else if (targetType.equals(Boolean.class)) {
							DefaultBooleanValue annotation = targetType.getAnnotation(DefaultBooleanValue.class);
							if (annotation != null) {
								sourceValue = annotation.value();
							}
						} else if (targetType.equals(Float.class)) {
							DefaultFloatValue annotation = targetType.getAnnotation(DefaultFloatValue.class);
							if (annotation != null) {
								sourceValue = annotation.value();
							}
						} else if (targetType.equals(Double.class)) {
							DefaultDoubleValue annotation = targetType.getAnnotation(DefaultDoubleValue.class);
							if (annotation != null) {
								sourceValue = annotation.value();
							}
						}
						targetField.set(target, null);
						continue;
					}

					// 获取类型
					Class<?> sourceType = sourceField.getType();
					Class<?> targetType = targetField.getType();

					// 同样类型直接设置
					if (sourceType.equals(targetType)) {
						targetField.set(target, sourceValue);
						continue;
					}

					// 目标类型为字符串
					if (targetType.equals(String.class)) {
						if (sourceType.equals(java.util.Date.class)) {
							targetField.set(target, LKDateTimeUtils.toString((java.util.Date) sourceValue, LKFieldUtils.getDateToStringAnnotationValue(targetField)));
							continue;
						}
						if (sourceType.equals(java.sql.Date.class)) {
							targetField.set(target, LKDateTimeUtils.toString((java.sql.Date) sourceValue, LKFieldUtils.getDateToStringAnnotationValue(targetField)));
							continue;
						}
						if (sourceType.equals(DateTime.class)) {
							targetField.set(target, LKDateTimeUtils.toString((DateTime) sourceValue, LKFieldUtils.getDateToStringAnnotationValue(targetField)));
							continue;
						}
						if (sourceType.isEnum()) {
							targetField.set(target, sourceValue.toString());
							continue;
						}
						targetField.set(target, String.valueOf(sourceValue));
						continue;
					}

					// 目标类型为枚举且源类型为字符串
					if (targetType.isEnum() && sourceType.equals(String.class)) {
						targetField.set(target, LKEnumUtils.getEnum(targetType, (String) sourceValue));
						continue;
					}

					// 目标类型为日期类型
					if (targetType.equals(java.util.Date.class)) {
						// 源类型为字符
						if (sourceType.equals(String.class)) {
							targetField.set(target, LKDateTimeUtils.toDate((String) sourceValue, LKFieldUtils.getStringToDateAnnotationValue(targetField)));
							continue;
						}
						// 源类型为日期类型
						if (sourceType.equals(java.sql.Date.class)) {
							targetField.set(target, LKDateTimeUtils.toDate(LKDateTimeUtils.toString((java.sql.Date) sourceValue, LKFieldUtils.getDateToDateAnnotationFromValue(targetField)), LKFieldUtils.getDateToDateAnnotationToValue(targetField)));
							continue;
						}
						// 源类型为日期类型
						if (sourceType.equals(DateTime.class)) {
							targetField.set(target, LKDateTimeUtils.toDate(LKDateTimeUtils.toString((DateTime) sourceValue, LKFieldUtils.getDateToDateAnnotationFromValue(targetField)), LKFieldUtils.getDateToDateAnnotationToValue(targetField)));
							continue;
						}
						continue;
					}

					// 目标类型为日期类型
					if (targetType.equals(java.sql.Date.class)) {
						// 源类型为字符
						if (sourceType.equals(String.class)) {
							targetField.set(target, LKDateTimeUtils.toSqlDate((String) sourceValue, LKFieldUtils.getStringToDateAnnotationValue(targetField)));
							continue;
						}
						// 源类型为日期类型
						if (sourceType.equals(java.util.Date.class)) {
							targetField.set(target, LKDateTimeUtils.toSqlDate(LKDateTimeUtils.toString((java.util.Date) sourceValue, LKFieldUtils.getDateToDateAnnotationFromValue(targetField)), LKFieldUtils.getDateToDateAnnotationToValue(targetField)));
							continue;
						}
						// 源类型为日期类型
						if (sourceType.equals(DateTime.class)) {
							targetField.set(target, LKDateTimeUtils.toSqlDate(LKDateTimeUtils.toString((DateTime) sourceValue, LKFieldUtils.getDateToDateAnnotationFromValue(targetField)), LKFieldUtils.getDateToDateAnnotationToValue(targetField)));
							continue;
						}
						continue;
					}

					// 目标类型为日期类型
					if (targetType.equals(DateTime.class)) {
						// 源类型为字符
						if (sourceType.equals(String.class)) {
							targetField.set(target, LKDateTimeUtils.toDateTime((String) sourceValue, LKFieldUtils.getStringToDateAnnotationValue(targetField)));
							continue;
						}
						// 源类型为日期类型
						if (sourceType.equals(java.util.Date.class)) {
							targetField.set(target, LKDateTimeUtils.toDateTime(LKDateTimeUtils.toString((java.util.Date) sourceValue, LKFieldUtils.getDateToDateAnnotationFromValue(targetField)), LKFieldUtils.getDateToDateAnnotationToValue(targetField)));
							continue;
						}
						// 源类型为日期类型
						if (sourceType.equals(java.sql.Date.class)) {
							targetField.set(target, LKDateTimeUtils.toDateTime(LKDateTimeUtils.toString((java.sql.Date) sourceValue, LKFieldUtils.getDateToDateAnnotationFromValue(targetField)), LKFieldUtils.getDateToDateAnnotationToValue(targetField)));
							continue;
						}
						continue;
					}
				}
			}
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();// ignore this
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
