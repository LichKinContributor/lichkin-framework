package com.lichkin.framework.defines.entities;

/**
 * 角色接口
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public interface I_Role extends I_ID {

	/**
	 * 获取角色名称
	 * @return 角色名称
	 */
	public String getRoleName();


	/**
	 * 设置角色名称
	 * @param roleName 角色名称
	 */
	public void setRoleName(String roleName);


	/**
	 * 获取描述
	 * @return 描述
	 */
	public String getDescription();


	/**
	 * 设置描述
	 * @param description 描述
	 */
	public void setDescription(String description);

}
