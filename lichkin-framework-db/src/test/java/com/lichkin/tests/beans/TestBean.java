package com.lichkin.tests.beans;

import com.lichkin.framework.db.annotations.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "t_table_bean")
public class TestBean extends SuperBean {

	/** serialVersionUID */
	private static final long serialVersionUID = 3L;

	private String compId;

	private String deptId;

}
