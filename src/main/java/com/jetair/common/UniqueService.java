package com.jetair.common;

import java.util.Date;
import org.apache.commons.lang3.RandomStringUtils;
public class UniqueService {
	public static String getUniqueStr(){
	    Date curDate = TimeHelper.getCurrentDate();
	    String dateStr4yyyyMMddHHmmss = TimeHelper.formatDateToStr(curDate);
	    String random = RandomStringUtils.random(4,false,true);
	    String test= dateStr4yyyyMMddHHmmss+random;
	    return test;
	}
}
