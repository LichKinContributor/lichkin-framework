package com.lichkin.framework.utils;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;

import org.apache.commons.lang3.ArrayUtils;

/**
 * Class工具类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class LKClassUtils {

	/**
	 * 获取注解对象
	 * @param clazz 类型
	 * @param annotationClassName 注解类名称
	 * @return 注解对象
	 */
	public static Annotation getAnnotation(Class<?> clazz, String annotationClassName) {
		Annotation[] annotations = clazz.getAnnotations();
		if (ArrayUtils.isNotEmpty(annotations)) {
			for (Annotation annotation : annotations) {
				if (annotation.annotationType().getName().equals(annotationClassName)) {
					return annotation;
				}
			}
		}
		return null;
	}


	/**
	 * 是否包含注解
	 * @param clazz 类型
	 * @param annotationClassName 注解类名称
	 * @return true:包含;false:不包含。
	 */
	public static boolean containsAnnotation(Class<?> clazz, String annotationClassName) {
		return getAnnotation(clazz, annotationClassName) != null;
	}


	/**
	 * 获取注解值
	 * @param clazz 类型
	 * @param annotationClassName 注解类名称
	 * @param fieldName 字段类型
	 * @return 注解值
	 * @throws NoSuchMethodException NoSuchMethodException
	 */
	public static Object getAnnotationValue(Class<?> clazz, String annotationClassName, String fieldName) throws NoSuchMethodException {
		Annotation annotation = getAnnotation(clazz, annotationClassName);
		if (annotation != null) {
			try {
				return annotation.annotationType().getMethod(fieldName).invoke(annotation);
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | SecurityException e) {
				e.printStackTrace();// ignore this
			}
		}
		return null;
	}


	/**
	 * 获取注解值
	 * @param clazz 类型
	 * @param annotationClassName 注解类名称
	 * @param fieldName 字段类型
	 * @return 注解值
	 * @throws NoSuchMethodException NoSuchMethodException
	 */
	public static String getAnnotationStringValue(Class<?> clazz, String annotationClassName, String fieldName) throws NoSuchMethodException {
		Object value = getAnnotationValue(clazz, annotationClassName, fieldName);
		if (value != null) {
			return value.toString();
		}
		return null;
	}

}
