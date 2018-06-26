package com.lichkin.framework.constraints;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.lichkin.framework.utils.LKMatcherUtils;
import com.lichkin.framework.utils.LKStringUtils;

public class SecondsTester {

	@Test
	public void test() {
		for (int i = 0; i <= 59; i++) {
			assertTrue(LKMatcherUtils.matches(Seconds.REGEX, LKStringUtils.fillZero(i, 2)));
		}
	}

}
