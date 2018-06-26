package com.lichkin.framework.constraints;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.lichkin.framework.utils.LKMatcherUtils;
import com.lichkin.framework.utils.LKStringUtils;

public class DayTester {

	@Test
	public void test() {
		for (int i = 1; i <= 31; i++) {
			assertTrue(LKMatcherUtils.matches(Day.REGEX, LKStringUtils.fillZero(i, 2)));
		}
	}

}
