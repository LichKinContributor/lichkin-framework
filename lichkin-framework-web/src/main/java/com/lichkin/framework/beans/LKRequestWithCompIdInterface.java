package com.lichkin.framework.beans;

/**
 * 带公司ID的接口请求基本对象类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public interface LKRequestWithCompIdInterface extends LKRequestInterface {

	/** 获取公司ID */
	public String getCompId();


	/** 设置公司ID */
	public void setCompId(String compId);

}
