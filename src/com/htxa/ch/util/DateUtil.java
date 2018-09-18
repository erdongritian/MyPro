package com.htxa.ch.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public abstract class DateUtil {

	/**
	 * 
	 * 方法描述：根据时间的毫秒数格式化为时分秒格式的字符串
	 * 创建时间:2014-7-17
	 * 更新时间:2014-7-17
	 * @param millsecond
	 * @return
	 */
	public static String formatTime(long millsecond) {
		long ms = millsecond % 1000;
		long second = millsecond / 1000 % 60;
		long minute = millsecond / 1000 / 60 % 60;
		long hour = millsecond / 1000 / 60 / 60;
//		return "" + hour + "时" + minute + "分" + second + "秒" + ms + "毫秒";
		return "["+minute + "分" + second + "秒" + ms + "毫秒]";
	}

	public static String getDateBefore90Days() {
		Calendar calendar = Calendar.getInstance();
//		calendar.add(Calendar.DATE, -90);
		calendar.add(Calendar.DATE, -360);
		return format(calendar.getTime(), "yyyy-MM-dd 00:00:00");
	}

	public static String format(Date date) {
		return format(date, "yyyy-MM-dd HH:mm:ss");
	}

	public static String format(Date date, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
	}

	public static Date parse(String dateStr) throws ParseException {
		return parse(dateStr, "yyyyMMdd HH:mm:ss");
	}

	public static Date parse(String dateStr, String pattern) throws ParseException {
		dateStr = dateStr.replaceAll("[\\.|-]", "");
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.parse(dateStr);
	}

	/**
	 * +-N个月
	 * @param date
	 * @param month
	 * @return
	 */
	public static Date month(Date date, int month) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, month);
		return calendar.getTime();
	}

	/**
	 * +-N个天
	 * @param date
	 * @param day
	 * @return
	 */
	public static Date day(Date date, int day) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, day);
		return calendar.getTime();
	}

	/**
	 * 当前日期+-month个月,+-day天
	 * @param date
	 * @param month
	 * @return
	 */
	public static Date monthDay(Date date, int month, int day) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, month);
		calendar.add(Calendar.DATE, day);
		return calendar.getTime();
	}

	public static void main(String[] args) {
		System.out.println(format(DateUtil.month(new Date(), -1)));
	}

}
