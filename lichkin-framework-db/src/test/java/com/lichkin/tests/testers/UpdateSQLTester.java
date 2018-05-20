package com.lichkin.tests.testers;

import com.lichkin.framework.db.beans.Condition;
import com.lichkin.framework.db.beans.R;
import com.lichkin.framework.db.beans.SQLTester;
import com.lichkin.framework.db.beans.UpdateSQL;
import com.lichkin.framework.db.beans.eq;

public class UpdateSQLTester extends SQLTester {

	@Override
	public void doTest() {
		eq[] updates = new eq[] {

				new eq(R.TestBean.compId, "123"),

				new eq(R.TestBean.compId, "123")

		};

		Condition[] conditions = new Condition[] {

				new Condition(true, new eq(R.TestBean.compId, "123")),

				new Condition(true, new eq(R.TestBean.compId, "123"))

		};

		printSQL(

				new UpdateSQL(R.Table.TestBean)

						.update(new eq(R.TestBean.compId, "123"))

						.update(updates)

						.where(new Condition(true, new eq(R.TestBean.compId, "123")))

						.where(conditions)

		);
		System.out.println();
	}

}
