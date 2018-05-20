package com.lichkin.tests.beans;

import com.lichkin.framework.db.annotations.Table;

import lombok.Getter;

@Getter
@Table(name = "t_table_bean")
public class TestBean {

	private String compId;

	private String deptId;

}
