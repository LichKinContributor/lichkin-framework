package com.lichkin.framework.constraints;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.lichkin.framework.defines.LKFrameworkStatics;
import com.lichkin.framework.utils.LKMatcherUtils;
import com.lichkin.framework.utils.LKRandomUtils;

public class MixIDsTester {

	@Test
	public void test() {
		assertTrue(LKMatcherUtils.matches(MixIDs.REGEX, LKRandomUtils.create(32)));
		assertTrue(LKMatcherUtils.matches(MixIDs.REGEX, LKRandomUtils.create(32) + LKFrameworkStatics.SPLITOR + LKRandomUtils.create(32)));
		assertTrue(LKMatcherUtils.matches(MixIDs.REGEX, LKRandomUtils.create(32) + LKFrameworkStatics.SPLITOR + LKRandomUtils.create(32) + LKFrameworkStatics.SPLITOR));

		assertTrue(LKMatcherUtils.matches(MixIDs.REGEX, LKRandomUtils.create(64)));
		assertTrue(LKMatcherUtils.matches(MixIDs.REGEX, LKRandomUtils.create(64) + LKFrameworkStatics.SPLITOR + LKRandomUtils.create(64)));
		assertTrue(LKMatcherUtils.matches(MixIDs.REGEX, LKRandomUtils.create(64) + LKFrameworkStatics.SPLITOR + LKRandomUtils.create(64) + LKFrameworkStatics.SPLITOR));

		assertTrue(LKMatcherUtils.matches(MixIDs.REGEX, LKRandomUtils.create(32) + LKFrameworkStatics.SPLITOR + LKRandomUtils.create(64)));
		assertTrue(LKMatcherUtils.matches(MixIDs.REGEX, LKRandomUtils.create(64) + LKFrameworkStatics.SPLITOR + LKRandomUtils.create(32) + LKFrameworkStatics.SPLITOR));
	}

}
