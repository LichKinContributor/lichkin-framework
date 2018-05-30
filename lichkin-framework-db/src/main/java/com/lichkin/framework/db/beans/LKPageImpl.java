package com.lichkin.framework.db.beans;

import lombok.Setter;

/**
 * 分页信息对象
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Setter
public class Page {

	/** 页码 */
	int pageNumber;

	/** 每页数据量 */
	int pageSize;

}
