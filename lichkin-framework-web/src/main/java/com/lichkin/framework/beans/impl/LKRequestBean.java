package com.lichkin.framework.beans.impl;

import javax.validation.constraints.NotNull;

import com.lichkin.framework.constraints.Date;
import com.lichkin.framework.constraints.Locale;
import com.lichkin.framework.constraints.MixID;
import com.lichkin.framework.constraints.UsingStatus;
import com.lichkin.framework.defines.beans.LKInvokeBean;
import com.lichkin.framework.defines.entities.I_CompId;
import com.lichkin.framework.defines.entities.I_Locale;
import com.lichkin.framework.defines.entities.I_UsingStatus;
import com.lichkin.framework.defines.enums.impl.LKUsingStatusEnum;
import com.lichkin.framework.utils.LKEnumUtils;

import lombok.Getter;
import lombok.Setter;

/**
 * 接口请求基本对象类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Getter
@Setter
public class LKRequestBean implements LKInvokeBean<Datas>, I_Locale, I_CompId, I_UsingStatus {

	/** 统一请求参数 */
	@NotNull
	private Datas datas;

	/** 国际化 */
	@Locale
	private String locale;

	/** 公司ID */
	@MixID
	private String compId;

	/** 在用状态 */
	@UsingStatus
	private String usingStatus;


	@Override
	public LKUsingStatusEnum getUsingStatus() {
		return usingStatus == null ? null : LKEnumUtils.getEnum(LKUsingStatusEnum.class, usingStatus);
	}


	@Override
	public void setUsingStatus(LKUsingStatusEnum usingStatus) {
		if (usingStatus == null) {
			return;
		}
		this.usingStatus = usingStatus.toString();
	}


	/** 开始日期 */
	@Date
	private String startDate;

	/** 结束日期 */
	@Date
	private String endDate;

}
