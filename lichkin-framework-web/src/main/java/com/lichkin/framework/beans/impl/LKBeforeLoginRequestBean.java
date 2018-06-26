package com.lichkin.framework.beans.impl;

import com.lichkin.framework.beans.LKRequestInterface;
import com.lichkin.framework.constraints.Token;

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
@ToString(callSuper = true)
@NoArgsConstructor
public class LKBeforeLoginRequestBean extends LKRequestBean implements LKRequestInterface {

	/** 登录后获取得 */
	@Token
	private String token;

}
