package com.lichkin.framework.utils;

import java.io.FileOutputStream;
import java.io.OutputStream;

import org.apache.commons.lang3.StringUtils;

import com.lichkin.framework.utils.security.base64.LKBase64Decoder;

import lombok.Cleanup;

/**
 * 图片处理工具类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class LKImageUtils {

	/**
	 * Base64转图片文件
	 * @param base64 Base64字符串
	 * @param imgFilePath 文件全名（相对地址）
	 */
	public static void base64ToImage(String base64, String imgFilePath) {
		if (StringUtils.isBlank(base64)) {
			return;
		}
		try {
			byte[] b = LKBase64Decoder.decode(base64);
			for (int i = 0; i < b.length; ++i) {
				if (b[i] < 0) {
					b[i] += 256;
				}
			}
			@Cleanup
			OutputStream out = new FileOutputStream(imgFilePath);
			out.write(b);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
