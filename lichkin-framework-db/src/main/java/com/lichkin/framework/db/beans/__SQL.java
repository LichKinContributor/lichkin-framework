package com.lichkin.framework.db.beans;

import static com.lichkin.framework.defines.LKStringStatics.BLANK;
import static com.lichkin.framework.defines.LKStringStatics.DOT;
import static com.lichkin.framework.defines.LKStringStatics.QUESTION;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lichkin.framework.json.LKJsonUtils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * SQL/HQL语句
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@NoArgsConstructor(access = AccessLevel.PACKAGE)
class __SQL {

	/** SQL语句 */
	final StringBuilder sql = new StringBuilder();


	/**
	 * 获取SQL语句
	 * @return SQL语句
	 * @deprecated 框架内部使用
	 */
	@Deprecated
	public StringBuilder getSql() {
		return sql;
	}


	/** 参数列表 */
	final List<Object> params = new ArrayList<>();


	/**
	 * 获取参数列表
	 * @return 参数列表
	 * @deprecated 框架内部使用
	 */
	@Deprecated
	public List<Object> getParams() {
		return params;
	}


	/**
	 * 添加表。表名 AS 表别名。
	 * @param tableResId 表资源ID
	 */
	__SQL appendTable(int tableResId) {
		LKDBResource.__TableResource tableResource = LKDBResource.tables.get(tableResId);
		assertNotNull(tableResource);
		sql.append(tableResource.getTableName()).append(BLANK).append(AS).append(BLANK).append(tableResource.getTableAlias());
		return this;
	}


	/**
	 * 添加列。表别名.列名。
	 * @param columnResId 列资源ID
	 */
	__SQL appendColumn(int columnResId) {
		LKDBResource.__ColumnResource columnResource = LKDBResource.columns.get(columnResId);
		assertNotNull(columnResource);
		sql.append(columnResource.getTable().getTableAlias()).append(DOT).append(columnResource.getColumnName());
		return this;
	}


	@Override
	public String toString() {
		Map<String, Object> map = new HashMap<>();
		map.put("sql", getSql());
		map.put("params", getParams());
		return LKJsonUtils.toJson(map);
	}


	/** PLACEHOLDER */
	static final String PLACEHOLDER = QUESTION;

	/** IN */
	static final String IN = "IN";

	/** NOT IN */
	static final String NOT_IN = "NOT IN";

	/** LIKE */
	static final String LIKE = "LIKE";

	/** NOT LIKE */
	static final String NOT_LIKE = "NOT LIKE";

	/** IS NULL */
	static final String IS_NULL = "IS NULL";

	/** IS NOT NULL */
	static final String IS_NOT_NULL = "IS NOT NULL";

	/** EQ */
	static final String EQ = "=";

	/** NEQ */
	static final String NEQ = "!=";

	/** LT */
	static final String LT = "<";

	/** GT */
	static final String GT = ">";

	/** LTE */
	static final String LTE = "<=";

	/** GTE */
	static final String GTE = ">=";

	/** AND */
	static final String AND = "AND";

	/** OR */
	static final String OR = "OR";

	/** AS */
	static final String AS = "AS";

	/** SELECT */
	static final String SELECT = "SELECT";

	/** DISTINCT */
	static final String DISTINCT = "DISTINCT";

	/** UPDATE */
	static final String UPDATE = "UPDATE";

	/** SET */
	static final String SET = "SET";

	/** FROM */
	static final String FROM = "FROM";

	/** JOIN */
	static final String JOIN = "JOIN";

	/** LEFT JOIN */
	static final String LEFT_JOIN = "LEFT JOIN";

	/** RIGHT JOIN */
	static final String RIGHT_JOIN = "RIGHT JOIN";

	/** FULL JOIN */
	static final String FULL_JOIN = "FULL JOIN";

	/** INNER JOIN */
	static final String INNER_JOIN = "INNER JOIN";

	/** ON */
	static final String ON = "ON";

	/** WHERE */
	static final String WHERE = "WHERE";

}
