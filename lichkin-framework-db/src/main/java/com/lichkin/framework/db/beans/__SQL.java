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
	 * @param tableClazz 表映射类型
	 */
	protected StringBuilder getTableSQL(boolean useSQL, Class<?> tableClazz) {
		LKDBResource.TableResource tableResource = LKDBResource.getTableResource(tableClazz);
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
		LKDBResource.ColumnResource columnResource = LKDBResource.getColumnResource(columnResId);
		StringBuilder sql = new StringBuilder();
		sql.append(columnResource.getTableAlias()).append(DOT).append(useSQL ? columnResource.getColumnName() : columnResource.getFieldName());
		return sql;
	}


	/**
	 * 获取SQL语句
	 * @param useSQL true:SQL;false:HQL.
	 * @return SQL语句
	 */
	@Deprecated
	abstract StringBuilder getSQL(boolean useSQL);

}
