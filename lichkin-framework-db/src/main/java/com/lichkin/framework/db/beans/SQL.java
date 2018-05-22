package com.lichkin.framework.db.beans;

import static com.lichkin.framework.db.beans.__SQL_STATICS.AND;
import static com.lichkin.framework.db.beans.__SQL_STATICS.EQ;
import static com.lichkin.framework.db.beans.__SQL_STATICS.GT;
import static com.lichkin.framework.db.beans.__SQL_STATICS.GTE;
import static com.lichkin.framework.db.beans.__SQL_STATICS.IN;
import static com.lichkin.framework.db.beans.__SQL_STATICS.IS_NOT_NULL;
import static com.lichkin.framework.db.beans.__SQL_STATICS.IS_NULL;
import static com.lichkin.framework.db.beans.__SQL_STATICS.LIKE;
import static com.lichkin.framework.db.beans.__SQL_STATICS.LT;
import static com.lichkin.framework.db.beans.__SQL_STATICS.LTE;
import static com.lichkin.framework.db.beans.__SQL_STATICS.NEQ;
import static com.lichkin.framework.db.beans.__SQL_STATICS.NOT_IN;
import static com.lichkin.framework.db.beans.__SQL_STATICS.NOT_LIKE;
import static com.lichkin.framework.db.beans.__SQL_STATICS.OR;
import static com.lichkin.framework.db.beans.__SQL_STATICS.PLACEHOLDER;
import static com.lichkin.framework.defines.LKFrameworkStatics.SPLITOR;
import static com.lichkin.framework.defines.LKStringStatics.BLANK;
import static com.lichkin.framework.defines.LKStringStatics.BRACKET_LEFT;
import static com.lichkin.framework.defines.LKStringStatics.BRACKET_RIGHT;
import static com.lichkin.framework.defines.LKStringStatics.COMMA;
import static com.lichkin.framework.defines.LKStringStatics.PERCENT;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.lichkin.framework.db.enums.LikeType;

