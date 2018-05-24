package com.lichkin.tests.testers;

import static com.lichkin.framework.defines.LKFrameworkStatics.SPLITOR;

import com.lichkin.framework.db.beans.R;
import com.lichkin.framework.db.beans.SQLTester;
import com.lichkin.framework.db.beans.eq;
import com.lichkin.framework.db.beans.eq$;
import com.lichkin.framework.db.beans.gt;
import com.lichkin.framework.db.beans.gt$;
import com.lichkin.framework.db.beans.gte;
import com.lichkin.framework.db.beans.gte$;
import com.lichkin.framework.db.beans.in;
import com.lichkin.framework.db.beans.isNotNull;
import com.lichkin.framework.db.beans.isNull;
import com.lichkin.framework.db.beans.like;
import com.lichkin.framework.db.beans.lt;
import com.lichkin.framework.db.beans.lt$;
import com.lichkin.framework.db.beans.lte;
import com.lichkin.framework.db.beans.lte$;
import com.lichkin.framework.db.beans.neq;
import com.lichkin.framework.db.beans.neq$;
import com.lichkin.framework.db.beans.notIn;
import com.lichkin.framework.db.beans.notLike;
import com.lichkin.framework.db.enums.LikeType;

public class ExpTester extends SQLTester {

	@Override
	public void doTest() {
		// IN语法参数需要使用框架约定的LKFrameworkStatics.SPLITOR拼接的参数
		String paramsStr = "a" + SPLITOR + "b" + SPLITOR + "c";

		printSQL(new in(R.TestBean.compId, paramsStr));
		printSQL(new notIn(R.TestBean.compId, paramsStr));
		System.out.println();

		// IS NULL语法不需要参数
		printSQL(new isNull(R.TestBean.compId));
		printSQL(new isNotNull(R.TestBean.compId));
		System.out.println();

		// LIKE语法需要额外传递模糊匹配类型
		printSQL(new like(R.TestBean.compId, LikeType.LEFT, "H"));
		printSQL(new like(R.TestBean.compId, LikeType.RIGHT, "H"));
		printSQL(new like(R.TestBean.compId, LikeType.ALL, "H"));
		printSQL(new notLike(R.TestBean.compId, LikeType.LEFT, "H"));
		printSQL(new notLike(R.TestBean.compId, LikeType.RIGHT, "H"));
		printSQL(new notLike(R.TestBean.compId, LikeType.ALL, "H"));
		System.out.println();

		// 比较语法
		printSQL(new eq(R.TestBean.compId, 123));
		printSQL(new neq(R.TestBean.compId, 123));
		printSQL(new gt(R.TestBean.compId, 123));
		printSQL(new gte(R.TestBean.compId, 123));
		printSQL(new lt(R.TestBean.compId, 123));
		printSQL(new lte(R.TestBean.compId, 123));
		System.out.println();

		// 两表间关联的表达式使用$结尾的表达式类
		printSQL(new eq$(R.TestBean.compId, R.TestBean.compId));
		printSQL(new neq$(R.TestBean.compId, R.TestBean.compId));
		printSQL(new gt$(R.TestBean.compId, R.TestBean.compId));
		printSQL(new gte$(R.TestBean.compId, R.TestBean.compId));
		printSQL(new lt$(R.TestBean.compId, R.TestBean.compId));
		printSQL(new lte$(R.TestBean.compId, R.TestBean.compId));
		System.out.println();
	}

}
