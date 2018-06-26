package com.lichkin.framework.constraints;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.lichkin.framework.utils.LKMatcherUtils;
import com.lichkin.framework.utils.LKStringUtils;

public class MonthTester {

	@Test
	public void test() {
		for (int i = 1; i <= 12; i++) {
			assertTrue(LKMatcherUtils.matches(Month.REGEX, LKStringUtils.fillZero(i, 2)));
		}
	}

}
