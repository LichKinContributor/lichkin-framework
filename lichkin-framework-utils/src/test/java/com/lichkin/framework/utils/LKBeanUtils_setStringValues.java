package com.lichkin.framework.utils;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.lichkin.framework.beans.sources.SSS;
import com.lichkin.framework.beans.targetes.TTT;
import com.lichkin.framework.defines.LKFrameworkStatics;

public class LKBeanUtils_setStringValues {

	@Test
	public void test() {
		List<SSS> listSource = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			SSS sss = new SSS("id_" + i, "name_" + i);
			listSource.add(sss);
		}

		TTT target = new TTT();
		LKBeanUtils.setStringValues(listSource, target,

				new String[] { "id", "name" },

				new String[] { "ids", "names" },

				new String[] { LKFrameworkStatics.SPLITOR, "," }

		);

		System.err.println(target);
	}

}
