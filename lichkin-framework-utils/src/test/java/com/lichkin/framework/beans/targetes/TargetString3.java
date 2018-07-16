package com.lichkin.framework.beans.targetes;

import com.lichkin.framework.defines.annotations.DefaultStringValue;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TargetString3 {

	@DefaultStringValue(DefaultStringValue.TOKEN)
	private String test;

}
