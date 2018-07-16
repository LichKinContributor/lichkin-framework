package com.lichkin.framework.utils;

import org.junit.Test;

import com.lichkin.framework.beans.sources.SourceJodaDateTime;
import com.lichkin.framework.beans.sources.SourceSqlDate;
import com.lichkin.framework.beans.sources.SourceString;
import com.lichkin.framework.beans.sources.SourceUtilDate;
import com.lichkin.framework.beans.targetes.TargetJodaTime;
import com.lichkin.framework.beans.targetes.TargetSqlDate;
import com.lichkin.framework.beans.targetes.TargetString;
import com.lichkin.framework.beans.targetes.TargetString2;
import com.lichkin.framework.beans.targetes.TargetString3;
import com.lichkin.framework.beans.targetes.TargetString4;
import com.lichkin.framework.beans.targetes.TargetUtilDate;

public class LKBeanUtils_copyProperties {

	@Test
	public void test() {
		System.out.println(LKBeanUtils.newInstance(new SourceUtilDate(), TargetSqlDate.class).getTest().getTime());
		System.out.println(LKBeanUtils.newInstance(new SourceUtilDate(), TargetUtilDate.class).getTest().getTime());
		System.out.println(LKBeanUtils.newInstance(new SourceUtilDate(), TargetJodaTime.class).getTest().getMillis());
		System.out.println(LKBeanUtils.newInstance(new SourceUtilDate(), TargetString.class).getTest());

		System.out.println(LKBeanUtils.newInstance(new SourceSqlDate(), TargetSqlDate.class).getTest().getTime());
		System.out.println(LKBeanUtils.newInstance(new SourceSqlDate(), TargetUtilDate.class).getTest().getTime());
		System.out.println(LKBeanUtils.newInstance(new SourceSqlDate(), TargetJodaTime.class).getTest().getMillis());
		System.out.println(LKBeanUtils.newInstance(new SourceSqlDate(), TargetString.class).getTest());

		System.out.println(LKBeanUtils.newInstance(new SourceJodaDateTime(), TargetSqlDate.class).getTest().getTime());
		System.out.println(LKBeanUtils.newInstance(new SourceJodaDateTime(), TargetUtilDate.class).getTest().getTime());
		System.out.println(LKBeanUtils.newInstance(new SourceJodaDateTime(), TargetJodaTime.class).getTest().getMillis());
		System.out.println(LKBeanUtils.newInstance(new SourceJodaDateTime(), TargetString.class).getTest());

		System.out.println(LKBeanUtils.newInstance(new SourceString("20180817001012123"), TargetSqlDate.class).getTest().getTime());
		System.out.println(LKBeanUtils.newInstance(new SourceString("20180817001012123"), TargetUtilDate.class).getTest().getTime());
		System.out.println(LKBeanUtils.newInstance(new SourceString("20180817001012123"), TargetJodaTime.class).getTest().getMillis());
		System.out.println(LKBeanUtils.newInstance(new SourceString("20180817001012123"), TargetString.class).getTest());

		System.out.println(LKBeanUtils.newInstance(new SourceString(null), TargetSqlDate.class).getTest());
		System.out.println(LKBeanUtils.newInstance(new SourceString(null), TargetUtilDate.class).getTest());
		System.out.println(LKBeanUtils.newInstance(new SourceString(null), TargetJodaTime.class).getTest());
		System.out.println(LKBeanUtils.newInstance(new SourceString(null), TargetString.class).getTest());

		System.out.println(LKBeanUtils.newInstance(new SourceString(null), TargetString2.class).getTest());
		System.out.println(LKBeanUtils.newInstance(new SourceString(null), TargetString3.class).getTest());
		System.out.println(LKBeanUtils.newInstance(new SourceString(null), TargetString4.class).getTest());
	}

}
