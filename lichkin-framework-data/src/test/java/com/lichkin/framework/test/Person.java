package com.lichkin.framework.test;

import java.util.Date;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.lichkin.framework.defines.enums.impl.LKGenderEnum;
import com.lichkin.framework.json.deserializer.LKJsonDeserializer4Date;
import com.lichkin.framework.json.deserializer.LKJsonDeserializer4DateTime;
import com.lichkin.framework.json.serializer.LKJsonSerializer4Date;
import com.lichkin.framework.json.serializer.LKJsonSerializer4DateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Person {

	private String name;

	private Integer age;

	private Boolean married;

	private LKGenderEnum gender;

	@JsonFormat(pattern = "yyyyMMddHHmmss")
	private Date birthday;

	@JsonSerialize(using = LKJsonSerializer4DateTime.class)
	@JsonDeserialize(using = LKJsonDeserializer4DateTime.class)
	private DateTime dateTime;

	@JsonSerialize(using = LKJsonSerializer4Date.class)
	@JsonDeserialize(using = LKJsonDeserializer4Date.class)
	private Date date;

}
