package com.lichkin.framework.beans.targetes;

import com.lichkin.framework.defines.annotations.DateToString;
import com.lichkin.framework.defines.enums.impl.LKDateTimeTypeEnum;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TargetString {

	@DateToString(LKDateTimeTypeEnum.DATE_ONLY)
	private String test;

}
