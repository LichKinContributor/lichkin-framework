package com.lichkin.framework.beans.sources;

import org.joda.time.DateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SourceJodaDateTime {

	private DateTime test = DateTime.now();

}
