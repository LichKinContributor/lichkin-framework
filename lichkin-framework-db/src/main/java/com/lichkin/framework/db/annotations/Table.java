package com.lichkin.framework.db.annotations;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * 在对象上使用本注解后会在R文件中生成对应的资源以供SQL使用。
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Target(TYPE)
@Retention(RUNTIME)
public @interface Table {

	String name() default "";

}
