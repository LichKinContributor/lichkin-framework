package com.lichkin.framework.db.beans;

import static com.lichkin.framework.defines.LKStringStatics.BLANK;
import static com.lichkin.framework.defines.LKStringStatics.DOT;
import static com.lichkin.framework.defines.LKStringStatics.QUESTION;
import static org.junit.Assert.assertNotNull;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * SQL/HQL语句
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
abstract class __SQL {

	/**
	 * 获取表SQL。表名 AS 表别名。
	 * @param useSQL true:SQL;false:HQL.
	 * @param tableResId 表资源ID
	 */
	protected StringBuilder getTableSQL(boolean useSQL, int tableResId) {
		LKDBResource.__TableResource tableResource = LKDBResource.tables.get(tableResId);
		assertNotNull(tableResource);
		StringBuilder sql = new StringBuilder();
		sql.append(useSQL ? tableResource.getTableName() : tableResource.getClassName()).append(BLANK).append(AS).append(BLANK).append(tableResource.getTableAlias());
		return sql;
	}


	/**
	 * 获取列SQL。表别名.列名。
	 * @param useSQL true:SQL;false:HQL.
	 * @param columnResId 列资源ID
	 */
	protected StringBuilder getColumnSQL(boolean useSQL, int columnResId) {
		LKDBResource.__ColumnResource columnResource = LKDBResource.columns.get(columnResId);
		assertNotNull(columnResource);
		StringBuilder sql = new StringBuilder();
		sql.append(columnResource.getTable().getTableAlias()).append(DOT).append(columnResource.getColumnName());
		return sql;
	}


	/**
	 * 获取SQL语句
	 * @param useSQL true:SQL;false:HQL.
	 * @return SQL语句
	 */
	abstract StringBuilder getSql(boolean useSQL);


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
