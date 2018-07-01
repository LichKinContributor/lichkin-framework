package com.lichkin.framework.constraints;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.lichkin.framework.defines.LKFrameworkStatics;
import com.lichkin.framework.utils.LKMatcherUtils;
import com.lichkin.framework.utils.LKRandomUtils;

public class IDsTester {

	@Test
	public void test() {
		assertTrue(LKMatcherUtils.matches(IDs.REGEX, LKRandomUtils.create(32)));
		assertTrue(LKMatcherUtils.matches(IDs.REGEX, LKRandomUtils.create(32) + LKFrameworkStatics.SPLITOR + LKRandomUtils.create(32)));
		assertTrue(LKMatcherUtils.matches(IDs.REGEX, LKRandomUtils.create(32) + LKFrameworkStatics.SPLITOR + LKRandomUtils.create(32) + LKFrameworkStatics.SPLITOR));
	}

}
