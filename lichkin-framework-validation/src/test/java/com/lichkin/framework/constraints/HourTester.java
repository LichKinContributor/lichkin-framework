package com.lichkin.framework.constraints;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.lichkin.framework.utils.LKMatcherUtils;
import com.lichkin.framework.utils.LKStringUtils;

public class HourTester {

	@Test
	public void test() {
		for (int i = 0; i <= 23; i++) {
			assertTrue(LKMatcherUtils.matches(Hour.REGEX, LKStringUtils.fillZero(i, 2)));
		}
	}

}
