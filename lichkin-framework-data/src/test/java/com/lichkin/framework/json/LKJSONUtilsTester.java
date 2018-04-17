package com.lichkin.framework.json;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;
import org.junit.Test;

import com.lichkin.framework.defines.enums.impl.LKGenderEnum;
import com.lichkin.framework.test.Person;

public class LKJSONUtilsTester {

	@Test
	public void test_toJSON() {
		final Person person = new Person();
		person.setName("小红");
		person.setAge(18);
		person.setMarried(false);
		person.setGender(LKGenderEnum.FEMALE);
		person.setBirthday(new Date());

		person.setDate(new Date());
		person.setDateTime(DateTime.now());

		System.out.println(LKJSONUtils.toJSON(person));

		final List<Person> list = new ArrayList<>();
		list.add(person);
		System.out.println(LKJSONUtils.toJSON(list));

		final Map<String, Object> map = new HashMap<>();
		map.put("person", person);
		System.out.println(LKJSONUtils.toJSON(map));
	}


	@Test
	public void test_toObj() {
		final String personJson = "{\"name\":\"小红\",\"age\":18,\"married\":false,\"gender\":\"FEMALE\",\"birthday\":\"20180417152301\",\"dateTime\":\"20180417232301137\",\"date\":\"20180417232301093\"}";
		final Person person = LKJSONUtils.toObj(personJson, Person.class);
		System.out.println(person);
	}


	@Test
	public void test_toList() {
		final String listJson = "[{\"name\":\"小红\",\"age\":18,\"married\":false,\"gender\":\"FEMALE\",\"birthday\":\"20180417152301\",\"dateTime\":\"20180417232301137\",\"date\":\"20180417232301093\"}]";
		final List<Person> list = LKJSONUtils.toList(listJson, Person.class);
		System.out.println(list);
	}


	@Test
	public void test_toMap() {
		final String mapJson = "{\"name\":\"小红\",\"age\":18,\"married\":false,\"gender\":\"FEMALE\",\"birthday\":\"20180417152301\",\"dateTime\":\"20180417232301137\",\"date\":\"20180417232301093\"}";
		final Map<?, ?> map = LKJSONUtils.toMap(mapJson);
		System.out.println(map);
	}


	@Test
	public void test_toXML() {
		final String json = "{\"name\":\"小红\",\"age\":18,\"married\":false,\"gender\":\"FEMALE\",\"birthday\":\"20180417152301\",\"dateTime\":\"20180417232301137\",\"date\":\"20180417232301093\"}";
		System.out.println(LKJSONUtils.toXml(json));
	}

}
