package com.lichkin.tests.testers;

import static com.lichkin.framework.defines.LKFrameworkStatics.SPLITOR;

import com.lichkin.framework.db.beans.Condition;
import com.lichkin.framework.db.beans.Order;
import com.lichkin.framework.db.beans.QuerySQL;
import com.lichkin.framework.db.beans.R;
import com.lichkin.framework.db.beans.SQLTester;
import com.lichkin.framework.db.beans.Sort;
import com.lichkin.framework.db.beans.eq;
import com.lichkin.framework.db.enums.LikeType;
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

		Condition conditions = new Condition(true,

				new Condition(true, new eq(R.TestBean.compId, "123")),

				new Condition(false, new eq(R.TestBean.compId, "123"))

		);

		// SQL 以下三种含义相同
		QuerySQL sql = new QuerySQL(TestBean.class);
		// QuerySQL sql = new QuerySQL(TestBean.class, false);
		// QuerySQL sql = new QuerySQL(true, TestBean.class, false);

		// SQL DISTINCT 以下两种含义相同
		// QuerySQL sql = new QuerySQL(TestBean.class, true);
		// QuerySQL sql = new QuerySQL(true, TestBean.class, true);

		// HQL
		// QuerySQL sql = new QuerySQL(false, TestBean.class, false);

		// HQL DISTINCT
		// QuerySQL sql = new QuerySQL(false, TestBean.class, true);

		// HQL语句暂不支持列选择
		sql.select(R.TestBean.compId);
		sql.select(R.TestBean.compId, "compId");
		sql.select(columnResIds);
		sql.selectTable(TestBean.class, TestEntity.class);

		sql.innerJoin(TestBean.class, new Condition(true, new eq(R.TestBean.compId, "123")), conditions);

		sql.where(conditions);
		appendExp(sql);

		sql.setSort(new Sort(new Order(R.TestBean.compId, true), new Order(R.TestBean.compId, false)));

		sql.addOrders(new Order(R.TestBean.compId, true), new Order(R.TestBean.compId, false));

		System.out.println(sql.getSQL());
		System.out.println(LKJsonUtils.toJson(sql.getParams()));
	}


	void appendExp(QuerySQL sql) {
		// IN语法参数需要使用框架约定的LKFrameworkStatics.SPLITOR拼接的参数
		String paramsStr = "a" + SPLITOR + "b" + SPLITOR + "c";
		sql.in(R.TestBean.compId, paramsStr);
		sql.notIn(R.TestBean.compId, paramsStr);

		// IS NULL语法不需要参数
		sql.isNull(R.TestBean.compId);
		sql.isNotNull(R.TestBean.compId);

		// LIKE语法需要额外传递模糊匹配类型
		sql.like(R.TestBean.compId, LikeType.LEFT, "H");
		sql.like(R.TestBean.compId, LikeType.RIGHT, "H");
		sql.like(R.TestBean.compId, LikeType.ALL, "H");
		sql.notLike(R.TestBean.compId, LikeType.LEFT, "H");
		sql.notLike(R.TestBean.compId, LikeType.RIGHT, "H");
		sql.notLike(R.TestBean.compId, LikeType.ALL, "H");

		// 比较语法
		sql.eq(R.TestBean.compId, 123);
		sql.neq(R.TestBean.compId, 123);
		sql.gt(R.TestBean.compId, 123);
		sql.gte(R.TestBean.compId, 123);
		sql.lt(R.TestBean.compId, 123);
		sql.lte(R.TestBean.compId, 123);

		// 两表间关联的表达式使用$结尾的表达式类
		sql.eq_(R.TestBean.compId, R.TestBean.compId);
		sql.neq_(R.TestBean.compId, R.TestBean.compId);
		sql.gt_(R.TestBean.compId, R.TestBean.compId);
		sql.gte_(R.TestBean.compId, R.TestBean.compId);
		sql.lt_(R.TestBean.compId, R.TestBean.compId);
		sql.lte_(R.TestBean.compId, R.TestBean.compId);
	}

}
