package com.lichkin.framework.defines.beans;

import java.util.Locale;

import com.lichkin.framework.defines.enums.impl.LKClientTypeEnum;

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

	/** 客户端唯一标识 */
	private String appKey;

	/**
	 * 客户端类型
	 * @see LKClientTypeEnum
	 */
	private String clientType;

	/** 客户端版本号（大版本号） */
	private Byte versionX;

	/** 客户端版本号（中版本号） */
	private Byte versionY;

	/** 客户端版本号（小版本号） */
	private Short versionZ;

	/**
	 * 国际化
	 * @see Locale
	 */
	private String locale;

	/** 登录后获取得 */
	private String token = "";

}
