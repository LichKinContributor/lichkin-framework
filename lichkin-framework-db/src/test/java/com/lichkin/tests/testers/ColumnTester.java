package com.lichkin.tests.testers;

import com.lichkin.framework.db.beans.Condition;
import com.lichkin.framework.db.beans.R;
import com.lichkin.framework.db.beans.SQLTester;
import com.lichkin.framework.db.beans.eq;

public class ColumnTester extends SQLTester {

	@Override
	public void doTest() {
		printSQL(new Condition(true, new eq(R.TestBean.compId, 123)));
		printSQL(new Condition(false, new eq(R.TestBean.compId, 123)));
		printSQL(new Condition(null, new eq(R.TestBean.compId, 123)));
		System.out.println();

		printSQL(

				new Condition(true,

						new Condition(true, new eq(R.TestBean.compId, 123)),

						new Condition(false, new eq(R.TestBean.compId, 123))

				)

		);
		System.out.println();

		printSQL(

				new Condition(true,

						new Condition(true, new eq(R.TestBean.compId, 123)),

						new Condition(false, new eq(R.TestBean.compId, 123)),

						new Condition(true,

								new Condition(true, new eq(R.TestBean.compId, 123)),

								new Condition(false, new eq(R.TestBean.compId, 123))

						)

				)

		);
	}

}
