package com.lichkin.framework.constraints;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.lichkin.framework.utils.LKMatcherUtils;
import com.lichkin.framework.utils.LKStringUtils;

public class MillisecondsTester {

	@Test
	public void test() {
		for (int i = 0; i <= 999; i++) {
			assertTrue(LKMatcherUtils.matches(Milliseconds.REGEX, LKStringUtils.fillZero(i, 3)));
		}
	}

}
