package com.lichkin.tests.testers;

import com.lichkin.framework.db.beans.Condition;
import com.lichkin.framework.db.beans.DeleteSQL;
import com.lichkin.framework.db.beans.R;
import com.lichkin.framework.db.beans.SQLTester;
import com.lichkin.framework.db.beans.eq;
import com.lichkin.framework.json.LKJsonUtils;

public class DeleteSQLTester extends SQLTester {

	@SuppressWarnings("deprecation")
	@Override
	public void doTest() {
		Condition[] conditions = new Condition[] {

				new Condition(true, new eq(R.TestBean.compId, "123")),

				new Condition(true, new eq(R.TestBean.compId, "123"))

		};

		DeleteSQL sql = new DeleteSQL(R.Table.TestBean)

				.where(new Condition(true, new eq(R.TestBean.compId, "123")))

				.where(conditions)

				.where(new eq(R.TestBean.compId, "123"));

		System.out.println(sql.getSQL());
		System.out.println(LKJsonUtils.toJson(sql.getParams()));
	}

}
