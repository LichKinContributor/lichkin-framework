package com.lichkin.framework.beans.sources;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SourceSqlDate {

	private java.sql.Date test = new java.sql.Date(new java.util.Date().getTime());

}
