package com.lichkin.framework.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.lichkin.framework.defines.LKFrameworkStatics;
import com.lichkin.framework.defines.beans.impl.LKTreeBean;
import com.lichkin.framework.defines.enums.impl.LKErrorCodesEnum;
import com.lichkin.framework.defines.exceptions.LKFrameworkException;
import com.lichkin.framework.defines.exceptions.LKRuntimeException;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * 树形结构工具类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LKTreeUtils {

	/**
	 * 转换为统一列表对象
	 * @param list 列表对象
	 * @param idFieldName 主键字段名，该字段值不能为null。
	 * @param codeFieldName 编码字段名，该字段值不能为null，且是Code规则码。
	 * @param parentCodeFieldName 上级编码字段名，该字段值不能为null，且是Code规则码。
	 * @return 列表对象
	 */
	@SuppressWarnings("unchecked")
	private static List<LKTreeBean> toList(List<?> list, String idFieldName, String codeFieldName, String parentCodeFieldName) {
		if (CollectionUtils.isEmpty(list)) {
			return Collections.emptyList();
		}

		Object obj0 = list.get(0);
		Class<?> clazz = obj0.getClass();

		if (clazz.equals(LKTreeBean.class)) {
			return (List<LKTreeBean>) list;
		}

		List<Field> listField = LKFieldUtils.getRealFieldList(clazz, false);
		Field idField = null;
		Field codeField = null;
		Field parentCodeField = null;
		for (Field field : listField) {
			if (!field.isAccessible()) {
				field.setAccessible(true);
			}

			String fieldName = field.getName();
			if (fieldName.equals(idFieldName)) {
				idField = field;
			} else if (fieldName.equals(codeFieldName)) {
				codeField = field;
			} else if (fieldName.equals(parentCodeFieldName)) {
				parentCodeField = field;
			}
		}

		if (idField == null) {
			throw new LKRuntimeException(LKErrorCodesEnum.CONFIG_ERROR, new LKFrameworkException("can not find id filed by param idFieldName."));
		}
		if (codeField == null) {
			throw new LKRuntimeException(LKErrorCodesEnum.CONFIG_ERROR, new LKFrameworkException("can not find code filed by param codeFieldName."));
		}
		if (parentCodeField == null) {
			throw new LKRuntimeException(LKErrorCodesEnum.CONFIG_ERROR, new LKFrameworkException("can not find parentCode filed by param parentCodeFieldName."));
		}

		List<LKTreeBean> listResult = new ArrayList<>(list.size());

		try {
			for (Object obj : list) {
				LKTreeBean bean = new LKTreeBean(idField.get(obj).toString(), codeField.get(obj).toString(), parentCodeField.get(obj).toString());
				for (Field field : listField) {
					bean.addParam(field.getName(), field.get(obj));
				}
				listResult.add(bean);
			}
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();// ignore this
		}

		return listResult;
	}


	/**
	 * 转换为树形结构
	 * @param list 列表对象
	 * @return 树形结构
	 */
	private static List<LKTreeBean> toTree(List<LKTreeBean> list) {
		List<LKTreeBean> listRoot = new ArrayList<>();
		Collections.sort(list, (o1, o2) -> o1.getCode().compareTo(o2.getCode()));
		for (LKTreeBean bean : list) {
			if (bean.getCode().equals(LKFrameworkStatics.ROOT)) {
				listRoot.add(bean);
				addChild(bean, list);
			}
		}
		return listRoot;
	}


	/**
	 * 增加子节点
	 * @param bean 上级节点
	 * @param list 列表对象
	 */
	private static void addChild(LKTreeBean bean, List<LKTreeBean> list) {
		for (LKTreeBean child : list) {
			if (bean.getCode().equals(child.getParentCode())) {
				bean.addChild(child);
				addChild(child, list);
			}
		}
	}


	/**
	 * 转换为树形结构
	 * @param list 列表对象
	 * @param idFieldName 主键字段名，该字段值不能为null。
	 * @param codeFieldName 编码字段名，该字段值不能为null，且是Code规则码。
	 * @param parentCodeFieldName 上级编码字段名，该字段值不能为null，且是Code规则码。
	 * @return 树形结构
	 */
	public static List<LKTreeBean> toTree(List<?> list, String idFieldName, String codeFieldName, String parentCodeFieldName) {
		return toTree(toList(list, idFieldName, codeFieldName, parentCodeFieldName));
	}

}
