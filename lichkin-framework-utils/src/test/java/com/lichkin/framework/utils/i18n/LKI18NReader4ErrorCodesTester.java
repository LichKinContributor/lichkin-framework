package com.lichkin.framework.utils.i18n;

import static org.junit.Assert.assertEquals;

import java.util.Locale;

import org.junit.Test;

import com.lichkin.framework.defines.enums.impl.LKErrorCodesEnum;

public class LKI18NReader4ErrorCodesTester {

	@Test
	public void test() {
		assertEquals(LKI18NReader4ErrorCodes.read(Locale.SIMPLIFIED_CHINESE, LKErrorCodesEnum.INTERNAL_SERVER_ERROR), "服务器未捕获异常。");
		assertEquals(LKI18NReader4ErrorCodes.read(Locale.ENGLISH, LKErrorCodesEnum.INTERNAL_SERVER_ERROR), "internal server error.");
	}

}
