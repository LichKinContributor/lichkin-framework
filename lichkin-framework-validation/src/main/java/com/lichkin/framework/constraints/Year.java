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

import com.lichkin.framework.constraints.Year.Validator;

/**
 * 年份验证注解。不验证null和""。
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = { Validator.class })
public @interface Year {

	public static final String REGEX = "((19|20)[0-9]{2}){1}";


	String message() default "{{javax.validation.constraints.Year.message}";


	Class<?>[] groups() default {};


	Class<? extends Payload>[] payload() default {};


	class Validator extends LKValidator<Year> {

		@Override
		protected String getRegex() {
			return REGEX;
		}

	}

}
