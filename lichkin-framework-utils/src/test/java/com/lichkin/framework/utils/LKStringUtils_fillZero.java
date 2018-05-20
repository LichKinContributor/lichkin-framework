package com.lichkin.framework.utils;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LKStringUtils_fillZero {

	@Test
	public void test() {
		assertEquals(LKStringUtils.fillZero("3", 1, true), "3");
		assertEquals(LKStringUtils.fillZero("3", 2, true), "03");
		assertEquals(LKStringUtils.fillZero("33", 1, true), "33");
		assertEquals(LKStringUtils.fillZero("33", 2, true), "33");
		assertEquals(LKStringUtils.fillZero("33", 3, true), "033");
		assertEquals(LKStringUtils.fillZero("3", 1, false), "3");
		assertEquals(LKStringUtils.fillZero("3", 2, false), "30");
		assertEquals(LKStringUtils.fillZero("33", 1, false), "33");
		assertEquals(LKStringUtils.fillZero("33", 2, false), "33");
		assertEquals(LKStringUtils.fillZero("33", 3, false), "330");
	}

}
