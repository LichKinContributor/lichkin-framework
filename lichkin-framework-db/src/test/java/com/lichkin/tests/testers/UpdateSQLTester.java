package com.lichkin.tests.testers;

import com.lichkin.framework.db.beans.Condition;
import com.lichkin.framework.db.beans.R;
import com.lichkin.framework.db.beans.SQLTester;
import com.lichkin.framework.db.beans.UpdateSQL;
import com.lichkin.framework.db.beans.eq;
import com.lichkin.framework.json.LKJsonUtils;
import com.lichkin.tests.beans.TestBean;

public class UpdateSQLTester extends SQLTester {

	@SuppressWarnings("deprecation")
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

		UpdateSQL sql = new UpdateSQL(TestBean.class)

				.update(new eq(R.TestBean.compId, "123"))

				.update(updates)

				.where(new Condition(true, new eq(R.TestBean.compId, "123")))

				.where(conditions)

				.where(new eq(R.TestBean.compId, "123"));

		System.out.println(sql.getSQL());
		System.out.println(LKJsonUtils.toJson(sql.getParams()));
	}

}