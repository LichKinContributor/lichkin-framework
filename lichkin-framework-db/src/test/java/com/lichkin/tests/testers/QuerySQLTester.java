package com.lichkin.tests.testers;

import com.lichkin.framework.db.beans.Condition;
import com.lichkin.framework.db.beans.Order;
import com.lichkin.framework.db.beans.QuerySQL;
import com.lichkin.framework.db.beans.R;
import com.lichkin.framework.db.beans.SQLTester;
import com.lichkin.framework.db.beans.Sort;
import com.lichkin.framework.db.beans.eq;
import com.lichkin.framework.json.LKJsonUtils;
import com.lichkin.tests.beans.TestBean;
import com.lichkin.tests.beans.TestEntity;

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

		// SQL 以下三种含义相同
		QuerySQL sql = new QuerySQL(TestBean.class)
				// QuerySQL sql = new QuerySQL(TestBean.class, false)
				// QuerySQL sql = new QuerySQL(true, TestBean.class, false)

				// SQL DISTINCT 以下两种含义相同
				// QuerySQL sql = new QuerySQL(TestBean.class, true)
				// QuerySQL sql = new QuerySQL(true, TestBean.class, true)

				// HQL
				// QuerySQL sql = new QuerySQL(false, TestBean.class, false)

				// HQL DISTINCT
				// QuerySQL sql = new QuerySQL(false, TestBean.class, true)

				.select(R.TestBean.compId)

				.select(R.TestBean.compId, "compId")

				.select(columnResIds)

				.selectTable(TestBean.class, TestEntity.class)

				.innerJoin(TestBean.class, new Condition(true, new eq(R.TestBean.compId, "123")), conditions)

				.where(new Condition(true, new eq(R.TestBean.compId, "123")))

				.where(conditions)

				.where(new eq(R.TestBean.compId, "123"))

				.setSort(new Sort(new Order(R.TestBean.compId, true), new Order(R.TestBean.compId, false)))

				.addOrders(new Order(R.TestBean.compId, true), new Order(R.TestBean.compId, false))

		;

		System.out.println(sql.getSQL());
		System.out.println(LKJsonUtils.toJson(sql.getParams()));
	}

}
