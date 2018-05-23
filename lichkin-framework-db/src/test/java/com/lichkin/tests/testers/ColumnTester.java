package com.lichkin.tests.testers;

import com.lichkin.framework.db.beans.Condition;
import com.lichkin.framework.db.beans.R;
import com.lichkin.framework.db.beans.SQLTester;
import com.lichkin.framework.db.beans.in;

public class ColumnTester extends SQLTester {

	@Override
	public void doTest() {
		printSQL(new Condition(true, new in(R.TestBean.compId, "a#@#b#@#c")));
		printSQL(new Condition(false, new in(R.TestBean.compId, "a#@#b#@#c")));
		printSQL(new Condition(null, new in(R.TestBean.compId, "a#@#b#@#c")));
		System.out.println();

		printSQL(

				new Condition(true,

						new Condition(true, new in(R.TestBean.compId, "a#@#b#@#c")),

						new Condition(false, new in(R.TestBean.compId, "a#@#b#@#c"))

				)

		);
		System.out.println();

		printSQL(

				new Condition(true,

						new Condition(true, new in(R.TestBean.compId, "a#@#b#@#c")),

						new Condition(false, new in(R.TestBean.compId, "a#@#b#@#c")),

						new Condition(true,

								new Condition(true, new in(R.TestBean.compId, "a#@#b#@#c")),

								new Condition(false, new in(R.TestBean.compId, "a#@#b#@#c"))

						)

				)

		);
	}

}
