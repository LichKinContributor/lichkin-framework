package com.lichkin.framework.db.vos;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * 单返回值对象类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Getter
@Setter
public class LKOneVo implements Serializable {

	/** serialVersionUID */
	private static final long serialVersionUID = 652650731858245714L;

	/** 单返回值 */
	private Object one;

}
