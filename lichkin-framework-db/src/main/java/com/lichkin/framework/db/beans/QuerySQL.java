package com.lichkin.framework.db.beans;

import static com.lichkin.framework.db.beans.__SQL_STATICS.AND;
import static com.lichkin.framework.db.beans.__SQL_STATICS.DISTINCT;
import static com.lichkin.framework.db.beans.__SQL_STATICS.FROM;
import static com.lichkin.framework.db.beans.__SQL_STATICS.FULL_JOIN;
import static com.lichkin.framework.db.beans.__SQL_STATICS.INNER_JOIN;
import static com.lichkin.framework.db.beans.__SQL_STATICS.JOIN;
import static com.lichkin.framework.db.beans.__SQL_STATICS.LEFT_JOIN;
import static com.lichkin.framework.db.beans.__SQL_STATICS.ON;
import static com.lichkin.framework.db.beans.__SQL_STATICS.OR;
import static com.lichkin.framework.db.beans.__SQL_STATICS.RIGHT_JOIN;
import static com.lichkin.framework.db.beans.__SQL_STATICS.SELECT;
import static com.lichkin.framework.defines.LKStringStatics.BLANK;
import static com.lichkin.framework.defines.LKStringStatics.COMMA;
import static com.lichkin.framework.defines.LKStringStatics.DOT;
import static com.lichkin.framework.defines.LKStringStatics.STAR;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.lichkin.framework.defines.beans.LKPageable;
import com.lichkin.framework.defines.enums.impl.LKErrorCodesEnum;
import com.lichkin.framework.defines.exceptions.LKRuntimeException;

import lombok.RequiredArgsConstructor;

