package com.lichkin.framework.defines.beans;

import java.util.Locale;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

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

	/**
	 * 国际化
	 * @see Locale
	 */
	@Pattern(regexp = "([A-Za-z]{2}){1}(_[A-Za-z]{2})?")
	private String locale;

	/** 客户端唯一标识 */
	@Size(min = 15, max = 128)
	@NotEmpty
	private String appKey;

	/**
	 * 客户端类型
	 * @see LKClientTypeEnum
	 */
	@NotEmpty
	@Pattern(regexp = "ANDROID|IOS|JAVASCRIPT|WINDOWS|MAC|LINUX|UNIX")
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

	/** 登录后获取得 */
	@Pattern(regexp = "(\\s&&[^\\f\\n\\r\\t\\v])*|\\w{64}")
	@NotNull
	private String token = "";

}
