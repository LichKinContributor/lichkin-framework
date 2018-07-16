package com.lichkin.framework.beans.targetes;

import com.lichkin.framework.defines.annotations.DefaultBooleanValue;
import com.lichkin.framework.defines.annotations.DefaultByteValue;
import com.lichkin.framework.defines.annotations.DefaultDoubleValue;
import com.lichkin.framework.defines.annotations.DefaultFloatValue;
import com.lichkin.framework.defines.annotations.DefaultIntegerValue;
import com.lichkin.framework.defines.annotations.DefaultLongValue;
import com.lichkin.framework.defines.annotations.DefaultShortValue;
import com.lichkin.framework.defines.annotations.DefaultStringValue;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TargetBean {

	private String test1;

	@DefaultStringValue(DefaultStringValue.GMT_START)
	private String test2;

	@DefaultStringValue(DefaultStringValue.TOKEN)
	private String test3;

	@DefaultByteValue(1)
	private Byte a;

	@DefaultShortValue(2)
	private Short b;

	@DefaultIntegerValue(3)
	private Integer c;

	@DefaultLongValue(4)
	private Long d;

	@DefaultFloatValue(5)
	private Float e;

	@DefaultDoubleValue(6)
	private Double f;

	@DefaultBooleanValue(true)
	private Boolean g;

}
