package com.lichkin.framework.utils;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import org.apache.commons.lang3.ArrayUtils;

import com.lichkin.framework.log.LKLog;
import com.lichkin.framework.log.LKLogFactory;

/**
 * 类扫描工具类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class LKClassScanner {

	/** 日志对象 */
	private static final LKLog LOGGER = LKLogFactory.getLog(LKClassScanner.class);

	/** 包名 */
	private static final String PACKAGE_NAME = "com.lichkin";

	/** 点 */
	private static final char DOT = '.';


	/**
	 * 扫描com.lichkin包中的类
	 * @param annotationClassNames 注解类名称
	 * @return 类列表
	 * @throws IOException IOException
	 */
	public static List<Class<?>> scanClasses(String... annotationClassNames) throws IOException {
		return scanClasses(PACKAGE_NAME, true, annotationClassNames);
	}


	/**
	 * 扫描类
	 * @param packageName 包名
	 * @param recursive 是否递归扫描
	 * @param annotationClassNames 注解类名称
	 * @return 类列表
	 * @throws IOException IOException
	 */
	public static List<Class<?>> scanClasses(String packageName, boolean recursive, String... annotationClassNames) throws IOException {
		LOGGER.info("scan classes from %s", packageName);
		List<Class<?>> classes = new ArrayList<>();
		Enumeration<URL> iterator = Thread.currentThread().getContextClassLoader().getResources(packageName.replace(DOT, File.separatorChar));
		while (iterator.hasMoreElements()) {
			URL url = iterator.nextElement();
			switch (url.getProtocol()) {
				case "file":
					try {
						classes.addAll(scanClassesInFilePath(Paths.get(url.toURI()), packageName, recursive, annotationClassNames));
					} catch (URISyntaxException e) {
						e.printStackTrace();// ignore this
					}
				break;
				case "jar":
				// classes.addAll(getClassInJar(url, packageName, recursive));
				break;
			}
		}
		return classes;
	}


	/**
	 * 在文件目录中扫描类
	 * @param path 路径
	 * @param packageName 包名
	 * @param annotationClassNames 注解类名称
	 * @param recursive 是否递归扫描
	 * @return 类列表
	 * @throws IOException IOException
	 */
	public static List<Class<?>> scanClassesInFilePath(Path path, String packageName, boolean recursive, String... annotationClassNames) throws IOException {
		List<Class<?>> classes = new ArrayList<>();
		if (Files.isDirectory(path)) {
			if (recursive) {
				@SuppressWarnings("resource")
				Stream<Path> stream = Files.list(path);
				for (Iterator<Path> iterator = stream.iterator(); iterator.hasNext();) {
					classes.addAll(scanClassesInFilePath(iterator.next(), packageName, recursive, annotationClassNames));
				}
			}
		} else {
			path = path.toRealPath();
			String pathStr = path.toString();
			if (pathStr.endsWith(".class")) {
				int end = pathStr.lastIndexOf(".class");
				String className = pathStr.replace(File.separatorChar, DOT);
				int start = className.lastIndexOf(packageName);
				if (start != -1) {
					className = (end == -1) ? className.substring(start) : className.substring(start, end);
					try {
						Class<?> clazz = Class.forName(className);
						if (ArrayUtils.isNotEmpty(annotationClassNames)) {
							for (String annotationClassName : annotationClassNames) {
								if (LKClassUtils.containsAnnotation(clazz, annotationClassName)) {
									classes.add(clazz);
									break;
								}
							}
						}
					} catch (ClassNotFoundException e) {
						e.printStackTrace();// ignore this
					}
				}
			}
		}
		return classes;
	}

}
