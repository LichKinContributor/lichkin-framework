package com.lichkin.framework.defines.exceptions;

import java.util.Locale;

import org.junit.Test;

import com.lichkin.framework.defines.enums.impl.LKErrorCodesEnum;
import com.lichkin.framework.utils.i18n.LKI18NReader4ErrorCodes;

public class LKRuntimeExceptionTester {

	@Test
	public void test() {
		try {
			throw new LKRuntimeException(LKErrorCodesEnum.CONFIG_ERROR, Locale.SIMPLIFIED_CHINESE);
		} catch (LKRuntimeException e) {
			System.out.println(LKI18NReader4ErrorCodes.read(e.getLocale(), e.getErrorCode()));
		}

		try {
			throw new LKRuntimeException(LKErrorCodesEnum.CONFIG_ERROR, Locale.ENGLISH);
		} catch (LKRuntimeException e) {
			System.out.println(LKI18NReader4ErrorCodes.read(e.getLocale(), e.getErrorCode()));
		}

		try {
			throw new LKRuntimeException(LKErrorCodesEnum.CONFIG_ERROR, Locale.ENGLISH);
		} catch (LKRuntimeException e) {
			e.printStackTrace();
		}
	}

}
