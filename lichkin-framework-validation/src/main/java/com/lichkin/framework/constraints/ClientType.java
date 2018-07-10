package com.lichkin.framework.constraints;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;

import com.lichkin.framework.constraints.ClientType.Validator;
import com.lichkin.framework.constraints.ClientType.ValidatorForEnum;
import com.lichkin.framework.defines.enums.impl.LKClientTypeEnum;

/**
 * 客户端类型验证注解。不验证null和""。
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = { Validator.class, ValidatorForEnum.class })
public @interface ClientType {

	public static final String REGEX = "(ANDROID|IOS|JAVASCRIPT){1}";


	String message() default "{{javax.validation.constraints.ClientType.message}";


	Class<?>[] groups() default {};


	Class<? extends Payload>[] payload() default {};


	class Validator extends LKValidator<ClientType> {

		@Override
		protected String getRegex() {
			return REGEX;
		}

	}

	class ValidatorForEnum implements ConstraintValidator<ClientType, LKClientTypeEnum> {

		@Override
		public boolean isValid(LKClientTypeEnum value, ConstraintValidatorContext context) {
			if (value == null) {
				return false;
			}
			return true;
		}

	}

}
