package com.lichkin.framework.utils.i18n;

import static org.junit.Assert.assertEquals;

import java.util.Locale;

import org.junit.Test;

public class LKI18NUtilsTester {

	@Test
	public void test() {
		assertEquals(LKI18NUtils.getString(Locale.SIMPLIFIED_CHINESE, "testFile", "testKey"), "测试");
		assertEquals(LKI18NUtils.getString(Locale.US, "testFile", "testKey"), "test");
		assertEquals(LKI18NUtils.getString(Locale.UK, "testFile", "testKey"), "test");
		assertEquals(LKI18NUtils.getString(Locale.CANADA, "testFile", "testKey"), "test");
		assertEquals(LKI18NUtils.getString(Locale.ENGLISH, "testFile", "testKey"), "test");
	}

}
