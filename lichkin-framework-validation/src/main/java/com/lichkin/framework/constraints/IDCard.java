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

import com.lichkin.framework.constraints.IDCard.Validator;

/**
 * 身份证号验证注解。不验证null和""。
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = { Validator.class })
public @interface IDCard {

	public static final String REGEX = "((11)|(12)|(13)|(14)|(15)|(21)|(22)|(23)|(31)|(32)|(33)|(34)|(35)|(36)|(37)|(41)|(42)|(43)|(44)|(45)|(46)|(50)|(51)|(52)|(53)|(54)|(61)|(62)|(63)|(64)|(65)|(71)|(81)|(82)|(91))[0-9]{4}" + Year.REGEX + Month.REGEX + Day.REGEX + "[0-9]{3}[0-9xX]{1}";


	String message() default "{{javax.validation.constraints.IDCard.message}";


	Class<?>[] groups() default {};


	Class<? extends Payload>[] payload() default {};


	class Validator extends LKValidator<IDCard> {

		@Override
		protected String getRegex() {
			return REGEX;
		}

	}

}
