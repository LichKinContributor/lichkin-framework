package com.lichkin.framework.xml;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;
import org.junit.Test;

import com.lichkin.framework.defines.enums.impl.LKGenderEnum;
import com.lichkin.framework.test.Person;

public class LKXMLUtilsTester {

	@Test
	public void test_toXML() {
		final Person person = new Person();
		person.setName("小红");
		person.setAge(18);
		person.setMarried(false);
		person.setGender(LKGenderEnum.FEMALE);
		person.setBirthday(new Date());

		person.setDate(new Date());
		person.setDateTime(DateTime.now());

		System.out.println(LKXMLUtils.toXML(person));

		final List<Person> list = new ArrayList<>();
		list.add(person);
		System.out.println(LKXMLUtils.toXML(list));

		final Map<String, Object> map = new HashMap<>();
		map.put("person", person);
		System.out.println(LKXMLUtils.toXML(map));
	}


	@Test
	public void test_toObj() {
		final String personXml = "<Person><name>小红</name><age>18</age><married>false</married><gender>FEMALE</gender><birthday>20180417152953</birthday><dateTime>20180417232953561</dateTime><date>20180417232953540</date></Person>";
		final Person person = LKXMLUtils.toObj(personXml, Person.class);
		System.out.println(person);
	}


	@Test
	public void test_toList() {
		final String listXml = "<ArrayList><item><name>小红</name><age>18</age><married>false</married><gender>FEMALE</gender><birthday>20180417152953</birthday><dateTime>20180417232953561</dateTime><date>20180417232953540</date></item></ArrayList>";
		final List<Person> list = LKXMLUtils.toList(listXml, Person.class);
		System.out.println(list);
	}


	@Test
	public void test_toMap() {
		final String mapXml = "<HashMap><person><name>小红</name><age>18</age><married>false</married><gender>FEMALE</gender><birthday>20180417152953</birthday><dateTime>20180417232953561</dateTime><date>20180417232953540</date></person></HashMap>";
		final Map<?, ?> map = LKXMLUtils.toMap(mapXml);
		System.out.println(map);
	}


	@Test
	public void test_toJson() {
		final String xml = "<HashMap><person><name>小红</name><age>18</age><married>false</married><gender>FEMALE</gender><birthday>20180417152953</birthday><dateTime>20180417232953561</dateTime><date>20180417232953540</date></person></HashMap>";
		System.out.println(LKXMLUtils.toJson(xml));
	}

}
