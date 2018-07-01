package com.lichkin.framework.beans.impl;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import com.lichkin.framework.beans.LKRequestInterface;
import com.lichkin.framework.constraints.AppKey;
import com.lichkin.framework.constraints.ClientType;
import com.lichkin.framework.constraints.Locale;
import com.lichkin.framework.constraints.MixID;
import com.lichkin.framework.constraints.Token;
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
public class LKRequestBean implements LKRequestInterface {

	/**
	 * 国际化
	 * @see Locale
	 */
	@Locale
	@Null // 意思就是这个值客户端发送请求时是不能够使用的
	private String locale;

	/** 客户端唯一标识 */
	@Size(max = 128)
	@AppKey
	@NotBlank
	private String appKey;

	/**
	 * 客户端类型
	 * @see LKClientTypeEnum
	 */
	@ClientType
	@NotBlank
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
	@Token
	private String token;

	/** 公司ID */
	@MixID
	private String compId;


	@Override
	public LKClientTypeEnum getClientType() {
		return LKEnumUtils.getEnum(LKClientTypeEnum.class, clientType);
	}

}
