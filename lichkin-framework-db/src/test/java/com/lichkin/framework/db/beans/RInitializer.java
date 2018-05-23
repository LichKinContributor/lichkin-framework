package com.lichkin.framework.db.beans;

/**
 * 数据库资源初始化类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class RInitializer {

	/**
	 * 初始化数据库资源
	 */
	public static void init() {
		LKDBResource.addTable("com.lichkin.tests.beans.TestEntity", "t_table_entity", "TestEntity");
		LKDBResource.addColumn("00010001", "TestEntity", "compId");
		LKDBResource.addColumn("00010002", "TestEntity", "deptId");
		LKDBResource.addColumn("00010003", "TestEntity", "superId");
		LKDBResource.addColumn("00010004", "TestEntity", "id");
		LKDBResource.addTable("com.lichkin.tests.beans.TestBean", "t_table_bean", "TestBean");
		LKDBResource.addColumn("00020001", "TestBean", "compId");
		LKDBResource.addColumn("00020002", "TestBean", "deptId");
		LKDBResource.addColumn("00020003", "TestBean", "superId");
		LKDBResource.addColumn("00020004", "TestBean", "id");
	}

}