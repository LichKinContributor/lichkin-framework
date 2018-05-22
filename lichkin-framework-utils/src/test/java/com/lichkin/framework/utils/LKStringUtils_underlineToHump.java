package com.lichkin.framework.utils;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LKStringUtils_underlineToHump {

	@Test
	public void test() {
		assertEquals(LKStringUtils.underlineToHump("abcdefghijk"), "abcdefghijk");
		assertEquals(LKStringUtils.underlineToHump("ABCDEFGHIJK"), "abcdefghijk");
		assertEquals(LKStringUtils.underlineToHump("Abcdefghijk"), "Abcdefghijk");
		assertEquals(LKStringUtils.underlineToHump("abcdefghijK"), "abcdefghijK");
		assertEquals(LKStringUtils.underlineToHump("abcde_Fghijk"), "abcdeFghijk");
		assertEquals(LKStringUtils.underlineToHump("Abcde_FghijK"), "AbcdeFghijK");
		assertEquals(LKStringUtils.underlineToHump("1abcdefghijk"), "1abcdefghijk");
		assertEquals(LKStringUtils.underlineToHump("abcdefghijk1"), "abcdefghijk1");
		assertEquals(LKStringUtils.underlineToHump("abcde1fghijk"), "abcde1fghijk");
		assertEquals(LKStringUtils.underlineToHump("1abcde1fghijk1"), "1abcde1fghijk1");
		assertEquals(LKStringUtils.underlineToHump("1abcde1_Fghijk1"), "1abcde1Fghijk1");
		assertEquals(LKStringUtils.underlineToHump("1abcde1_FGhijk1"), "1abcde1FGhijk1");
		assertEquals(LKStringUtils.underlineToHump("1ab_Cde1_FGhijk1"), "1abCde1FGhijk1");
		assertEquals(LKStringUtils.underlineToHump("USING_STATUS"), "usingStatus");
	}

}
