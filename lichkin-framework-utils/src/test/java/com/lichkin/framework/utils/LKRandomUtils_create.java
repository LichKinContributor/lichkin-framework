package com.lichkin.framework.utils;

import org.junit.Test;

public class LKRandomUtils_create {

	@Test
	public void test() {
		for (int i = 0; i < 10000; i++) {
			System.out.println(LKRandomUtils.create(32));
		}
	}

}
