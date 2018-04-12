package com.lichkin.framework.utils;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.reflect.FieldUtils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * 反射工具类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LKReflectUtils {

	/**
	 * 获取类型
	 * @param className 类型名
	 * @return 类型
	 */
	public static Class<?> getClassByName(String className) {
		try {
			return Class.forName(className);
		} catch (final ClassNotFoundException e) {
			// ignore this
			return null;
		}
	}


	/**
	 * 获取所有父类类型
	 * @param clazz 当前类型
	 * @return 父类类型列表
	 */
	public static ArrayList<Class<?>> getAllExtendsClasses(final Class<?> clazz) {
		assert (clazz != null) && !clazz.isInterface();

		final ArrayList<Class<?>> list = new ArrayList<>();
		if (clazz.equals(Object.class)) {
			return list;
		}
		Class<?> tmpClass = clazz;
		while (true) {
			final Class<?> superclass = tmpClass.getSuperclass();
			if (superclass.equals(Object.class)) {
				break;
			} else {
				list.add(superclass);
				tmpClass = superclass;
			}
		}
		return list;
	}


	/**
	 * 判断是否继承父类
	 * @param clazz 当前类
	 * @param supperClass 父类
	 * @return 继承父类返回true，否则返回false。
	 */
	public static boolean checkExtendsClass(final Class<?> clazz, final Class<?> supperClass) {
		assert (clazz != null) && !clazz.equals(Object.class) && !clazz.isInterface();
		assert (supperClass != null) && !supperClass.isInterface();

		if (clazz.equals(supperClass)) {
			return false;
		}

		if (supperClass.equals(Object.class)) {
			return true;
		}

		final ArrayList<Class<?>> list = getAllExtendsClasses(clazz);
		for (final Class<?> clz : list) {
			if (clz.equals(supperClass)) {
				return true;
			}
		}
		return false;
	}


	/**
	 * 获取所有接口类型
	 * @param clazz 当前类型
	 * @return 接口类型列表
	 */
	public static ArrayList<Class<?>> getAllImplementsClasses(final Class<?> clazz) {
		assert (clazz != null) && !clazz.equals(Object.class) && !clazz.isInterface();

		// 获取所有父类
		final ArrayList<Class<?>> supperClasses = getAllExtendsClasses(clazz);

		// 增加本类
		supperClasses.add(clazz);

		// 遍历所有类实现的接口
		final ArrayList<Class<?>> list = new ArrayList<>();
		for (final Class<?> supperClass : supperClasses) {
			final Class<?>[] interfaces = supperClass.getInterfaces();
			list.addAll(Arrays.asList(interfaces));
		}

		// 遍历所有接口的继承树
		final int size = list.size();
		for (int i = size - 1; i >= 0; i--) {
			final Class<?>[] interfaces = list.get(i).getInterfaces();
			list.addAll(Arrays.asList(interfaces));
		}

		return list;
	}


	/**
	 * 判断是否实现接口类
	 * @param clazz 当前类
	 * @param interfaceClass 接口类
	 * @return 实现接口类返回true，否则返回false。
	 */
	public static boolean checkImplementsInterface(final Class<?> clazz, final Class<?> interfaceClass) {
		assert (clazz != null) && !clazz.equals(Object.class) && !clazz.isInterface();
		assert (interfaceClass != null) && interfaceClass.isInterface();

		final ArrayList<Class<?>> interfaceClasses = getAllImplementsClasses(clazz);
		for (final Class<?> interfaceClazz : interfaceClasses) {
			if (interfaceClass.equals(interfaceClazz)) {
				return true;
			}
		}
		return false;
	}


	/**
	 * 获取读写属性数组
	 * @param clazz 类型
	 * @return 读写属性数组
	 */
	public static PropertyDescriptor[] getBeanProperties(final Class<?> clazz) {
		return getPropertiesHelper(clazz, true, true);
	}


	/**
	 * 获取读属性数组
	 * @param clazz 类型
	 * @return 读属性数组
	 */
	public static PropertyDescriptor[] getBeanGetters(final Class<?> clazz) {
		return getPropertiesHelper(clazz, true, false);
	}


	/**
	 * 获取写属性数组
	 * @param clazz 类型
	 * @return 写属性数组
	 */
	public static PropertyDescriptor[] getBeanSetters(final Class<?> clazz) {
		return getPropertiesHelper(clazz, false, true);
	}


	/**
	 * 获取属性数组
	 * @param clazz 类型
	 * @param read 是否包含读属性
	 * @param write 是否包含写属性
	 * @return 属性数组
	 */
	private static PropertyDescriptor[] getPropertiesHelper(final Class<?> clazz, final boolean read, final boolean write) {
		try {
			final BeanInfo info = Introspector.getBeanInfo(clazz, Object.class);
			final PropertyDescriptor[] all = info.getPropertyDescriptors();
			if ((read) && (write)) {
				return all;
			}
			final List<PropertyDescriptor> properties = new ArrayList<>(all.length);
			for (final PropertyDescriptor pd : all) {
				if (((read) && (pd.getReadMethod() != null)) || ((write) && (pd.getWriteMethod() != null))) {
					properties.add(pd);
				}
			}
			return properties.toArray(new PropertyDescriptor[properties.size()]);
		} catch (final IntrospectionException e) {
			throw new RuntimeException(e);
		}
	}


	/**
	 * 获取字段数组
	 * @param clazz 类型
	 * @param fieldNames 字段名称。希望获取的字段名称，将会按照指定顺序返回。如果不传该值，则将按照默认顺序返回。
	 * @return 字段数组
	 */
	public static Field[] getAllFields(Class<?> clazz, String... fieldNames) {
		final Field[] fileds = FieldUtils.getAllFields(clazz);
		if (ArrayUtils.isEmpty(fieldNames)) {
			// 返回默认顺序
			return fileds;
		}
		final Field[] orderedFields = new Field[fieldNames.length];
		out: for (int i = 0; i < fieldNames.length; i++) {
			final String fieldName = fieldNames[i];
			for (final Field field : fileds) {
				if (fieldName.equals(field.getName())) {
					orderedFields[i] = field;
					continue out;
				}
			}
		}
		return orderedFields;
	}


	/**
	 * 获取字段数组，并允许直接访问。
	 * @param clazz 类型
	 * @param fieldNames 字段名称。希望获取的字段名称，将会按照指定顺序返回。如果不传该值，则将按照默认顺序返回。
	 * @return 字段数组
	 * @deprecated 通常情况下字段数组肯定会被遍历使用，可以在遍历时自行设置访问权限。本方法也是通过遍历设置访问权限，故尽量不使用该方法，而是调用{@link #getAllFields(Class, String...)}。
	 * @see #getAllFields(Class, String...)
	 */
	@Deprecated
	public static Field[] accessableAllFields(Class<?> clazz, String... fieldNames) {
		final Field[] fileds = getAllFields(clazz, fieldNames);
		for (final Field field : fileds) {
			field.setAccessible(true);
		}
		return fileds;
	}


	/**
	 * 获取字段
	 * @param clazz 类型
	 * @param fieldName 字段名
	 * @return 字段
	 */
	public static Field getField(Class<?> clazz, String fieldName) {
		return getAllFields(clazz, fieldName)[0];
	}


	/**
	 * 获取字段
	 * @param clazz 类型
	 * @param fieldName 字段名
	 * @return 字段
	 */
	public static Field accessableField(Class<?> clazz, String fieldName) {
		final Field field = getAllFields(clazz, fieldName)[0];
		field.setAccessible(true);
		return field;
	}


	/**
	 * 获取字段值
	 * @param obj 对象
	 * @param fieldName 字段名
	 * @return 字段值
	 */
	public static Object getFieldValue(Object obj, String fieldName) {
		if (obj != null) {
			try {
				return accessableField(obj.getClass(), fieldName).get(obj);
			} catch (Exception e) {
				// ignore this
			}
		}
		return null;
	}

}