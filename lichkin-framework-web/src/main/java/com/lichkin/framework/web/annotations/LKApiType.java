package com.lichkin.framework.web.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.lichkin.framework.web.enums.ApiType;

/**
 * <pre>
 * 在控制器类上配置该注解，以标明该接口类型，如果接口类型为公司业务时，可不标明该注解。
 * </pre>
 *
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface LKApiType {

	ApiType apiType() default ApiType.COMPANY_BUSINESS;

}
