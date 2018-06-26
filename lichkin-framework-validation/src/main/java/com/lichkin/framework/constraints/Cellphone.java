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
import javax.validation.Payload;

import com.lichkin.framework.constraints.Cellphone.Validator;

/**
 * 手机号码验证注解。不验证null和""。
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = { Validator.class })
public @interface Cellphone {

	public static final String REGEX = "1[0-9]{10}";


	String message() default "{{javax.validation.constraints.Cellphone.message}";


	Class<?>[] groups() default {};


	Class<? extends Payload>[] payload() default {};


	class Validator extends LKValidator<Cellphone> {

		@Override
		protected String getRegex() {
			return REGEX;
		}

	}

}
