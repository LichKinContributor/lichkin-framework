package com.lichkin.framework.constraints;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.lichkin.framework.utils.LKMatcherUtils;

public class YearTester {

	@Test
	public void test() {
		for (int i = 1900; i <= 2099; i++) {
			assertTrue(LKMatcherUtils.matches(Year.REGEX, String.valueOf(i)));
		}
	}

}
