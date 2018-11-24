package com.lichkin.framework.beans.impl;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import com.lichkin.framework.constraints.AppKey;
import com.lichkin.framework.constraints.ClientType;
import com.lichkin.framework.constraints.MixID;
import com.lichkin.framework.constraints.Token;
import com.lichkin.framework.defines.beans.LKInvokeDatas;
import com.lichkin.framework.defines.enums.impl.LKClientTypeEnum;

import lombok.Getter;
import lombok.Setter;

/**
 * 系统接口请求基本对象类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Getter
@Setter
public class Datas implements LKInvokeDatas {

	/** 客户端唯一标识 */
	@Size(max = 128)
	@AppKey
	private String appKey;


	@Override
	public String getAppKey() {
		return appKey.replaceAll(AppKey.PREFIX, "");
	}


	/**
	 * 客户端类型
	 * @see LKClientTypeEnum
	 */
	@ClientType
	private LKClientTypeEnum clientType;

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

	/** 令牌 */
	@Token
	private String token;

	/** 公司令牌 */
	@MixID
	private String compToken;

}
