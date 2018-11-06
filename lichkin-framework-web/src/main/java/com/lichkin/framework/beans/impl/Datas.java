package com.lichkin.framework.beans.impl;

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
import com.lichkin.framework.defines.entities.I_Comp;
import com.lichkin.framework.defines.entities.I_Login;
import com.lichkin.framework.defines.entities.I_User;
import com.lichkin.framework.defines.enums.impl.LKClientTypeEnum;

import lombok.Getter;
import lombok.Setter;

/**
 * 系统接口请求基本对象类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Getter
@Setter
public class Datas implements LKRequestInterface {

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
	private String appKey;

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

	/** 公司 */
	@Null
	private I_Comp comp;

	/** 公司ID */
	@MixID
	private String compId;

	/** 登录信息 */
	@Null
	private I_Login login;

	/** 登录ID */
	@Null
	private String loginId;

	/** 用户信息 */
	@Null
	private I_User user;

	/** 用户ID */
	@Null
	private String userId;

}
