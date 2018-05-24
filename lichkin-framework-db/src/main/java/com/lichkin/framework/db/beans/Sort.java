package com.lichkin.framework.db.beans;

import static com.lichkin.framework.defines.LKStringStatics.BLANK;
import static com.lichkin.framework.defines.LKStringStatics.COMMA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 排序信息对象
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class Sort extends __SQL {

	/** ORDER BY */
	private static final String ORDER_BY = "ORDER BY";

	/** 排序信息对象列表 */
	List<Order> listOrder = new ArrayList<>();


	/**
	 * 构造方法
	 * @param orders 排序信息对象
	 */
	public Sort(Order... orders) {
		listOrder.addAll(Arrays.asList(orders));
	}


	/**
	 * 添加排序信息对象
	 * @param orders 排序信息对象
	 * @return 本对象
	 */
	public Sort addOrders(Order... orders) {
		listOrder.addAll(Arrays.asList(orders));
		return this;
	}


	/**
	 * 获取SQL语句
	 * @return SQL语句
	 */
	@Override
	StringBuilder getSQL(boolean useSQL) {
		StringBuilder sql = new StringBuilder();
		for (int i = 0; i < listOrder.size(); i++) {
			Order order = listOrder.get(i);
			if (i == 0) {
				sql.append(BLANK).append(ORDER_BY);
			} else {
				sql.append(COMMA);
			}
			sql.append(order.getSQL(useSQL));
		}
		return sql;
	}

}
