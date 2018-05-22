package com.lichkin.framework.db.beans;

import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.Before;
import org.junit.Test;

import com.lichkin.framework.json.LKJsonUtils;

public abstract class SQLTester {

	@Before
	public void before() throws ClassNotFoundException, IOException, URISyntaxException {
		LKDBResource.init();
	}


	@Test
	public void test() {
		doTest();
	}


	public abstract void doTest();


	public void printSQL(__SQL sql) {
		System.out.println(sql.getSQL(true));
		if (sql instanceof ExpIn) {
			System.out.println("params:" + LKJsonUtils.toJson(((ExpIn) sql).getParams()));
		} else if (sql instanceof ExpLike) {
			System.out.println("params:" + LKJsonUtils.toJson(((ExpLike) sql).getParam()));
		} else if (sql instanceof ExpCompare) {
			if (((ExpCompare) sql).isWithParam()) {
				System.out.println("params:" + LKJsonUtils.toJson(((ExpCompare) sql).getParam()));
			}
		} else if (sql instanceof Condition) {
			System.out.println("params:" + LKJsonUtils.toJson(((Condition) sql).getParams()));
		}
	}

}
