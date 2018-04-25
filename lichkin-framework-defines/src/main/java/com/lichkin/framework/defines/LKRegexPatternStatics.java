package com.lichkin.framework.defines;

/**
 * 正则表达式常量定义
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public interface LKRegexPatternStatics {

	/** 或 */
	public static final String OR = "|";

	/** 空 */
	public static final String EMPTY = "(\\s&&[^\\f\\n\\r\\t\\v])*";

	/** 空或者XXX，直接使用拼接即可。 */
	public static final String EMPTY_OR = EMPTY + OR;

	/** 正整数 */
	public static final String POSITIVE_INTEGER = "[1-9]\\d*";

	/** 正整数或零 */
	public static final String POSITIVE_INTEGER_OR_ZERO = POSITIVE_INTEGER + OR + "0";

	/** 负整数 */
	public static final String NEGATIVE_INTEGER = "-" + POSITIVE_INTEGER;

	/** 负整数或零 */
	public static final String NEGATIVE_INTEGER_OR_ZERO = NEGATIVE_INTEGER + OR + "0";

}
