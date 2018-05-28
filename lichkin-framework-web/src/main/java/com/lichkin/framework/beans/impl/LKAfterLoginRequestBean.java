package com.lichkin.framework.beans.impl;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.lichkin.framework.beans.LKRequestInterface;

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
public class LKAfterLoginRequestBean extends LKRequestBean implements LKRequestInterface {

	/** 登录后获取得 */
	@Pattern(regexp = "\\w{64}")
	@NotNull
	private String token;

}
