package com.lichkin.framework.db.vos;

import static com.lichkin.framework.db.statics.LKSQLStatics.ALWAYS_TRUE_CONDITION;
import static com.lichkin.framework.db.statics.LKSQLStatics.AND;
import static com.lichkin.framework.db.statics.LKSQLStatics.GTE;
import static com.lichkin.framework.db.statics.LKSQLStatics.IN;
import static com.lichkin.framework.db.statics.LKSQLStatics.IS_NOT_NULL;
import static com.lichkin.framework.db.statics.LKSQLStatics.IS_NULL;
import static com.lichkin.framework.db.statics.LKSQLStatics.LIKE;
import static com.lichkin.framework.db.statics.LKSQLStatics.LTE;
import static com.lichkin.framework.db.statics.LKSQLStatics.NOT_EQUAL;
import static com.lichkin.framework.db.statics.LKSQLStatics.NOT_IN;
import static com.lichkin.framework.db.statics.LKSQLStatics.NOT_LIKE;
import static com.lichkin.framework.db.statics.LKSQLStatics.OR;
import static com.lichkin.framework.db.statics.LKSQLStatics.PLACEHOLDER;
import static com.lichkin.framework.db.statics.LKSQLStatics.REGEX_PLACEHOLDER;
import static com.lichkin.framework.db.statics.LKSQLStatics.WHERE;
import static com.lichkin.framework.defines.LKFrameworkStatics.SPLITOR;
import static com.lichkin.framework.defines.LKStringStatics.BLANK;
import static com.lichkin.framework.defines.LKStringStatics.BRACKET_LEFT;
import static com.lichkin.framework.defines.LKStringStatics.BRACKET_RIGHT;
import static com.lichkin.framework.defines.LKStringStatics.COMMA;
import static com.lichkin.framework.defines.LKStringStatics.EMPTY;
import static com.lichkin.framework.defines.LKStringStatics.EQUAL;
import static com.lichkin.framework.defines.LKStringStatics.GT;
import static com.lichkin.framework.defines.LKStringStatics.LT;
import static com.lichkin.framework.defines.LKStringStatics.PERCENT;
import static com.lichkin.framework.defines.LKStringStatics.QUOTATION;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;

