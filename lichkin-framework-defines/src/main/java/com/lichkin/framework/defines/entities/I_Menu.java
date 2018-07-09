package com.lichkin.framework.defines.entities;

import com.lichkin.framework.defines.enums.impl.LKYesNoEnum;

/**
 * 菜单接口
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public interface I_Menu extends I_ID {

	/**
	 * 获取上级菜单编码
	 * @return 上级菜单编码
	 */
	public String getParentCode();


	/**
	 * 设置上级菜单编码
	 * @param parentCode 上级菜单编码
	 */
	public void setParentCode(String parentCode);


	/**
	 * 获取菜单编码
	 * @return 菜单编码
	 */
	public String getMenuCode();


	/**
	 * 设置菜单编码
	 * @param menuCode 菜单编码
	 */
	public void setMenuCode(String menuCode);


	/**
	 * 获取菜单名称
	 * @return 菜单名称
	 */
	public String getMenuName();


	/**
	 * 设置菜单名称
	 * @param menuName 菜单名称
	 */
	public void setMenuName(String menuName);


	/**
	 * 获取链接地址
	 * @return 链接地址
	 */
	public String getUrl();


	/**
	 * 设置链接地址
	 * @param url 链接地址
	 */
	public void setUrl(String url);


	/**
	 * 获取排序号
	 * @return 排序号
	 */
	public Short getOrderId();


	/**
	 * 设置排序号
	 * @param orderId 排序号
	 */
	public void setOrderId(Short orderId);


	/**
	 * 获取图标
	 * @return 图标
	 */
	public String getIcon();


	/**
	 * 设置图标
	 * @param icon 图标
	 */
	public void setIcon(String icon);


	/**
	 * 获取是否可分配
	 * @return 是否可分配
	 */
	public LKYesNoEnum getAssignable();


	/**
	 * 设置是否可分配
	 * @param assignable 是否可分配
	 */
	public void setAssignable(LKYesNoEnum assignable);


	/**
	 * 获取是否需要权限
	 * @return 是否需要权限
	 */
	public LKYesNoEnum getAuth();


	/**
	 * 设置是否需要权限
	 * @param auth 是否需要权限
	 */
	public void setAuth(LKYesNoEnum auth);

}
