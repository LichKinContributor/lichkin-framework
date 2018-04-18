package com.lichkin.framework.defines.beans;

import java.util.Locale;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

import com.lichkin.framework.defines.enums.impl.LKClientTypeEnum;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 接口请求基本对象类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
public class LKRequestBean {

	/** 客户端唯一标识 */
	@NotEmpty
	private String appKey;

	/**
	 * 客户端类型
	 * @see LKClientTypeEnum
	 */
	@NotEmpty
	private String clientType;

	/** 客户端版本号（大版本号） */
	@Positive
	@NotNull
	private Byte versionX;

	/** 客户端版本号（中版本号） */
	@PositiveOrZero
	@NotNull
	private Byte versionY;

	/** 客户端版本号（小版本号） */
	@PositiveOrZero
	@NotNull
	private Short versionZ;

	/**
	 * 国际化
	 * @see Locale
	 */
	private String locale;

	/** 登录后获取得 */
	private String token = "";

}
