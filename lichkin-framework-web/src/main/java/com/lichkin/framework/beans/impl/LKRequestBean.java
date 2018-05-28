package com.lichkin.framework.beans.impl;

import java.util.Locale;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.lichkin.framework.defines.LKRegexPatternStatics;
import com.lichkin.framework.defines.enums.impl.LKClientTypeEnum;
import com.lichkin.framework.utils.LKEnumUtils;

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
class LKRequestBean {

	/**
	 * 国际化
	 * @see Locale
	 */
	@Pattern(regexp = "([A-Za-z]{2}){1}(_[A-Za-z]{2})?")
	@Null // 意思就是这个值客户端发送请求时是不能够使用的
	private String locale;

	/** 客户端唯一标识 */
	@Size(max = 128)
	@Pattern(regexp = "com\\.lichkin\\.app\\.(ios|android|javascript)\\.[a-zA-Z0-9]+(\\.[a-zA-Z0-9]+)*")
	@NotNull
	private String appKey;

	/**
	 * 客户端类型
	 * @see LKClientTypeEnum
	 */
	@Pattern(regexp = "(ANDROID|IOS|JAVASCRIPT|WINDOWS|MAC|LINUX|UNIX){1}")
	@NotNull
	private String clientType;

	/** 客户端版本号（大版本号） */
	@Pattern(regexp = LKRegexPatternStatics.POSITIVE_INTEGER)
	@NotNull
	private String versionX;

	/** 客户端版本号（中版本号） */
	@Pattern(regexp = LKRegexPatternStatics.POSITIVE_INTEGER_OR_ZERO)
	@NotNull
	private String versionY;

	/** 客户端版本号（小版本号） */
	@Pattern(regexp = LKRegexPatternStatics.POSITIVE_INTEGER_OR_ZERO)
	@NotNull
	private String versionZ;


	public LKClientTypeEnum getClientType() {
		return LKEnumUtils.getEnum(LKClientTypeEnum.class, clientType);
	}


	public byte getVersionX() {
		return Byte.parseByte(versionX);
	}


	public byte getVersionY() {
		return Byte.parseByte(versionY);
	}


	public short getVersionZ() {
		return Short.parseShort(versionZ);
	}

}
