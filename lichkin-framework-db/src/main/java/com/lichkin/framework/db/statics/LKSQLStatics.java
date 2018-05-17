package com.lichkin.framework.db.statics;

import com.lichkin.framework.defines.LKRegexStatics;
import com.lichkin.framework.defines.LKStringStatics;

/**
 * SQL静态常量
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public interface LKSQLStatics extends LKStringStatics {

	/** 默认页码 */
	public static final int DEFAULT_PAGE_NUMBER = 0;

	/** 默认分页大小 */
	public static final int DEFAULT_PAGE_SIZE = 25;

	/** SELECT */
	public static final String SELECT = "SELECT";

	/** FROM */
	public static final String FROM = "FROM";

	/** AS */
	public static final String AS = "AS";

	/** WHERE */
	public static final String WHERE = "WHERE";

	/** DISTINCT */
	public static final String DISTINCT = "DISTINCT";

	/** AND */
	public static final String AND = "AND";

	/** OR */
	public static final String OR = "OR";

	/** != */
	public static final String NOT_EQUAL = EXCLAMATION + EQUAL;

	/** &gt;= */
	public static final String GTE = GT + EQUAL;

	/** &lt;= */
	public static final String LTE = LT + EQUAL;

	/** LIKE */
	public static final String LIKE = "LIKE";

	/** NOT LIKE */
	public static final String NOT_LIKE = "NOT LIKE";

	/** IS NULL */
	public static final String IS_NULL = "IS NULL";

	/** IS NOT NULL */
	public static final String IS_NOT_NULL = "IS NOT NULL";

	/** IN */
	public static final String IN = "IN";

	/** NOT IN */
	public static final String NOT_IN = "NOT IN";

	/** BLANK AS BLANK */
	public static final String BLANKASBLANK = BLANK + AS + BLANK;

	/** BLANK WHERE BLANK */
	public static final String BLANKWHEREBLANK = BLANK + WHERE + BLANK;

	/** SELECT BLANK DISTINCT */
	public static final String SELECTBLANKDISTINCT = SELECT + BLANK + DISTINCT;

	/** 1 = 1 */
	public static final String ALWAYS_TRUE_CONDITION = "1 = 1";

	/** PLACEHOLDER */
	public static final String PLACEHOLDER = QUESTION;

	/** REGEX_PLACEHOLDER */
	public static final String REGEX_PLACEHOLDER = LKRegexStatics.ESCAPE + PLACEHOLDER;

}
