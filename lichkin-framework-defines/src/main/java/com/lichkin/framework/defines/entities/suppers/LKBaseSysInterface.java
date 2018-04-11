package com.lichkin.framework.defines.entities.suppers;

/**
 * 系统一般业务接口
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public interface LKBaseSysInterface extends LKBaseInterface {

	/**
	 * 获取操作系统编码
	 * @return 操作系统编码
	 */
	public String getSystemTag();


	/**
	 * 设置操作系统编码
	 * @param systemTag 操作系统编码
	 * @deprecated 新增数据时系统将自动注入当前系统标识，如无特殊情况请勿手动设置。
	 */
	@Deprecated
	public void setSystemTag(final String systemTag);


	/**
	 * 获取业务ID
	 * @return 业务ID
	 */
	public String getBusId();


	/**
	 * 设置业务ID
	 * @param busId 业务ID
	 */
	public void setBusId(final String busId);


	/**
	 * 获取校验码
	 * @return 校验码
	 */
	public String getCheckCode();


	/**
	 * 设置校验码
	 * @param checkCode 校验码
	 */
	public void setCheckCode(String checkCode);


	/**
	 * 更新校验码
	 */
	public void updateCheckCode();

}
