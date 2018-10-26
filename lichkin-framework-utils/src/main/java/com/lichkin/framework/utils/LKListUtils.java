package com.lichkin.framework.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.List;

import lombok.AccessLevel;
import lombok.Cleanup;
import lombok.NoArgsConstructor;

/**
 * 列表工具类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LKListUtils {

	@SuppressWarnings("unchecked")
	public static <T> List<T> deepCopy(List<T> list) {
		try {
			@Cleanup
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			@Cleanup
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(list);
			@Cleanup
			ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
			@Cleanup
			ObjectInputStream in = new ObjectInputStream(bais);
			return (List<T>) in.readObject();
		} catch (Exception e) {
			e.printStackTrace();
			return Collections.emptyList();
		}
	}

}
