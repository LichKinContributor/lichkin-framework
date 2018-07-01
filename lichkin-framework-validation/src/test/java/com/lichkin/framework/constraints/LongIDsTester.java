package com.lichkin.framework.constraints;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.lichkin.framework.defines.LKFrameworkStatics;
import com.lichkin.framework.utils.LKMatcherUtils;
import com.lichkin.framework.utils.LKRandomUtils;

public class LongIDsTester {

	@Test
	public void test() {
		assertTrue(LKMatcherUtils.matches(LongIDs.REGEX, LKRandomUtils.create(64)));
		assertTrue(LKMatcherUtils.matches(LongIDs.REGEX, LKRandomUtils.create(64) + LKFrameworkStatics.SPLITOR + LKRandomUtils.create(64)));
		assertTrue(LKMatcherUtils.matches(LongIDs.REGEX, LKRandomUtils.create(64) + LKFrameworkStatics.SPLITOR + LKRandomUtils.create(64) + LKFrameworkStatics.SPLITOR));
	}

}