/**
 * SQL语句 -&gt; 查询语句
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class QuerySQL extends _SQL_WITH_WHERE {

	/** 是否使用DISTINCT */
	private final boolean distinct;

	/** 表映射类型 */
	private final Class<?> tableClazz;


	/**
	 * 构造方法（useSQL:true,distinct:false）
	 * @param tableClazz 表映射类型
	 */
	public QuerySQL(Class<?> tableClazz) {
		this(true, tableClazz, false);
	}


	/**
	 * 构造方法（useSQL:true）
	 * @param tableClazz 表映射类型
	 * @param distinct 是否使用DISTINCT
	 */
	public QuerySQL(Class<?> tableClazz, boolean distinct) {
		this(true, tableClazz, distinct);
	}


	/**
	 * 构造方法
	 * @param useSQL true:SQL;false:HQL.
	 * @param tableClazz 表映射类型
	 */
	public QuerySQL(boolean useSQL, Class<?> tableClazz) {
		this(useSQL, tableClazz, false);
	}


	/**
	 * 构造方法
	 * @param useSQL true:SQL;false:HQL.
	 * @param tableClazz 表映射类型
	 * @param distinct 是否使用DISTINCT
	 */
	public QuerySQL(boolean useSQL, Class<?> tableClazz, boolean distinct) {
		super(useSQL);
		this.tableClazz = tableClazz;
		this.distinct = distinct;
	}


	/** 列 */
	private final List<__COLUMN> columns = new ArrayList<>();


	/**
	 * 添加列
	 * @param columnResIds 列资源ID
	 */
	public void select(int... columnResIds) {
		for (int resId : columnResIds) {
			columns.add(new __COLUMN(resId));
		}
	}


	/**
	 * 添加列
	 * @param columnResId 列资源ID
	 * @param columnAlias 列别名
	 */
	public void select(int columnResId, String columnAlias) {
		select(0, columnResId, columnAlias);
	}


	/**
	 * 添加列
	 * @param tableIdx 表索引
	 * @param columnResId 列资源ID
	 * @param columnAlias 列别名
	 */
	public void select(int tableIdx, int columnResId, String columnAlias) {
		columns.add(new __COLUMN(tableIdx, columnResId, columnAlias));
	}


	/** 选择表所有列的表资源ID */
	private final List<Class<?>> tableClasses = new ArrayList<>();


	/**
	 * 添加表所有列
	 * @param tableClasses 表映射类型
	 */
	public void selectTable(Class<?>... tableClasses) {
		this.tableClasses.addAll(Arrays.asList(tableClasses));
	}


	/**
	 * 关联表
	 * @author SuZhou LichKin Information Technology Co., Ltd.
	 */
	@RequiredArgsConstructor
	private class JoinTable {

		/** 表映射类型 */
		final Class<?> tableClazz;

		/** 关联类型 */
		final String joinType;

		/** 表索引 */
		int tableIdx = 0;

		/** 条件表达式 */
		List<Condition> conditions = new ArrayList<>();

	}


	/** 关联表 */
	private final List<JoinTable> joinTables = new ArrayList<>();

	/** FROM参数列表 */
	private final List<Object> fromParams = new ArrayList<>();


	/**
	 * 添加关联表达式
	 * @param tableClazz 表映射类型
	 * @param joinType 关联类型
	 * @param condition 条件表达式
	 * @param conditions 条件表达式
	 */
	private void appendJoin(Class<?> tableClazz, String joinType, Condition condition, Condition... conditions) {
		JoinTable joinTable = new JoinTable(tableClazz, joinType);
		if (tableClazz.equals(this.tableClazz)) {
			joinTable.tableIdx++;
		}
		for (int i = joinTables.size() - 1; i >= 0; i--) {
			JoinTable joinTableI = joinTables.get(i);
			if (joinTableI.tableClazz.equals(tableClazz)) {
				joinTable.tableIdx = joinTableI.tableIdx + 1;
				break;
			}
		}
		joinTable.conditions.add(condition);
		fromParams.addAll(condition.getParams());
		joinTable.conditions.addAll(Arrays.asList(conditions));
		for (Condition c : conditions) {
			fromParams.addAll(c.getParams());
		}
		joinTables.add(joinTable);
	}


	/**
	 * JOIN表
	 * @param tableClazz 表映射类型
	 * @param condition 条件表达式
	 * @param conditions 条件表达式
	 */
	public void join(Class<?> tableClazz, Condition condition, Condition... conditions) {
		appendJoin(tableClazz, JOIN, condition, conditions);
	}


	/**
	 * LEFT JOIN表
	 * @param tableClazz 表映射类型
	 * @param condition 条件表达式
	 * @param conditions 条件表达式
	 */
	public void leftJoin(Class<?> tableClazz, Condition condition, Condition... conditions) {
		appendJoin(tableClazz, LEFT_JOIN, condition, conditions);
	}


	/**
	 * RIGHT JOIN表
	 * @param tableClazz 表映射类型
	 * @param condition 条件表达式
	 * @param conditions 条件表达式
	 */
	public void rightJoin(Class<?> tableClazz, Condition condition, Condition... conditions) {
		appendJoin(tableClazz, RIGHT_JOIN, condition, conditions);
	}


	/**
	 * FULL JOIN表
	 * @param tableClazz 表映射类型
	 * @param condition 条件表达式
	 * @param conditions 条件表达式
	 */
	public void fullJoin(Class<?> tableClazz, Condition condition, Condition... conditions) {
		appendJoin(tableClazz, FULL_JOIN, condition, conditions);
	}


	/**
	 * INNER JOIN表
	 * @param tableClazz 表映射类型
	 * @param condition 条件表达式
	 * @param conditions 条件表达式
	 */
	public void innerJoin(Class<?> tableClazz, Condition condition, Condition... conditions) {
		appendJoin(tableClazz, INNER_JOIN, condition, conditions);
	}


	/** 排序信息对象 */
	private Sort sort;


	/**
	 * 设置排序信息
	 * @param sort 排序信息对象
	 */
	public void setSort(Sort sort) {
		if (this.sort == null) {
			this.sort = sort;
		} else {
			this.sort.listOrder.addAll(sort.listOrder);
		}
	}


	/**
	 * 添加排序信息对象
	 * @param orders 排序信息对象
	 */
	public void addOrders(Order... orders) {
		if (sort == null) {
			sort = new Sort();
		}
		sort.addOrders(orders);
	}


	/** 分页信息对象 */
	private LKPageable pageable;


	/**
	 * 获取分页信息对象
	 * @return 分页信息对象
	 */
	@Deprecated
	public LKPageable getPageable() {
		return pageable;
	}


	/**
	 * 设置分页信息
	 * @param pageable 分页信息对象
	 */
	public void setPage(LKPageable pageable) {
		this.pageable = pageable;
	}


	@Override
	StringBuilder getSQL(boolean useSQL) {
		StringBuilder sql = new StringBuilder();

		boolean noTableClasses = tableClasses.isEmpty();
		boolean noColumns = columns.isEmpty();

		sql.append(SELECT);
		if (distinct) {
			sql.append(BLANK).append(DISTINCT);
		}

		if (useSQL) {
			if (!noTableClasses) {
				for (int i = 0; i < tableClasses.size(); i++) {
					Class<?> tableClazz = tableClasses.get(i);
					if (i != 0) {
						sql.append(COMMA);
					}
					sql.append(BLANK).append(getTableAlias(tableClazz));
					if (useSQL) {
						sql.append(DOT).append(STAR);
					}
				}
			}

			if (!noColumns) {
				for (int i = 0; i < columns.size(); i++) {
					__COLUMN column = columns.get(i);
					if ((i != 0) || !noTableClasses) {
						sql.append(COMMA);
					}
					sql.append(BLANK).append(column.getSQL(useSQL));
				}
			}

			if (noTableClasses && noColumns) {
				sql.append(BLANK).append(getTableAlias(tableClazz)).append(DOT).append(STAR);
			}

			sql.append(BLANK);
		} else {
			if (!noColumns) {
				throw new LKRuntimeException(LKErrorCodesEnum.SQL_ERROR);
			}
			sql.append(BLANK).append(getTableAlias(tableClazz)).append(BLANK);
		}

		sql.append(FROM).append(BLANK).append(getTableSQL(useSQL, tableClazz, 0));
		for (JoinTable joinTable : joinTables) {
			sql.append(BLANK).append(joinTable.joinType).append(BLANK);
			sql.append(getTableSQL(useSQL, joinTable.tableClazz, joinTable.tableIdx));

			List<Condition> conditions = joinTable.conditions;
			for (int j = 0; j < conditions.size(); j++) {
				Condition condition = conditions.get(j);
				if (j == 0) {
					sql.append(BLANK).append(ON);
					sql.append(BLANK).append(condition.getSQLWithoutCondition(useSQL));
				} else {
					if (Boolean.FALSE.equals(condition.and)) {
						sql.append(BLANK).append(OR).append(BLANK).append(condition.getSQLWithoutCondition(useSQL));
					} else {
						sql.append(BLANK).append(AND).append(BLANK).append(condition.getSQLWithoutCondition(useSQL));
					}
				}
			}
		}

		if (where != null) {
			sql.append(where.getSQL(useSQL));
		}

		if (sort != null) {
			sql.append(sort.getSQL(useSQL));
		}

		return sql;
	}


	/**
	 * 获取参数列表
	 * @return 参数列表
	 * @deprecated 框架内部使用
	 */
	@Override
	@Deprecated
	public Object[] getParams() {
		List<Object> params = new ArrayList<>();
		params.addAll(fromParams);
		if (where != null) {
			params.addAll(where.params);
		}
		return params.toArray();
	}

}
