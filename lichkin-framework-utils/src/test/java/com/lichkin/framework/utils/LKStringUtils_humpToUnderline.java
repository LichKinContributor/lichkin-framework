package com.lichkin.framework.utils;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LKStringUtils_humpToUnderline {

	@Test
	public void test() {
		assertEquals(LKStringUtils.humpToUnderline("abcdefghijk"), "ABCDEFGHIJK");
		assertEquals(LKStringUtils.humpToUnderline("Abcdefghijk"), "ABCDEFGHIJK");
		assertEquals(LKStringUtils.humpToUnderline("abcdefghijK"), "ABCDEFGHIJK");
		assertEquals(LKStringUtils.humpToUnderline("abcdeFghijk"), "ABCDE_FGHIJK");
		assertEquals(LKStringUtils.humpToUnderline("AbcdeFghijK"), "ABCDE_FGHIJK");
		assertEquals(LKStringUtils.humpToUnderline("1abcdefghijk"), "1ABCDEFGHIJK");
		assertEquals(LKStringUtils.humpToUnderline("abcdefghijk1"), "ABCDEFGHIJK1");
		assertEquals(LKStringUtils.humpToUnderline("abcde1fghijk"), "ABCDE1FGHIJK");
		assertEquals(LKStringUtils.humpToUnderline("1abcde1fghijk1"), "1ABCDE1FGHIJK1");
		assertEquals(LKStringUtils.humpToUnderline("1abcde1Fghijk1"), "1ABCDE1_FGHIJK1");
		assertEquals(LKStringUtils.humpToUnderline("1abcde1FGhijk1"), "1ABCDE1_FGHIJK1");
		assertEquals(LKStringUtils.humpToUnderline("1abCde1FGhijk1"), "1AB_CDE1_FGHIJK1");
		assertEquals(LKStringUtils.humpToUnderline("usingStatus"), "USING_STATUS");
	}

}
