package com.lichkin.framework.web.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <pre>
 * 在控制器上配置该注解，使得该类表示API数据请求时，不需要验证compId，可以使用defaultValue来设置如果无此参数时的默认值。
 * </pre>
 *
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface WithoutCompId {

	String defaultValue() default "";

}
