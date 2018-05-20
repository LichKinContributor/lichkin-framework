package com.lichkin.framework.db.beans;

import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.Before;
import org.junit.Test;

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
		System.out.println(sql);
	}

}