/**
 * SQL语句
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class SQL {

	/** 是否使用SQL */
	private final boolean useSQL;

	/** SQL语句 */
	private final StringBuilder sql = new StringBuilder();

	/** 参数列表 */
	private final List<Object> params = new ArrayList<>();


	/**
	 * 构造方法
	 * @param useSQL true:SQL;falseHQL.
	 */
	public SQL(boolean useSQL) {
		super();
		this.useSQL = useSQL;
	}


	/**
	 * 是否使用SQL
	 * @return true:SQL;falseHQL.
	 * @deprecated 框架内部使用
	 */
	@Deprecated
	public boolean isUseSQL() {
		return useSQL;
	}


	/**
	 * 获取SQL语句
	 * @return SQL语句
	 * @deprecated 框架内部使用
	 */
	@Deprecated
	public String getSQL() {
		return sql.toString();
	}


	/**
	 * 获取参数列表
	 * @return 参数列表
	 * @deprecated 框架内部使用
	 */
	@Deprecated
	public Object[] getParams() {
		return params.toArray();
	}


	/**
	 * 拼接SQL语句
	 * @param subSQL SQL语句
	 * @return SQL语句
	 */
	public SQL appendSQL(String subSQL) {
		sql.append(subSQL);
		return this;
	}


	/**
	 * 添加参数
	 * @param param 参数
	 * @return 本对象
	 */
	public SQL addParam(Object param) {
		params.add(param);
		return this;
	}


	/**
	 * 拼接AND
	 * @return 本对象
	 */
	private SQL and() {
		sql.append(BLANK).append(AND);
		return this;
	}


	/**
	 * 拼接AND
	 * @param subSQL SQL语句
	 * @return 本对象
	 */
	public SQL and(String subSQL) {
		sql.append(BLANK).append(AND).append(BLANK).append(subSQL.trim());
		return this;
	}


	/**
	 * 拼接OR
	 * @return 本对象
	 */
	private SQL or() {
		sql.append(BLANK).append(OR);
		return this;
	}


	/**
	 * 拼接OR
	 * @param subSQL SQL语句
	 * @return 本对象
	 */
	public SQL or(String subSQL) {
		sql.append(BLANK).append(OR).append(BLANK).append(subSQL.trim());
		return this;
	}


	/**
	 * 拼接条件
	 * @param and true:AND;false:OR;null:无条件。
	 * @return
	 */
	private SQL appendAnd(Boolean and) {
		if (and != null) {
			return and ? and() : or();
		}
		return this;
	}


	/**
	 * 拼接比较条件
	 * @param and true:AND;false:OR;null:无条件。
	 * @param expressionType 表达式类型
	 * @param columnName 键
	 * @param param 参数
	 * @return 本对象
	 */
	private SQL appendCompare(Boolean and, String expressionType, String columnName, Object param) {
		appendAnd(and);
		sql.append(BLANK).append(columnName).append(BLANK).append(expressionType).append(BLANK).append(PLACEHOLDER);
		addParam(param);
		return this;
	}


	/**
	 * 拼接等于
	 * @param and true:AND;false:OR;null:无条件。
	 * @param columnName 键
	 * @param param 参数
	 * @return 本对象
	 */
	public SQL eq(Boolean and, String columnName, Object param) {
		return appendCompare(and, EQ, columnName, param);
	}


	/**
	 * 拼接不等于
	 * @param and true:AND;false:OR;null:无条件。
	 * @param columnName 键
	 * @param param 参数
	 * @return 本对象
	 */
	public SQL neq(Boolean and, String columnName, Object param) {
		return appendCompare(and, NEQ, columnName, param);
	}


	/**
	 * 拼接大于
	 * @param and true:AND;false:OR;null:无条件。
	 * @param columnName 键
	 * @param param 参数
	 * @return 本对象
	 */
	public SQL gt(Boolean and, String columnName, Object param) {
		return appendCompare(and, GT, columnName, param);
	}


	/**
	 * 拼接大于等于
	 * @param and true:AND;false:OR;null:无条件。
	 * @param columnName 键
	 * @param param 参数
	 * @return 本对象
	 */
	public SQL gte(Boolean and, String columnName, Object param) {
		return appendCompare(and, GTE, columnName, param);
	}


	/**
	 * 拼接小于
	 * @param and true:AND;false:OR;null:无条件。
	 * @param columnName 键
	 * @param param 参数
	 * @return 本对象
	 */
	public SQL lt(Boolean and, String columnName, Object param) {
		return appendCompare(and, LT, columnName, param);
	}


	/**
	 * 拼接小于等于
	 * @param and true:AND;false:OR;null:无条件。
	 * @param columnName 键
	 * @param param 参数
	 * @return 本对象
	 */
	public SQL lte(Boolean and, String columnName, Object param) {
		return appendCompare(and, LTE, columnName, param);
	}


	/**
	 * 拼接IS NULL/IS NOT NULL条件
	 * @param and true:AND;false:OR;null:无条件。
	 * @param isNull 是否为空
	 * @param columnName 键
	 * @return 本对象
	 */
	private SQL appendIsNull(Boolean and, boolean isNull, String columnName) {
		appendAnd(and);
		sql.append(BLANK).append(columnName).append(BLANK).append(isNull ? IS_NULL : IS_NOT_NULL);
		return this;
	}


	/**
	 * 拼接IS NULL
	 * @param and true:AND;false:OR;null:无条件。
	 * @param columnName 键
	 * @return 本对象
	 */
	public SQL isNull(Boolean and, String columnName) {
		return appendIsNull(and, true, columnName);
	}


	/**
	 * 拼接IS NOT NULL
	 * @param and true:AND;false:OR;null:无条件。
	 * @param columnName 键
	 * @return 本对象
	 */
	public SQL isNotNull(Boolean and, String columnName) {
		return appendIsNull(and, false, columnName);
	}


	/**
	 * 拼接LIKE/NOT LIKE条件
	 * @param and true:AND;false:OR;null:无条件。
	 * @param like true:LIKE;false:NOT LIKE.
	 * @param columnName 键
	 * @param likeType LIKE表达式类型
	 * @parma param 参数
	 * @return 本对象
	 */
	private SQL appendLike(Boolean and, boolean like, String columnName, LikeType likeType, String param) {
		appendAnd(and);
		sql.append(BLANK).append(columnName).append(BLANK).append(like ? LIKE : NOT_LIKE).append(BLANK).append(PLACEHOLDER);
		switch (likeType) {
			case LEFT:
				addParam(PERCENT + param);
			break;
			case RIGHT:
				addParam(param + PERCENT);
			break;
			case ALL:
				addParam(PERCENT + param + PERCENT);
			break;
		}
		return this;
	}


	/**
	 * 拼接LIKE条件
	 * @param and true:AND;false:OR;null:无条件。
	 * @param columnName 键
	 * @param likeType LIKE表达式类型
	 * @parma param 参数
	 * @return 本对象
	 */
	public SQL like(Boolean and, String columnName, LikeType likeType, String param) {
		return appendLike(and, true, columnName, likeType, param);
	}


	/**
	 * 拼接NOT LIKE条件
	 * @param and true:AND;false:OR;null:无条件。
	 * @param columnName 键
	 * @param likeType LIKE表达式类型
	 * @parma param 参数
	 * @return 本对象
	 */
	public SQL notLike(Boolean and, String columnName, LikeType likeType, String param) {
		return appendLike(and, false, columnName, likeType, param);
	}


	/**
	 * 拼接IN/NOT IN条件
	 * @param and true:AND;false:OR;null:无条件。
	 * @param in true:IN;false:NOT IN.
	 * @param columnName 键
	 * @parma param 参数
	 * @return 本对象
	 */
	private SQL appendIn(Boolean and, boolean in, String columnName, String param) {
		String[] paramArr = param.split(SPLITOR);
		appendAnd(and);
		sql.append(BLANK).append(columnName).append(BLANK).append(in ? IN : NOT_IN).append(BRACKET_LEFT);
		for (int i = paramArr.length - 1; i >= 0; i--) {
			sql.append(PLACEHOLDER);
			if (i == 0) {
				sql.append(BRACKET_RIGHT);
			} else {
				sql.append(COMMA);
			}
		}
		params.addAll(Arrays.asList(paramArr));
		return this;
	}


	/**
	 * 拼接IN条件
	 * @param and true:AND;false:OR;null:无条件。
	 * @param columnName 键
	 * @parma param 参数
	 * @return 本对象
	 */
	public SQL in(Boolean and, String columnName, String param) {
		return appendIn(and, true, columnName, param);
	}


	/**
	 * 拼接NOT IN条件
	 * @param and true:AND;false:OR;null:无条件。
	 * @param columnName 键
	 * @parma param 参数
	 * @return 本对象
	 */
	public SQL notIn(Boolean and, String columnName, String param) {
		return appendIn(and, false, columnName, param);
	}

}
