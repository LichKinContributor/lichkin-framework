package com.lichkin.tests.testers;

import static com.lichkin.framework.defines.LKFrameworkStatics.SPLITOR;

import org.junit.Test;

import com.lichkin.framework.db.beans.SQL;
import com.lichkin.framework.db.enums.LikeType;
import com.lichkin.framework.json.LKJsonUtils;

public class SQLTester {

	@SuppressWarnings("deprecation")
	@Test
	public void test() {
		// IN语法参数需要使用框架约定的LKFrameworkStatics.SPLITOR拼接的参数
		String paramsStr = "a" + SPLITOR + "b" + SPLITOR + "c";

		SQL sql = new SQL(true);

		sql.appendSQL("select * from t_demo where a = ?");
		sql.addParam("1");

		sql.and("1 = 1");
		sql.or("1 = 1");

		sql.in(true, "a", paramsStr);
		sql.notIn(false, "a", paramsStr);

		sql.isNull(true, "a");
		sql.isNotNull(false, "a");

		sql.like(true, "a", LikeType.LEFT, "H");
		sql.like(false, "a", LikeType.RIGHT, "H");
		sql.like(true, "a", LikeType.ALL, "H");
		sql.notLike(false, "a", LikeType.LEFT, "H");
		sql.notLike(true, "a", LikeType.RIGHT, "H");
		sql.notLike(false, "a", LikeType.ALL, "H");

		sql.eq(true, "a", "1");
		sql.neq(true, "a", "1");
		sql.gt(true, "a", "1");
		sql.gte(true, "a", "1");
		sql.lt(true, "a", "1");
		sql.lte(true, "a", "1");

		System.out.println(sql.getSQL());
		System.out.println(LKJsonUtils.toJson(sql.getParams()));
	}

}
