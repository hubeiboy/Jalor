package com.jalor.sinponet;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Sinponet_20181017 {

	public static void main(String[] args) {
		/*
		 * int i = 1; while (true) { System.out.println(i++); }
		 */

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-HHmmss");
		Date date = new Date();
		System.out.println("SP-" + sdf.format(date));

		getDaySub("2018-10-15", "2018-10-17");

	}

	/**
	 * <li>功能描述：时间相减得到天数
	 * 
	 * @param beginDateStr
	 * @param endDateStr
	 * @return long
	 * @author Administrator
	 */
	public static long getDaySub(String beginDateStr, String endDateStr) {
		long day = 0;
		java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd");
		java.util.Date beginDate;
		java.util.Date endDate;
		try {
			beginDate = format.parse(beginDateStr);
			endDate = format.parse(endDateStr);
			day = (endDate.getTime() - beginDate.getTime()) / (24 * 60 * 60 * 1000);
			System.out.println("相隔的天数：" + day + "天！");
		} catch (ParseException e) {
			// TODO 自动生成 catch 块
			e.printStackTrace();
		}
		return day;
	}

}
