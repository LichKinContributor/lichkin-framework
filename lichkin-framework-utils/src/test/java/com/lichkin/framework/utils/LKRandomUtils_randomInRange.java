package com.lichkin.framework.utils;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class LKRandomUtils_randomInRange {

	@Test
	public void test() {
		for (int i = 0; i < 10000; i++) {
			assertTrue(LKRandomUtils.randomInRange(1, 1) == 1);
			int value = LKRandomUtils.randomInRange(0, 1);
			assertTrue((value == 0) || (value == 1));
			int value2 = LKRandomUtils.randomInRange(5, 9);
			assertTrue((value2 >= 5) || (value2 <= 9));
		}
	}

}
