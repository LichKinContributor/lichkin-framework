package com.lichkin.framework.defines.beans;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 接口请求基本对象类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Getter
@Setter
@NoArgsConstructor
public class LKRequestBean {

	/**
	 * 客户端类型
	 *
	 * <pre>
	 * 	A:Android;
	 * 	I:IOS;
	 * 	J:Javascript;
	 * </pre>
	 */
	private String clientType;

	/** 国际化 */
	private String locale;

	/** 客户端唯一标识 */
	private String appKey;

	/** 客户端版本 */
	private String version;

	/** 登录后获取得 */
	private String token = "";

}
