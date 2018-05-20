package com.lichkin.tests.beans;

import com.lichkin.framework.db.annotations.Table;

import lombok.Getter;

@Getter
@Table(name = "t_table_entity")
public class TestEntity {

	private String compId;

	private String deptId;

}
