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

import com.lichkin.framework.constraints.MixID.Validator;
import com.lichkin.framework.defines.LKFrameworkStatics;

/**
 * 混合主键验证注解。不验证null和""。
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = { Validator.class })
public @interface MixID {

	public static final String REGEX = LKFrameworkStatics.ROOT + "|" + ID.REGEX + "|" + LongID.REGEX;


	String message() default "{{javax.validation.constraints.MixID.message}";


	Class<?>[] groups() default {};


	Class<? extends Payload>[] payload() default {};


	class Validator extends LKValidator<MixID> {

		@Override
		protected String getRegex() {
			return REGEX;
		}

	}

}
