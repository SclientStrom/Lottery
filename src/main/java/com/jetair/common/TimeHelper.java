package com.jetair.common;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeHelper {
	/**
	 * 返回当前时间。
	 * @return Date
	 */
	public static Date getCurrentDate(){
		Calendar calendar=Calendar.getInstance();
		Date date=calendar.getTime();
		return date;
	}
	/**
	 * 
	 * @param date 
	 * @return str:yyyyMMddHHmmssSSS
	 */
	public static String formatDateToStr(Date date){
		  String dateStr = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(date);
		  return dateStr;
	}
	/**
	 * 
	 * @param date
	 * @return str :SSS
	 */
	public static String formatDateToStr1(Date date){
		  String dateStr = new SimpleDateFormat("SSS").format(date);
		  return dateStr;
	}
	/**
	 * 
	 */
	public static String getCurrentTimeLong(){
		Calendar cal=Calendar.getInstance();
		return String.valueOf(cal.getTimeInMillis());
	}
}
