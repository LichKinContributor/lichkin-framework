package com.lichkin.framework.utils.i18n;

import static org.junit.Assert.assertEquals;

import java.util.Locale;

import org.junit.Test;

import com.lichkin.framework.defines.enums.impl.LKDateTimeTypeEnum;

public class LKI18NReader4DateTimeTypeTester {

	@Test
	public void test() {
		assertEquals(LKI18NReader4DateTimeType.read(Locale.SIMPLIFIED_CHINESE, LKDateTimeTypeEnum.STANDARD), "yyyy年MM月dd日HH时mm分ss秒");
		assertEquals(LKI18NReader4DateTimeType.read(Locale.ENGLISH, LKDateTimeTypeEnum.STANDARD), "yyyy-MM-dd HH:mm:ss");
	}

}
