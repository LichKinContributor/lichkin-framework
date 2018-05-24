package com.lichkin.framework.db.beans;

import java.lang.reflect.InvocationTargetException;

import org.junit.Before;
import org.junit.Test;

import com.lichkin.framework.json.LKJsonUtils;

public abstract class SQLTester {

	@Before
	public void before() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
		LKDBResource.load();
	}


	@Test
	public void test() {
		doTest();
	}


	public abstract void doTest();


	public void printSQL(__SQL sql) {
		System.out.println(sql.getSQL(true));
		if (sql instanceof ExpIn) {
			System.out.println("params:" + LKJsonUtils.toJson(((ExpIn) sql).params));
		} else if (sql instanceof ExpLike) {
			System.out.println("params:" + LKJsonUtils.toJson(((ExpLike) sql).param));
		} else if (sql instanceof ExpCompare) {
			if (((ExpCompare) sql).withParam) {
				System.out.println("params:" + LKJsonUtils.toJson(((ExpCompare) sql).param));
			}
		} else if (sql instanceof Condition) {
			System.out.println("params:" + LKJsonUtils.toJson(((Condition) sql).getParams()));
		}
	}

}
