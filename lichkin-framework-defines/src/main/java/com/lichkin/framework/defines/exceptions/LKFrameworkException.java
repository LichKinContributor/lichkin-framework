package com.lichkin.framework.defines.exceptions;

/**
 * 框架异常
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class LKFrameworkException extends RuntimeException {

	/** serialVersionUID */
	private static final long serialVersionUID = -1111111111111112L;


	/**
	 * 构造方法
	 * @param message 异常信息
	 * @param cause 异常对象
	 */
	public LKFrameworkException(String message, Throwable cause) {
		super(message, cause);
	}


	/**
	 * 构造方法
	 * @param message 异常信息
	 */
	public LKFrameworkException(String message) {
		super(message);
	}


	/**
	 * 构造方法
	 * @param cause 异常对象
	 */
	public LKFrameworkException(Throwable cause) {
		super(cause);
	}

}
