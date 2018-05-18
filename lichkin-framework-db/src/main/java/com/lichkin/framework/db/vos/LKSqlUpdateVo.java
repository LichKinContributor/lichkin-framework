package com.lichkin.framework.db.vos;

import static com.lichkin.framework.db.statics.LKSQLStatics.PLACEHOLDER;
import static com.lichkin.framework.db.statics.LKSQLStatics.SET;
import static com.lichkin.framework.db.statics.LKSQLStatics.UPDATE;
import static com.lichkin.framework.defines.LKStringStatics.COMMA;
import static com.lichkin.framework.defines.LKStringStatics.EQUAL;

import java.sql.SQLException;

import com.lichkin.framework.defines.enums.impl.LKErrorCodesEnum;
import com.lichkin.framework.defines.exceptions.LKRuntimeException;

/**
 * SQL更新语句对象类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class LKSqlUpdateVo extends LKSqlVo {

	/** 是否设置过变量 */
	private boolean setted = false;

	/** true使用SQL语句；false使用HQL语句 */
	private boolean isSQL = true;


	/**
	 * 是否使用SQL语句
	 * @return 是否使用SQL语句
	 * @deprecated 框架内部使用
	 */
	@Deprecated
	public boolean isSQL() {
		return isSQL;
	}


	/**
	 * 构造方法
	 * @param clazz Entity类型
	 */
	public LKSqlUpdateVo(Class<?> clazz) {
		this(clazz.getName());
		isSQL = false;
	}


	/**
	 * 构造方法
	 * @param tableName 表名称
	 */
	public LKSqlUpdateVo(String tableName) {
		super();
		appendSql(UPDATE).appendSql(tableName).appendSql(SET);
	}


	/**
	 * 设置值
	 * @param fieldName 字段名
	 * @param param 参数
	 * @return SQL语句对象
	 */
	public LKSqlUpdateVo set(String fieldName, Object param) {
		if (setted) {
			appendSql(COMMA);
		} else {
			setted = true;
		}
		appendSql(fieldName).appendSql(EQUAL).appendSql(PLACEHOLDER).addParam(param);
		return this;
	}


	/**
	 * 获取SQL语句
	 * @return SQL语句
	 * @deprecated 框架内部使用
	 */
	@Deprecated
	@Override
	public String getSql() {
		if (!setted || !whereAppended) {
			throw new LKRuntimeException(LKErrorCodesEnum.SQL_ERROR, new SQLException("update SQL must contains 'SET' AND 'WHERE' statements."));
		}
		return super.getSql();
	}


	@Override
	protected LKSqlVo append(String fieldName, String condition, Boolean isAnd) {
		where();
		return super.append(fieldName, condition, isAnd);
	}


	@Override
	protected LKSqlVo appendIsNull(boolean isNull, String fieldName, Boolean isAnd) {
		where();
		return super.appendIsNull(isNull, fieldName, isAnd);
	}


	@Override
	protected LKSqlVo appendIn(boolean isIn, String fieldName, Object[] params, Boolean isAnd) {
		where();
		return super.appendIn(isIn, fieldName, params, isAnd);
	}

}
