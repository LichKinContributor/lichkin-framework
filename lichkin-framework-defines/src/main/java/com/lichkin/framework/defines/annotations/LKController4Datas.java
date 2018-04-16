package com.lichkin.framework.defines.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <pre>
 * 在控制器类上配置该注解，使得该类表示数据请求控制器类，并能够在发生异常时由框架捕获处理。
 * </pre>
 *
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Documented
@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface LKController4Datas {

}
