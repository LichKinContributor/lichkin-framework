package com.lichkin.framework.constraints;

import java.lang.annotation.Annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.lichkin.framework.utils.LKMatcherUtils;

/**
 * 验证类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
abstract class LKValidator<A extends Annotation> implements ConstraintValidator<A, CharSequence> {

	@Override
	public boolean isValid(CharSequence value, ConstraintValidatorContext context) {
		if ((value == null) || "".equals(value.toString().trim())) {
			return true;
		}
		return LKMatcherUtils.matches(getRegex(), value);
	}


	/**
	 * 获取正则表达式
	 * @return 正则表达式
	 */
	protected abstract String getRegex();

}
