package com.lichkin.framework.defines.beans.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class LKTreeBean {

	private final String id;

	private final String code;

	private final String parentCode;

	private Map<String, Object> params = new HashMap<>();

	private List<LKTreeBean> children = new ArrayList<>();


	public void addParam(String key, Object value) {
		params.put(key, value);
	}


	public void addChild(LKTreeBean bean) {
		children.add(bean);
	}

}