/**
 * SQL语句对象类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class LKSqlVo {

	/** SQL语句 */
	private final StringBuilder sql;

	/** 参数列表 */
	private List<Object> params;


	/**
	 * 构造方法
	 */
	public LKSqlVo() {
		sql = new StringBuilder();
	}


	/**
	 * 构造方法
	 * @param sql SQL语句
	 */
	public LKSqlVo(final String sql) {
		this.sql = new StringBuilder(sql);
		if (!sql.toUpperCase().contains(WHERE)) {
			appendSql(WHERE).appendSql(ALWAYS_TRUE_CONDITION);
		}
	}


	/**
	 * 构造方法
	 * @param sql SQL语句
	 * @param params 参数数组
	 */
	public LKSqlVo(final String sql, final Object... params) {
		this(sql);
		if (ArrayUtils.isNotEmpty(params)) {
			for (final Object param : params) {
				addParam(param);
			}
		}
	}


	/**
	 * 获取SQL语句
	 * @return SQL语句
	 * @deprecated 框架内部使用
	 */
	@Deprecated
	public String getSql() {
		return sql.toString();
	}


	/**
	 * 获取参数数组
	 * @return 参数数组
	 * @deprecated 框架内部使用
	 */
	@Deprecated
	public Object[] getParams() {
		if (CollectionUtils.isNotEmpty(params)) {
			return params.toArray();
		}
		return null;
	}


	/**
	 * 拼接SQL语句
	 * @param subSql 子SQL语句
	 * @return SQL语句对象
	 */
	protected LKSqlVo appendSql(final String subSql) {
		sql.append(BLANK).append(subSql.trim());
		return this;
	}


	/**
	 * 增加参数
	 * @param param 参数对象
	 * @return SQL语句对象
	 */
	protected LKSqlVo addParam(final Object param) {
		if (CollectionUtils.isEmpty(params)) {
			params = new ArrayList<>();
		}
		params.add(param);
		return this;
	}


	/**
	 * 拼接SQL语句并增加参数
	 * @param subSql 子SQL语句
	 * @param params 参数数组
	 * @return SQL语句对象
	 * @deprecated 只在特殊情况下使用
	 */
	@Deprecated
	public LKSqlVo appendSqlAndAddParam(final String subSql, final Object... params) {
		appendSql(subSql);
		if (ArrayUtils.isNotEmpty(params)) {
			for (final Object param : params) {
				addParam(param);
			}
		}
		return this;
	}


	/**
	 * 拼接条件类型
	 * @param isAnd true拼接AND条件，false拼接OR条件，null不拼接条件。
	 * @return SQL语句对象
	 * @deprecated 框架内部使用
	 */
	@Deprecated
	private LKSqlVo appendConditionType(Boolean isAnd) {
		if (isAnd != null) {
			if (isAnd) {
				appendSql(AND);
			} else {
				appendSql(OR);
			}
		}
		return this;
	}


	/**
	 * 拼接AND语句
	 * @return SQL语句对象
	 * @deprecated 只在特殊情况下使用
	 */
	@Deprecated
	public LKSqlVo and() {
		return appendConditionType(true);
	}


	/**
	 * 拼接OR语句
	 * @return SQL语句对象
	 * @deprecated 只在特殊情况下使用
	 */
	@Deprecated
	public LKSqlVo or() {
		return appendConditionType(false);
	}


	/**
	 * 获取转换后的SQL（将SQL中的占位符替换为相应的参数）
	 * @return 转换后的SQL
	 */
	public String getParsedSQL() {
		String orginalSql = sql.toString();
		if (CollectionUtils.isNotEmpty(params)) {
			for (final Object param : params) {
				String paramStr = EMPTY;
				if (param != null) {
					paramStr = param.toString();
				}
				if (param instanceof Number) {
					orginalSql = orginalSql.replaceFirst(REGEX_PLACEHOLDER, paramStr);
				} else {
					orginalSql = orginalSql.replaceFirst(REGEX_PLACEHOLDER, QUOTATION + paramStr + QUOTATION);
				}
			}
		}
		return orginalSql;
	}


	/** 是否拼接了WHERE条件 */
	protected boolean whereAppended = false;


	/**
	 * 拼接WHERE语句
	 */
	protected void where() {
		if (whereAppended) {
			return;
		}
		whereAppended = true;
		appendSql(WHERE).appendSql(ALWAYS_TRUE_CONDITION);
	}


	/**
	 * 拼接SQL语句
	 * @param fieldName 字段名
	 * @param condition 条件
	 * @param isAnd true拼接AND条件，false拼接OR条件，null不拼接条件。
	 * @return SQL语句对象
	 */
	protected LKSqlVo append(String fieldName, String condition, Boolean isAnd) {
		return appendConditionType(isAnd).appendSql(fieldName).appendSql(condition).appendSql(PLACEHOLDER);
	}


	/**
	 * 拼接SQL语句
	 * @param fieldName 字段名
	 * @param param 参数
	 * @param condition 条件
	 * @param isAnd true拼接AND条件，false拼接OR条件，null不拼接条件。
	 * @return SQL语句对象
	 * @deprecated 框架内部使用
	 */
	@Deprecated
	private LKSqlVo append(String fieldName, Object param, String condition, Boolean isAnd) {
		return append(fieldName, condition, isAnd).addParam(param);
	}


	/**
	 * 拼接等于
	 * @param fieldName 字段名
	 * @param param 参数
	 * @param isAnd true拼接AND条件，false拼接OR条件，null不拼接条件。
	 * @return SQL语句对象
	 */
	public LKSqlVo eq(String fieldName, Object param, Boolean isAnd) {
		return append(fieldName, param, EQUAL, isAnd);
	}


	/**
	 * 拼接不等于
	 * @param fieldName 字段名
	 * @param param 参数
	 * @param isAnd true拼接AND条件，false拼接OR条件，null不拼接条件。
	 * @return SQL语句对象
	 */
	public LKSqlVo neq(String fieldName, Object param, Boolean isAnd) {
		return append(fieldName, param, NOT_EQUAL, isAnd);
	}


	/**
	 * 拼接小于等于
	 * @param fieldName 字段名
	 * @param param 参数
	 * @param isAnd true拼接AND条件，false拼接OR条件，null不拼接条件。
	 * @return SQL语句对象
	 */
	public LKSqlVo lte(String fieldName, Object param, Boolean isAnd) {
		return append(fieldName, param, LTE, isAnd);
	}


	/**
	 * 拼接大于等于
	 * @param fieldName 字段名
	 * @param param 参数
	 * @param isAnd true拼接AND条件，false拼接OR条件，null不拼接条件。
	 * @return SQL语句对象
	 */
	public LKSqlVo gte(String fieldName, Object param, Boolean isAnd) {
		return append(fieldName, param, GTE, isAnd);
	}


	/**
	 * 拼接小于
	 * @param fieldName 字段名
	 * @param param 参数
	 * @param isAnd true拼接AND条件，false拼接OR条件，null不拼接条件。
	 * @return SQL语句对象
	 */
	public LKSqlVo lt(String fieldName, Object param, Boolean isAnd) {
		return append(fieldName, param, LT, isAnd);
	}


	/**
	 * 拼接大于
	 * @param fieldName 字段名
	 * @param param 参数
	 * @param isAnd true拼接AND条件，false拼接OR条件，null不拼接条件。
	 * @return SQL语句对象
	 */
	public LKSqlVo gt(String fieldName, Object param, Boolean isAnd) {
		return append(fieldName, param, GT, isAnd);
	}


	/**
	 * LIKE条件类型
	 * @author SuZhou LichKin Information Technology Co., Ltd.
	 */
	public enum LikeType {
		LEFT, RIGHT, ALL
	};


	/**
	 * 添加LIKE参数
	 * @param param 参数
	 * @param likeType LIKE条件类型
	 * @return SQL语句对象
	 */
	private LKSqlVo addLikeParam(Object param, LikeType likeType) {
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
	 * 拼接LIKE语句
	 * @param fieldName 字段名
	 * @param param 参数
	 * @param likeType LIKE条件类型
	 * @param isAnd true拼接AND条件，false拼接OR条件，null不拼接条件。
	 * @return SQL语句对象
	 */
	public LKSqlVo like(String fieldName, Object param, LikeType likeType, Boolean isAnd) {
		return append(fieldName, LIKE, isAnd).addLikeParam(param, likeType);
	}


	/**
	 * 拼接NOT LIKE语句
	 * @param fieldName 字段名
	 * @param param 参数
	 * @param likeType LIKE条件类型
	 * @param isAnd true拼接AND条件，false拼接OR条件，null不拼接条件。
	 * @return SQL语句对象
	 */
	public LKSqlVo notLike(String fieldName, Object param, LikeType likeType, Boolean isAnd) {
		return append(fieldName, NOT_LIKE, isAnd).addLikeParam(param, likeType);
	}


	/**
	 * 拼接 IS NULL/ IS NOT NULL
	 * @param isNull true拼接IS NULL；false拼接IS NOT NULL。
	 * @param fieldName 字段名
	 * @param isAnd true拼接AND条件，false拼接OR条件，null不拼接条件。
	 * @return SQL语句对象
	 */
	protected LKSqlVo appendIsNull(boolean isNull, String fieldName, Boolean isAnd) {
		return appendConditionType(isAnd).appendSql(fieldName).appendSql(isNull ? IS_NULL : IS_NOT_NULL);
	}


	/**
	 * 拼接 IS NULL
	 * @param fieldName 字段名
	 * @param isAnd true拼接AND条件，false拼接OR条件，null不拼接条件。
	 * @return SQL语句对象
	 */
	public LKSqlVo isNull(String fieldName, Boolean isAnd) {
		return appendIsNull(true, fieldName, isAnd);
	}


	/**
	 * 拼接 IS NOT NULL
	 * @param fieldName 字段名
	 * @param isAnd true拼接AND条件，false拼接OR条件，null不拼接条件。
	 * @return SQL语句对象
	 */
	public LKSqlVo isNotNull(String fieldName, Boolean isAnd) {
		return appendIsNull(false, fieldName, isAnd);
	}


	/**
	 * 拼接IN/NOT IN语句
	 * @param isIn true拼接IN；false拼接NOT IN。
	 * @param fieldName 字段名
	 * @param params 参数
	 * @param isAnd true拼接AND条件，false拼接OR条件，null不拼接条件。
	 * @return SQL语句对象
	 */
	protected LKSqlVo appendIn(boolean isIn, String fieldName, Object[] params, Boolean isAnd) {
		appendConditionType(isAnd).appendSql(fieldName).appendSql(isIn ? IN : NOT_IN);

		appendSql(BRACKET_LEFT);

		for (final Object param : params) {
			sql.append(QUOTATION).append(param).append(QUOTATION).append(COMMA);
		}
		sql.deleteCharAt(sql.length() - 1);

		appendSql(BRACKET_RIGHT);

		return this;
	}


	/**
	 * 拼接IN/NOT IN语句
	 * 使用#@#拼接的字符串，切分后按照数字查询。
	 * @param isIn true拼接IN；false拼接NOT IN。
	 * @param fieldName 字段名
	 * @param params 参数
	 * @param isAnd true拼接AND条件，false拼接OR条件，null不拼接条件。
	 * @param numberClazz 数字类型
	 * @return SQL语句对象
	 * @deprecated 框架内部使用
	 */
	@Deprecated
	private LKSqlVo appendIn(boolean isIn, String fieldName, String params, Boolean isAnd, Class<? extends Number> numberClazz) {
		String[] strs = params.split(SPLITOR);
		String className = numberClazz.getName();
		switch (className) {
			case "java.lang.Byte": {
				Byte[] arr = new Byte[strs.length];
				for (int i = 0; i < strs.length; i++) {
					arr[i] = Byte.parseByte(strs[i]);
				}
				return appendIn(isIn, fieldName, arr, isAnd);
			}
			case "java.lang.Short": {
				Short[] arr = new Short[strs.length];
				for (int i = 0; i < strs.length; i++) {
					arr[i] = Short.parseShort(strs[i]);
				}
				return appendIn(isIn, fieldName, arr, isAnd);
			}
			case "java.lang.Integer": {
				Integer[] arr = new Integer[strs.length];
				for (int i = 0; i < strs.length; i++) {
					arr[i] = Integer.parseInt(strs[i]);
				}
				return appendIn(isIn, fieldName, arr, isAnd);
			}
			case "java.lang.Long": {
				Long[] arr = new Long[strs.length];
				for (int i = 0; i < strs.length; i++) {
					arr[i] = Long.parseLong(strs[i]);
				}
				return appendIn(isIn, fieldName, arr, isAnd);
			}
			case "java.lang.Float": {
				Float[] arr = new Float[strs.length];
				for (int i = 0; i < strs.length; i++) {
					arr[i] = Float.parseFloat(strs[i]);
				}
				return appendIn(isIn, fieldName, arr, isAnd);
			}
			case "java.lang.Double": {
				Double[] arr = new Double[strs.length];
				for (int i = 0; i < strs.length; i++) {
					arr[i] = Double.parseDouble(strs[i]);
				}
				return appendIn(isIn, fieldName, arr, isAnd);
			}
		}
		return null;
	}


	/**
	 * 拼接IN语句
	 * 使用#@#拼接的字符串，切分后按照字符串查询。
	 * @param fieldName 字段名
	 * @param params 参数
	 * @param isAnd true拼接AND条件，false拼接OR条件，null不拼接条件。
	 * @return SQL语句对象
	 */
	public LKSqlVo in(String fieldName, String params, Boolean isAnd) {
		return appendIn(true, fieldName, params.split(SPLITOR), isAnd);
	}


	/**
	 * 拼接IN语句
	 * 使用#@#拼接的字符串，切分后按照数字查询。
	 * @param fieldName 字段名
	 * @param params 参数
	 * @param isAnd true拼接AND条件，false拼接OR条件，null不拼接条件。
	 * @param numberClazz 数字类型
	 * @return SQL语句对象
	 */
	public LKSqlVo in(String fieldName, String params, Boolean isAnd, Class<? extends Number> numberClazz) {
		return appendIn(true, fieldName, params, isAnd, numberClazz);
	}


	/**
	 * 拼接NOT IN语句
	 * 使用#@#拼接的字符串，切分后按照字符串查询。
	 * @param fieldName 字段名
	 * @param params 参数
	 * @param isAnd true拼接AND条件，false拼接OR条件，null不拼接条件。
	 * @return SQL语句对象
	 */
	public LKSqlVo notIn(String fieldName, String params, Boolean isAnd) {
		return appendIn(false, fieldName, params.split(SPLITOR), isAnd);
	}


	/**
	 * 拼接NOT IN语句
	 * 使用#@#拼接的字符串，切分后按照数字查询。
	 * @param fieldName 字段名
	 * @param params 参数
	 * @param isAnd true拼接AND条件，false拼接OR条件，null不拼接条件。
	 * @param numberClazz 数字类型
	 * @return SQL语句对象
	 */
	public LKSqlVo notIn(String fieldName, String params, Boolean isAnd, Class<? extends Number> numberClazz) {
		return appendIn(false, fieldName, params, isAnd, numberClazz);
	}

}
