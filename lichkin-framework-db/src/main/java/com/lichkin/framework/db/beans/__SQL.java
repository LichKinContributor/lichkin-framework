package com.lichkin.framework.db.beans;

import static com.lichkin.framework.db.beans.__SQL_STATICS.AS;
import static com.lichkin.framework.defines.LKStringStatics.BLANK;
import static com.lichkin.framework.defines.LKStringStatics.DOT;

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
		StringBuilder sql = new StringBuilder();
		sql.append(columnResource.getTable().getTableAlias()).append(DOT).append(useSQL ? columnResource.getColumnName() : columnResource.getFieldName());
		return sql;
	}


	/**
	 * 获取SQL语句
	 * @param useSQL true:SQL;false:HQL.
	 * @return SQL语句
	 */
	abstract StringBuilder getSQL(boolean useSQL);

}
