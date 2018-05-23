package com.lichkin.tests.testers;

import com.lichkin.framework.db.beans.Condition;
import com.lichkin.framework.db.beans.QuerySQL;
import com.lichkin.framework.db.beans.R;
import com.lichkin.framework.db.beans.SQLTester;
import com.lichkin.framework.db.beans.eq;
import com.lichkin.framework.json.LKJsonUtils;

public class QuerySQLTester extends SQLTester {

	@SuppressWarnings("deprecation")
	@Override
	public void doTest() {
		int[] columnResIds = new int[] {

				R.TestBean.compId,

				R.TestBean.compId

		};

		Condition[] conditions = new Condition[] {

				new Condition(true, new eq(R.TestBean.compId, "123")),

				new Condition(true, new eq(R.TestBean.compId, "123"))

		};

		QuerySQL sql = new QuerySQL(R.Table.TestBean)
				// QuerySQL sql = new QuerySQL(R.Table.TestBean, true)
				// QuerySQL sql = new QuerySQL(R.Table.TestBean, false)
				// QuerySQL sql = new QuerySQL(true, R.Table.TestBean, true)
				// QuerySQL sql = new QuerySQL(true, R.Table.TestBean, false)
				// QuerySQL sql = new QuerySQL(false, R.Table.TestBean, true)
				// QuerySQL sql = new QuerySQL(false, R.Table.TestBean, false)

				.select(R.TestBean.compId)

				.select(columnResIds)

				.innerJoin(R.Table.TestBean, new Condition(true, new eq(R.TestBean.compId, "123")), conditions)

				.where(new Condition(true, new eq(R.TestBean.compId, "123")))

				.where(conditions)

				.where(new eq(R.TestBean.compId, "123"));

		System.out.println(sql.getSQL());
		System.out.println(LKJsonUtils.toJson(sql.getParams()));
	}

}
