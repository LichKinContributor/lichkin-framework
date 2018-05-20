package com.lichkin.framework.db.beans;

import static com.lichkin.framework.defines.LKStringStatics.BLANK;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;

/**
 * SQL语句 -> WHERE
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
class __WHERE extends __SQL {

	/** 条件表达式 */
	final List<Condition> conditions = new ArrayList<>();


	/**
	 * 构造方法
	 */
	__WHERE() {
		super();
	}


	/** 是否为第一个条件表达式 */
	private boolean first = true;


	/**
	 * 添加条件表达式
	 * @param conditions 条件表达式
	 * @return 本对象
	 */
	__WHERE where(Condition... conditions) {
		assertFalse(ArrayUtils.isEmpty(conditions));
		this.conditions.addAll(Arrays.asList(conditions));
		if (ArrayUtils.isNotEmpty(conditions)) {
			for (Condition condition : conditions) {
				if (first) {
					first = false;
					sql.append(WHERE).append(BLANK).append(condition.sqlWithoutCondiiton);
				} else {
					sql.append(BLANK).append(condition.sql);
				}
				params.addAll(condition.params);
			}
		}
		return this;
	}

}
