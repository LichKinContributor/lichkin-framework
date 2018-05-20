package com.lichkin.tests.testers;

import com.lichkin.framework.db.beans.Column;
import com.lichkin.framework.db.beans.Condition;
import com.lichkin.framework.db.beans.QuerySQL;
import com.lichkin.framework.db.beans.R;
import com.lichkin.framework.db.beans.SQLTester;
import com.lichkin.framework.db.beans.eq;

public class QuerySQLTester extends SQLTester {

	@Override
	public void doTest() {
		Column[] columns = new Column[] {

				new Column(R.TestBean.compId),

				new Column(R.TestBean.compId)

		};

		Condition[] conditions = new Condition[] {

				new Condition(true, new eq(R.TestBean.compId, "123")),

				new Condition(true, new eq(R.TestBean.compId, "123"))

		};

		printSQL(

				new QuerySQL(R.Table.TestBean, true)

						.select(new Column(R.TestBean.compId))

						.select(columns)

						.innerJoin(R.Table.TestBean, new Condition(true, new eq(R.TestBean.compId, "123")), conditions)

						.where(new Condition(true, new eq(R.TestBean.compId, "123")))

						.where(conditions)

		);
		System.out.println();
	}

}
