package com.lichkin.tests.testers;

import com.lichkin.framework.db.beans.R;
import com.lichkin.framework.db.beans.SQLTester;
import com.lichkin.framework.db.beans.UpdateSQL;
import com.lichkin.framework.json.LKJsonUtils;
import com.lichkin.tests.beans.TestBean;

public class UpdateSQLTester extends SQLTester {

	@SuppressWarnings("deprecation")
	@Override
	public void doTest() {
		// SQL
		UpdateSQL sql = new UpdateSQL(TestBean.class);
		// UpdateSQL sql = new UpdateSQL(true, TestBean.class);

		// HQL
		// UpdateSQL sql = new UpdateSQL(false, TestBean.class);

		sql.set(R.TestBean.compId, "123");
		sql.set(R.TestBean.compId, "123");

		// WHERE子句参见QuerySQL

		System.out.println(sql.getSQL());
		System.out.println(LKJsonUtils.toJson(sql.getParams()));
	}

}
