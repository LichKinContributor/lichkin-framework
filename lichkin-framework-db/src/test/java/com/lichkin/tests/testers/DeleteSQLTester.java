package com.lichkin.tests.testers;

import com.lichkin.framework.db.beans.DeleteSQL;
import com.lichkin.framework.db.beans.SQLTester;
import com.lichkin.framework.json.LKJsonUtils;
import com.lichkin.tests.beans.TestBean;

public class DeleteSQLTester extends SQLTester {

	@SuppressWarnings("deprecation")
	@Override
	public void doTest() {
		// SQL
		DeleteSQL sql = new DeleteSQL(TestBean.class);
		// DeleteSQL sql = new DeleteSQL(true, TestBean.class);

		// HQL
		// DeleteSQL sql = new DeleteSQL(false, TestBean.class);

		// WHERE子句参见QuerySQL

		System.out.println(sql.getSQL());
		System.out.println(LKJsonUtils.toJson(sql.getParams()));
	}

}
