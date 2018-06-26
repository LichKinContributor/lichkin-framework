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
	 * 获取表别名
	 * @param tableClazz 表映射类型
	 * @return 表别名
	 */
	String getTableAlias(Class<?> tableClazz) {
		return LKDBResource.getTableResource(tableClazz).getTableAlias();
	}


	/**
	 * 获取表SQL。表名 AS 表别名。
	 * @param useSQL true:SQL;false:HQL.
	 * @param tableClazz 表映射类型
	 * @return SQL语句
	 */
	StringBuilder getTableSQL(boolean useSQL, Class<?> tableClazz) {
		return getTableSQL(useSQL, tableClazz, 0);
	}


	/**
	 * 获取表SQL。表名 AS 表别名。
	 * @param useSQL true:SQL;false:HQL.
	 * @param tableClazz 表映射类型
	 * @param tableIdx 表索引
	 * @return SQL语句
	 */
	StringBuilder getTableSQL(boolean useSQL, Class<?> tableClazz, int tableIdx) {
		LKDBResource.TableResource tableResource = LKDBResource.getTableResource(tableClazz);
		StringBuilder sql = new StringBuilder();
		sql.append(useSQL ? tableResource.getTableName() : tableResource.getClassName()).append(BLANK).append(AS).append(BLANK).append(tableResource.getTableAlias() + tableIdx);
		return sql;
	}


	/**
	 * 获取列SQL。表别名.列名。
	 * @param useSQL true:SQL;false:HQL.
	 * @param columnResId 列资源ID
	 * @param tableIdx 表索引
	 * @return SQL语句
	 */
	StringBuilder getColumnSQL(boolean useSQL, int columnResId, int tableIdx) {
		LKDBResource.ColumnResource columnResource = LKDBResource.getColumnResource(columnResId);
		StringBuilder sql = new StringBuilder();
		sql.append(columnResource.getTableAlias() + tableIdx).append(DOT).append(useSQL ? columnResource.getColumnName() : columnResource.getFieldName());
		return sql;
	}


	/**
	 * 获取SQL语句
	 * @param useSQL true:SQL;false:HQL.
	 * @return SQL语句
	 */
	abstract StringBuilder getSQL(boolean useSQL);

}
