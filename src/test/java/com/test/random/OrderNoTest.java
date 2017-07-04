package com.test.random;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

public class OrderNoTest {

	@Test
	public void  genOrderNo(){
		String orderType="";
	    Date curDate = new Date();
	    String dateStr4yyyyMMddHHmmss = new SimpleDateFormat("yyyyMMddHHmmss").format(curDate);
	    String dateStr4SSS = new SimpleDateFormat("SSS").format(curDate);
	    System.out.println(dateStr4SSS);
	    String random = RandomStringUtils.random(4,false,true);
	    String test= orderType+dateStr4yyyyMMddHHmmss+random+dateStr4SSS;
	    System.out.println(test);
	    System.out.println("UUID.randomUUID() = " + UUID.randomUUID());
	    System.out.println(Integer.MAX_VALUE);
	    char c= 04+56;
	    System.out.println(c);
	}
}
