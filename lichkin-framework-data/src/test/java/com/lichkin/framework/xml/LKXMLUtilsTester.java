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

		System.out.println(LKXmlUtils.toXml(person));
		System.out.println(LKXmlUtils.toXmlWithExcludes(person, "name", "age"));
		System.out.println(LKXmlUtils.toXmlWithIncludes(person, "age", "name"));

		final List<Person> list = new ArrayList<>();
		list.add(person);
		System.out.println(LKXmlUtils.toXml(list));

		final Map<String, Object> map = new HashMap<>();
		map.put("person", person);
		System.out.println(LKXmlUtils.toXml(map));
	}


	@Test
	public void test_toObj() {
		final String personXml = "<Person><name>小红</name><age>18</age><married>false</married><gender>FEMALE</gender><birthday>20180418141330</birthday><dateTime>20180418221330774</dateTime><date>20180418221330756</date></Person>";
		final Person person = LKXmlUtils.toObj(personXml, Person.class);
		System.out.println(person);
		final String personXml2 = "<Object><name>小红</name><age>18</age><married>false</married><gender>FEMALE</gender><birthday>20180418141330</birthday><dateTime>20180418221330774</dateTime><date>20180418221330756</date></Object>";
		final Person person2 = LKXmlUtils.toObj(personXml2, Person.class);
		System.out.println(person2);
		final String personXml3 = "<item><name>小红</name><age>18</age><married>false</married><gender>FEMALE</gender><birthday>20180418141330</birthday><dateTime>20180418221330774</dateTime><date>20180418221330756</date></item>";
		final Person person3 = LKXmlUtils.toObj(personXml3, Person.class);
		System.out.println(person3);
		final String personXml4 = "<xml><name>小红</name><age>18</age><married>false</married><gender>FEMALE</gender><birthday>20180418141330</birthday><dateTime>20180418221330774</dateTime><date>20180418221330756</date></xml>";
		final Person person4 = LKXmlUtils.toObj(personXml4, Person.class);
		System.out.println(person4);
	}


	@Test
	public void test_toList() {
		final String listXml = "<ArrayList><Person><name>小红</name><age>18</age><married>false</married><gender>FEMALE</gender><birthday>20180418141330</birthday><dateTime>20180418221330774</dateTime><date>20180418221330756</date></Person><Person><name>小红</name><age>18</age><married>false</married><gender>FEMALE</gender><birthday>20180418141330</birthday><dateTime>20180418221330774</dateTime><date>20180418221330756</date></Person></ArrayList>";
		final List<Person> list = LKXmlUtils.toList(listXml, Person.class);
		System.out.println(list);
		// 以下都不行
		final String listXml2 = "<ArrayList><Object><name>小红</name><age>18</age><married>false</married><gender>FEMALE</gender><birthday>20180418142410</birthday><dateTime>20180418222410471</dateTime><date>20180418222410471</date></item><item><name>小红</name><age>18</age><married>false</married><gender>FEMALE</gender><birthday>20180418142410</birthday><dateTime>20180418222410471</dateTime><date>20180418222410471</date></Object></ArrayList>";
		final List<Person> list2 = LKXmlUtils.toList(listXml2, Person.class);
		System.out.println(list2);
		final String listXml3 = "<ArrayList><item><name>小红</name><age>18</age><married>false</married><gender>FEMALE</gender><birthday>20180418141330</birthday><dateTime>20180418221330774</dateTime><date>20180418221330756</date></Person><Person><name>小红</name><age>18</age><married>false</married><gender>FEMALE</gender><birthday>20180418141330</birthday><dateTime>20180418221330774</dateTime><date>20180418221330756</date></item></ArrayList>";
		final List<Person> list3 = LKXmlUtils.toList(listXml3, Person.class);
		System.out.println(list3);
		final String listXml4 = "<ArrayList><xml><name>小红</name><age>18</age><married>false</married><gender>FEMALE</gender><birthday>20180418141330</birthday><dateTime>20180418221330774</dateTime><date>20180418221330756</date></Person><Person><name>小红</name><age>18</age><married>false</married><gender>FEMALE</gender><birthday>20180418141330</birthday><dateTime>20180418221330774</dateTime><date>20180418221330756</date></xml></ArrayList>";
		final List<Person> list4 = LKXmlUtils.toList(listXml4, Person.class);
		System.out.println(list4);
	}


	@Test
	public void test_toMap() {
		final String mapXml = "<Person><name>小红</name><age>18</age><married>false</married><gender>FEMALE</gender><birthday>20180418141330</birthday><dateTime>20180418221330774</dateTime><date>20180418221330756</date></Person>";
		final Map<?, ?> map = LKXmlUtils.toMap(mapXml);
		System.out.println(map);
		final String personXml2 = "<Object><name>小红</name><age>18</age><married>false</married><gender>FEMALE</gender><birthday>20180418141330</birthday><dateTime>20180418221330774</dateTime><date>20180418221330756</date></Object>";
		final Map<?, ?> person2 = LKXmlUtils.toMap(personXml2);
		System.out.println(person2);
		final String personXml3 = "<item><name>小红</name><age>18</age><married>false</married><gender>FEMALE</gender><birthday>20180418141330</birthday><dateTime>20180418221330774</dateTime><date>20180418221330756</date></item>";
		final Map<?, ?> person3 = LKXmlUtils.toMap(personXml3);
		System.out.println(person3);
		final String personXml4 = "<xml><name>小红</name><age>18</age><married>false</married><gender>FEMALE</gender><birthday>20180418141330</birthday><dateTime>20180418221330774</dateTime><date>20180418221330756</date></xml>";
		final Map<?, ?> person4 = LKXmlUtils.toMap(personXml4);
		System.out.println(person4);
		final String mapXml2 = "<HashMap><person><name>小红</name><age>18</age><married>false</married><gender>FEMALE</gender><birthday>20180418142025</birthday><dateTime>20180418222025473</dateTime><date>20180418222025473</date></person></HashMap>";
		final Map<?, ?> map2 = LKXmlUtils.toMap(mapXml2);
		System.out.println(map2);
	}


	@Test
	public void test_toJson() {
		final String xml = "<Person><name>小红</name><age>18</age><married>false</married><gender>FEMALE</gender><birthday>20180418141330</birthday><dateTime>20180418221330774</dateTime><date>20180418221330756</date></Person>";
		System.out.println(LKXmlUtils.toJson(xml));
		final String personXml2 = "<Object><name>小红</name><age>18</age><married>false</married><gender>FEMALE</gender><birthday>20180418141330</birthday><dateTime>20180418221330774</dateTime><date>20180418221330756</date></Object>";
		System.out.println(LKXmlUtils.toJson(personXml2));
		final String personXml3 = "<item><name>小红</name><age>18</age><married>false</married><gender>FEMALE</gender><birthday>20180418141330</birthday><dateTime>20180418221330774</dateTime><date>20180418221330756</date></item>";
		System.out.println(LKXmlUtils.toJson(personXml3));
		final String personXml4 = "<xml><name>小红</name><age>18</age><married>false</married><gender>FEMALE</gender><birthday>20180418141330</birthday><dateTime>20180418221330774</dateTime><date>20180418221330756</date></xml>";
		System.out.println(LKXmlUtils.toJson(personXml4));
	}

}
