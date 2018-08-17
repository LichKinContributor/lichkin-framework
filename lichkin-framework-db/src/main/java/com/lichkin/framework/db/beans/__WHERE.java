package com.lichkin.framework.db.beans;

import static com.lichkin.framework.db.beans.__SQL_STATICS.AND;
import static com.lichkin.framework.db.beans.__SQL_STATICS.OR;
import static com.lichkin.framework.db.beans.__SQL_STATICS.WHERE;
import static com.lichkin.framework.defines.LKStringStatics.BLANK;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.lichkin.framework.db.enums.LikeType;
import com.lichkin.framework.defines.LKFrameworkStatics;

/**
 * SQL语句 -&gt; WHERE
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
class __WHERE extends __SQL {

	/** 条件表达式 */
	private final List<Condition> conditions = new ArrayList<>();

	/** 参数列表 */
	List<Object> params = new ArrayList<>();


	/**
	 * 添加条件表达式
	 * @param conditions 条件表达式
	 */
	void where(Condition... conditions) {
		// 不做非空判断，即无参数时就应该报错。
		this.conditions.addAll(Arrays.asList(conditions));
		for (Condition condition : conditions) {
			params.addAll(condition.getParams());
		}
	}


	/**
	 * 添加表达式（等于）
	 * @param and true:AND;false:OR;null:无条件。
	 * @param columnResId 列资源ID
	 * @param param 参数
	 */
	void eq(Boolean and, int columnResId, Object param) {
		where(new Condition(and, new eq(columnResId, param)));
	}


	/**
	 * 添加表达式（等于）
	 * @param and true:AND;false:OR;null:无条件。
	 * @param leftColumnResId 左边列资源ID
	 * @param rightColumnResId 右边列资源ID
	 */
	void eq_(Boolean and, int leftColumnResId, int rightColumnResId) {
		where(new Condition(and, new eq_(leftColumnResId, rightColumnResId)));
	}


	/**
	 * 添加表达式（不等于）
	 * @param and true:AND;false:OR;null:无条件。
	 * @param columnResId 列资源ID
	 * @param param 参数
	 */
	void neq(Boolean and, int columnResId, Object param) {
		where(new Condition(and, new neq(columnResId, param)));
	}


	/**
	 * 添加表达式（不等于）
	 * @param and true:AND;false:OR;null:无条件。
	 * @param leftColumnResId 左边列资源ID
	 * @param rightColumnResId 右边列资源ID
	 */
	void neq_(Boolean and, int leftColumnResId, int rightColumnResId) {
		where(new Condition(and, new neq_(leftColumnResId, rightColumnResId)));
	}


	/**
	 * 添加表达式（大于）
	 * @param and true:AND;false:OR;null:无条件。
	 * @param columnResId 列资源ID
	 * @param param 参数
	 */
	void gt(Boolean and, int columnResId, Object param) {
		where(new Condition(and, new gt(columnResId, param)));
	}


	/**
	 * 添加表达式（大于）
	 * @param and true:AND;false:OR;null:无条件。
	 * @param leftColumnResId 左边列资源ID
	 * @param rightColumnResId 右边列资源ID
	 */
	void gt_(Boolean and, int leftColumnResId, int rightColumnResId) {
		where(new Condition(and, new gt_(leftColumnResId, rightColumnResId)));
	}


	/**
	 * 添加表达式（大于等于）
	 * @param and true:AND;false:OR;null:无条件。
	 * @param columnResId 列资源ID
	 * @param param 参数
	 */
	void gte(Boolean and, int columnResId, Object param) {
		where(new Condition(and, new gte(columnResId, param)));
	}


	/**
	 * 添加表达式（大于等于）
	 * @param and true:AND;false:OR;null:无条件。
	 * @param leftColumnResId 左边列资源ID
	 * @param rightColumnResId 右边列资源ID
	 */
	void gte_(Boolean and, int leftColumnResId, int rightColumnResId) {
		where(new Condition(and, new gte_(leftColumnResId, rightColumnResId)));
	}


	/**
	 * 添加表达式（小于）
	 * @param and true:AND;false:OR;null:无条件。
	 * @param columnResId 列资源ID
	 * @param param 参数
	 */
	void lt(Boolean and, int columnResId, Object param) {
		where(new Condition(and, new lt(columnResId, param)));
	}


	/**
	 * 添加表达式（小于）
	 * @param and true:AND;false:OR;null:无条件。
	 * @param leftColumnResId 左边列资源ID
	 * @param rightColumnResId 右边列资源ID
	 */
	void lt_(Boolean and, int leftColumnResId, int rightColumnResId) {
		where(new Condition(and, new lt_(leftColumnResId, rightColumnResId)));
	}


	/**
	 * 添加表达式（小于等于）
	 * @param and true:AND;false:OR;null:无条件。
	 * @param columnResId 列资源ID
	 * @param param 参数
	 */
	void lte(Boolean and, int columnResId, Object param) {
		where(new Condition(and, new lte(columnResId, param)));
	}


	/**
	 * 添加表达式（小于等于）
	 * @param and true:AND;false:OR;null:无条件。
	 * @param leftColumnResId 左边列资源ID
	 * @param rightColumnResId 右边列资源ID
	 */
	void lte_(Boolean and, int leftColumnResId, int rightColumnResId) {
		where(new Condition(and, new lte_(leftColumnResId, rightColumnResId)));
	}


	/**
	 * 添加表达式（IN）
	 * @param and true:AND;false:OR;null:无条件。
	 * @param columnResId 列资源ID
	 * @param paramsStr 参数。使用LKFrameworkStatics.SPLITOR作为分隔符。
	 */
	void in(Boolean and, int columnResId, String paramsStr) {
		if (paramsStr.contains(LKFrameworkStatics.SPLITOR)) {
			where(new Condition(and, new in(columnResId, paramsStr)));
		} else {
			where(new Condition(and, new eq(columnResId, paramsStr)));
		}
	}


	/**
	 * 添加表达式（IN）
	 * @param and true:AND;false:OR;null:无条件。
	 * @param columnResId 列资源ID
	 * @param paramsList 参数
	 */
	void in(Boolean and, int columnResId, List<String> paramsList) {
		if (paramsList.size() != 1) {
			where(new Condition(and, new in(columnResId, paramsList)));
		} else {
			where(new Condition(and, new eq(columnResId, paramsList.get(0))));
		}
	}


	/**
	 * 添加表达式（IN）
	 * @param and true:AND;false:OR;null:无条件。
	 * @param columnResId 列资源ID
	 * @param paramsArr 参数
	 */
	void in(Boolean and, int columnResId, String[] paramsArr) {
		if (paramsArr.length != 1) {
			where(new Condition(and, new in(columnResId, paramsArr)));
		} else {
			where(new Condition(and, new eq(columnResId, paramsArr[0])));
		}
	}


	/**
	 * 添加表达式（NOT IN）
	 * @param and true:AND;false:OR;null:无条件。
	 * @param columnResId 列资源ID
	 * @param paramsStr 参数。使用LKFrameworkStatics.SPLITOR作为分隔符。
	 */
	void notIn(Boolean and, int columnResId, String paramsStr) {
		if (paramsStr.contains(LKFrameworkStatics.SPLITOR)) {
			where(new Condition(and, new notIn(columnResId, paramsStr)));
		} else {
			where(new Condition(and, new neq(columnResId, paramsStr)));
		}
	}


	/**
	 * 添加表达式（NOT IN）
	 * @param and true:AND;false:OR;null:无条件。
	 * @param columnResId 列资源ID
	 * @param paramsList 参数
	 */
	void notIn(Boolean and, int columnResId, List<String> paramsList) {
		if (paramsList.size() != 1) {
			where(new Condition(and, new notIn(columnResId, paramsList)));
		} else {
			where(new Condition(and, new neq(columnResId, paramsList.get(0))));
		}
	}


	/**
	 * 添加表达式（NOT IN）
	 * @param and true:AND;false:OR;null:无条件。
	 * @param columnResId 列资源ID
	 * @param paramsArr 参数
	 */
	void notIn(Boolean and, int columnResId, String[] paramsArr) {
		if (paramsArr.length != 1) {
			where(new Condition(and, new notIn(columnResId, paramsArr)));
		} else {
			where(new Condition(and, new neq(columnResId, paramsArr[0])));
		}
	}


	/**
	 * 添加表达式（LIKE）
	 * @param and true:AND;false:OR;null:无条件。
	 * @param columnResId 列资源ID
	 * @param likeType LIKE表达式类型
	 * @param param 参数
	 */
	void like(Boolean and, int columnResId, LikeType likeType, String param) {
		where(new Condition(and, new like(columnResId, likeType, param)));
	}


	/**
	 * 添加表达式（NOT LIKE）
	 * @param and true:AND;false:OR;null:无条件。
	 * @param columnResId 列资源ID
	 * @param likeType LIKE表达式类型
	 * @param param 参数
	 */
	void notLike(Boolean and, int columnResId, LikeType likeType, String param) {
		where(new Condition(and, new notLike(columnResId, likeType, param)));
	}


	/**
	 * 添加表达式（IS NULL）
	 * @param and true:AND;false:OR;null:无条件。
	 * @param columnResId 列资源ID
	 */
	void isNull(Boolean and, int columnResId) {
		where(new Condition(and, new isNull(columnResId)));
	}


	/**
	 * 添加表达式（IS NOT NULL）
	 * @param and true:AND;false:OR;null:无条件。
	 * @param columnResId 列资源ID
	 */
	void isNotNull(Boolean and, int columnResId) {
		where(new Condition(and, new isNotNull(columnResId)));
	}


	@Override
	StringBuilder getSQL(boolean useSQL) {
		StringBuilder sql = new StringBuilder();
		for (int i = 0; i < conditions.size(); i++) {
			sql.append(BLANK);
			Condition condition = conditions.get(i);
			if (i == 0) {
				sql.append(WHERE).append(BLANK).append(condition.getSQLWithoutCondition(useSQL));
			} else {
				if (Boolean.FALSE.equals(condition.and)) {
					sql.append(OR).append(BLANK).append(condition.getSQLWithoutCondition(useSQL));
				} else {
					sql.append(AND).append(BLANK).append(condition.getSQLWithoutCondition(useSQL));
				}
			}
		}
		return sql;
	}

}
